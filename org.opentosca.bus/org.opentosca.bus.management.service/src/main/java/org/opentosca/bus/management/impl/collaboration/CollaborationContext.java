package org.opentosca.bus.management.impl.collaboration;

import java.util.concurrent.TimeoutException;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.opentosca.bus.management.impl.collaboration.route.ReceiveRequestRoute;
import org.opentosca.bus.management.impl.collaboration.route.ReceiveResponseRoute;
import org.opentosca.bus.management.impl.collaboration.route.SendRequestResponseRoute;
import org.apache.camel.ProducerTemplate;
import org.opentosca.container.core.common.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CollaborationContext of the Management Bus.<br>
 * <br>
 * <p>
 * Copyright 2018 IAAS University of Stuttgart <br>
 * <br>
 * <p>
 * The activator is needed to start the camel context and add the routes for collaboration between
 * different OpenTOSCA instances. Additionally, a producer template is created which can be used by
 * all classes of this bundle to send camel messages.
 */
public class CollaborationContext implements CamelContextAware {

  private CamelContext camelContext;
  private ProducerTemplate producer;

  final private static Logger LOG = LoggerFactory.getLogger(CollaborationContext.class);

  public void start() throws Exception {
    LOG.info("Starting management bus");

    camelContext.setUseBreadcrumb(false);
    camelContext.start();

    // the camel routes are only needed if collaboration is turned on
    if (!Boolean.parseBoolean(Settings.OPENTOSCA_COLLABORATION_MODE)) {
      return;
    }

    LOG.info("Collaboration mode is turned on. Starting camel routes...");
    // Create a producer template for all components of the Management Bus implementation.
    // This is recommended by camel to avoid the usage of too many threads.
    this.producer = camelContext.createProducerTemplate();

    // route to send requests/responses to other OpenTOSCA Containers
    camelContext.addRoutes(new SendRequestResponseRoute(Settings.OPENTOSCA_BROKER_MQTT_USERNAME, Settings.OPENTOSCA_BROKER_MQTT_PASSWORD));
    // route to receive responses by other OpenTOSCA Containers
    camelContext.addRoutes(new ReceiveResponseRoute(Constants.LOCAL_MQTT_BROKER, Constants.RESPONSE_TOPIC, Settings.OPENTOSCA_BROKER_MQTT_USERNAME, Settings.OPENTOSCA_BROKER_MQTT_PASSWORD));

    // if the setting is null or equals the empty string, this Container does not subscribe
    // for requests of other Containers (acts as 'master')
    if (Settings.OPENTOSCA_COLLABORATION_HOSTNAMES == null || Settings.OPENTOSCA_COLLABORATION_HOSTNAMES.equals("")
      || Settings.OPENTOSCA_COLLABORATION_PORTS == null || Settings.OPENTOSCA_COLLABORATION_PORTS.equals("")) {
      LOG.debug("No other Container defined to subscribe for requests. Only started route to send own requests and receive replies.");
      return;
    }
    final String[] collaborationHosts = Settings.OPENTOSCA_COLLABORATION_HOSTNAMES.split(",");
    final String[] collaborationPorts = Settings.OPENTOSCA_COLLABORATION_PORTS.split(",");

    if (collaborationHosts.length != collaborationPorts.length) {
      LOG.error("The number of hostnames and ports of the collaborating hosts must be equal. Hosts: {} Ports: {}", collaborationHosts.length, collaborationPorts.length);
      return;
    }
    // one route per collaborating Container is needed
    for (int i = 0; i < collaborationHosts.length; i++) {
      final String brokerURL = "tcp://" + collaborationHosts[i] + ":" + collaborationPorts[i];
      LOG.debug("Connecting to broker at {}", brokerURL);
      try {
        camelContext.addRoutes(new ReceiveRequestRoute(brokerURL, Constants.REQUEST_TOPIC,
          Settings.OPENTOSCA_BROKER_MQTT_USERNAME, Settings.OPENTOSCA_BROKER_MQTT_PASSWORD));
      } catch (final TimeoutException e) {
        LOG.error("Timeout while connecting to broker at {}. Unable to start route.", brokerURL);
      }
    }
  }

  @Override
  public void setCamelContext(CamelContext camelContext) {
    this.camelContext = camelContext;
  }

  @Override
  public CamelContext getCamelContext() {
    return camelContext;
  }

  public ProducerTemplate getProducer() {
    return producer;
  }
}
