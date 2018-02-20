/**
 * 
 */
package org.opentosca.planbuilder.importer.context.impl;

import org.oasis_open.docs.tosca.ns._2011._12.TPolicy;
import org.opentosca.planbuilder.model.tosca.AbstractPolicy;
import org.opentosca.planbuilder.model.tosca.AbstractPolicyType;
import org.opentosca.planbuilder.model.tosca.AbstractProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kalmankepes
 *
 */
public class PolicyImpl extends AbstractPolicy {

	private final static Logger LOG = LoggerFactory.getLogger(PolicyImpl.class);

	private TPolicy policy;
	private DefinitionsImpl defs;

	public PolicyImpl(TPolicy policy, DefinitionsImpl definitions) {
		this.policy = policy;
		this.defs = definitions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opentosca.planbuilder.model.tosca.AbstractPolicy#getName()
	 */
	@Override
	public String getName() {
		return this.policy.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opentosca.planbuilder.model.tosca.AbstractPolicy#getType()
	 */
	@Override
	public AbstractPolicyType getType() {
		if (this.policy == null) {
			LOG.debug("Internal policy is null");
		}

		if (this.policy.getPolicyType() == null) {
			LOG.debug("Internal policyType is null");
		}

		for (AbstractPolicyType policyType : this.defs.getAllPolicyTypes()) {
			if (policyType.getID().equals(this.policy.getPolicyType())) {
				return policyType;
			}

		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opentosca.planbuilder.model.tosca.AbstractPolicy#getProperties()
	 */
	@Override
	public AbstractProperties getProperties() {
		if(this.policy.getAny() != null && !this.policy.getAny().isEmpty()) {			
			return new PropertiesImpl(this.policy.getAny().get(0));
		} else {
			return null;
		}
	}

}