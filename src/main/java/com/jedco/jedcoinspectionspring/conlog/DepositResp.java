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
 * <p>Java class for DepositResp complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DepositResp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="depSlip" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}DepositSlip" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DepositResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
        "depSlip"
})
public class DepositResp
        extends BaseResp {

    protected DepositSlip depSlip;

    /**
     * Gets the value of the depSlip property.
     *
     * @return possible object is
     * {@link DepositSlip }
     */
    public DepositSlip getDepSlip() {
        return depSlip;
    }

    /**
     * Sets the value of the depSlip property.
     *
     * @param value allowed object is
     *              {@link DepositSlip }
     */
    public void setDepSlip(DepositSlip value) {
        this.depSlip = value;
    }

}
