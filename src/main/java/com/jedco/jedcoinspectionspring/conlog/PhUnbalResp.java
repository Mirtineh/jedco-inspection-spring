//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.24 at 09:54:18 AM CAT 
//


package com.jedco.jedcoinspectionspring.conlog;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PhUnbalResp complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PhUnbalResp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}MeterSpecificEngResp"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="phUnbalance" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PhUnbalTokenIssue" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhUnbalResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
        "phUnbalance"
})
public class PhUnbalResp
        extends MeterSpecificEngResp {

    protected PhUnbalTokenIssue phUnbalance;

    /**
     * Gets the value of the phUnbalance property.
     *
     * @return possible object is
     * {@link PhUnbalTokenIssue }
     */
    public PhUnbalTokenIssue getPhUnbalance() {
        return phUnbalance;
    }

    /**
     * Sets the value of the phUnbalance property.
     *
     * @param value allowed object is
     *              {@link PhUnbalTokenIssue }
     */
    public void setPhUnbalance(PhUnbalTokenIssue value) {
        this.phUnbalance = value;
    }

}
