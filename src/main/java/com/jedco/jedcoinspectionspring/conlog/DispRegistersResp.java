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
 * <p>Java class for DispRegistersResp complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DispRegistersResp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngResp"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dispRegisters" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}DispRegistersTokenIssue" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispRegistersResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
        "dispRegisters"
})
public class DispRegistersResp
        extends NonMeterSpecificEngResp {

    protected DispRegistersTokenIssue dispRegisters;

    /**
     * Gets the value of the dispRegisters property.
     *
     * @return possible object is
     * {@link DispRegistersTokenIssue }
     */
    public DispRegistersTokenIssue getDispRegisters() {
        return dispRegisters;
    }

    /**
     * Sets the value of the dispRegisters property.
     *
     * @param value allowed object is
     *              {@link DispRegistersTokenIssue }
     */
    public void setDispRegisters(DispRegistersTokenIssue value) {
        this.dispRegisters = value;
    }

}
