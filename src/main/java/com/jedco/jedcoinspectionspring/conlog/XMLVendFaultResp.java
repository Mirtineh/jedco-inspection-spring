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
 * <p>Java class for XMLVendFaultResp complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="XMLVendFaultResp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fault" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Fault" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLVendFaultResp", propOrder = {
        "fault"
})
public class XMLVendFaultResp
        extends BaseResp {

    protected Fault fault;

    /**
     * Gets the value of the fault property.
     *
     * @return possible object is
     * {@link Fault }
     */
    public Fault getFault() {
        return fault;
    }

    /**
     * Sets the value of the fault property.
     *
     * @param value allowed object is
     *              {@link Fault }
     */
    public void setFault(Fault value) {
        this.fault = value;
    }

}
