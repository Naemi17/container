// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.2.4-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2018.07.05 at 09:07:58 PM CEST

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
 * &lt;complexType name="IAInvocationRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Params" type="{http://collaboration.org/schema}KeyValueMap"/>
 *         &lt;element name="Doc" type="{http://collaboration.org/schema}Doc"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IAInvocationRequest", propOrder = {"params", "doc"})
public class IAInvocationRequest {

    @XmlElement(name = "Params")
    protected KeyValueMap params;
    @XmlElement(name = "Doc")
    protected Doc doc;

    /**
     * Gets the value of the params property.
     *
     * @return possible object is {@link KeyValueMap }
     */
    public KeyValueMap getParams() {
        return this.params;
    }

    /**
     * Sets the value of the params property.
     *
     * @param value allowed object is {@link KeyValueMap }
     */
    public void setParams(final KeyValueMap value) {
        this.params = value;
    }

    /**
     * Gets the value of the doc property.
     *
     * @return possible object is {@link Doc }
     */
    public Doc getDoc() {
        return this.doc;
    }

    /**
     * Sets the value of the doc property.
     *
     * @param value allowed object is {@link Doc }
     */
    public void setDoc(final Doc value) {
        this.doc = value;
    }
}
