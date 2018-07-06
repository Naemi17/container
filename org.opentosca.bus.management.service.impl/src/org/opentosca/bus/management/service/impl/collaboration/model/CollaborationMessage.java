//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.2.4-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2018.07.05 at 09:07:58 PM CEST
//


package org.opentosca.bus.management.service.impl.collaboration.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="collaborationMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HeaderMap" type="{http://collaboration.org/schema}KeyValueMap"/>
 *         &lt;element name="Body" type="{http://collaboration.org/schema}BodyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CollaborationMessage", propOrder = {"headerMap", "body"})
public class CollaborationMessage {

    @XmlElement(name = "HeaderMap", required = true)
    protected KeyValueMap headerMap;
    @XmlElement(name = "Body")
    protected BodyType body;

    public CollaborationMessage() {}

    public CollaborationMessage(final KeyValueMap headerMap, final BodyType body) {
        this.headerMap = headerMap;
        this.body = body;
    }

    /**
     * Gets the value of the headerMap property.
     *
     * @return possible object is {@link KeyValueMap }
     *
     */
    public KeyValueMap getHeaderMap() {
        return this.headerMap;
    }

    /**
     * Sets the value of the headerMap property.
     *
     * @param value allowed object is {@link KeyValueMap }
     *
     */
    public void setHeaderMap(final KeyValueMap value) {
        this.headerMap = value;
    }

    /**
     * Gets the value of the body property.
     *
     * @return possible object is {@link BodyType }
     *
     */
    public BodyType getBody() {
        return this.body;
    }

    /**
     * Sets the value of the body property.
     *
     * @param value allowed object is {@link BodyType }
     *
     */
    public void setBody(final BodyType value) {
        this.body = value;
    }
}
