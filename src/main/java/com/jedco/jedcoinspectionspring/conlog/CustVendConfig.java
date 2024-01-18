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
 * <p>Java class for CustVendConfig complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CustVendConfig"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="canVend" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="fbeDue" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="maxVendAmt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency" minOccurs="0"/&gt;
 *         &lt;element name="minVendAmt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustVendConfig", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
        "canVend",
        "fbeDue",
        "maxVendAmt",
        "minVendAmt"
})
public class CustVendConfig {

    protected boolean canVend;
    protected Boolean fbeDue;
    protected Currency maxVendAmt;
    protected Currency minVendAmt;

    /**
     * Gets the value of the canVend property.
     */
    public boolean isCanVend() {
        return canVend;
    }

    /**
     * Sets the value of the canVend property.
     */
    public void setCanVend(boolean value) {
        this.canVend = value;
    }

    /**
     * Gets the value of the fbeDue property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isFbeDue() {
        return fbeDue;
    }

    /**
     * Sets the value of the fbeDue property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setFbeDue(Boolean value) {
        this.fbeDue = value;
    }

    /**
     * Gets the value of the maxVendAmt property.
     *
     * @return possible object is
     * {@link Currency }
     */
    public Currency getMaxVendAmt() {
        return maxVendAmt;
    }

    /**
     * Sets the value of the maxVendAmt property.
     *
     * @param value allowed object is
     *              {@link Currency }
     */
    public void setMaxVendAmt(Currency value) {
        this.maxVendAmt = value;
    }

    /**
     * Gets the value of the minVendAmt property.
     *
     * @return possible object is
     * {@link Currency }
     */
    public Currency getMinVendAmt() {
        return minVendAmt;
    }

    /**
     * Sets the value of the minVendAmt property.
     *
     * @param value allowed object is
     *              {@link Currency }
     */
    public void setMinVendAmt(Currency value) {
        this.minVendAmt = value;
    }

}