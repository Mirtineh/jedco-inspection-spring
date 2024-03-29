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
 * <p>Java class for PayAccReq complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PayAccReq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reqAmt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency" minOccurs="0"/&gt;
 *         &lt;element name="payType" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PayType" minOccurs="0"/&gt;
 *         &lt;element name="payAccount" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}PayAccount" minOccurs="0"/&gt;
 *         &lt;element name="vendingServerId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PayAccReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
        "reqAmt",
        "payType",
        "payAccount",
        "vendingServerId"
})
public class PayAccReq
        extends BaseReq {

    protected Currency reqAmt;
    protected PayType payType;
    protected PayAccount payAccount;
    protected int vendingServerId;

    /**
     * Gets the value of the reqAmt property.
     *
     * @return possible object is
     * {@link Currency }
     */
    public Currency getReqAmt() {
        return reqAmt;
    }

    /**
     * Sets the value of the reqAmt property.
     *
     * @param value allowed object is
     *              {@link Currency }
     */
    public void setReqAmt(Currency value) {
        this.reqAmt = value;
    }

    /**
     * Gets the value of the payType property.
     *
     * @return possible object is
     * {@link PayType }
     */
    public PayType getPayType() {
        return payType;
    }

    /**
     * Sets the value of the payType property.
     *
     * @param value allowed object is
     *              {@link PayType }
     */
    public void setPayType(PayType value) {
        this.payType = value;
    }

    /**
     * Gets the value of the payAccount property.
     *
     * @return possible object is
     * {@link PayAccount }
     */
    public PayAccount getPayAccount() {
        return payAccount;
    }

    /**
     * Sets the value of the payAccount property.
     *
     * @param value allowed object is
     *              {@link PayAccount }
     */
    public void setPayAccount(PayAccount value) {
        this.payAccount = value;
    }

    /**
     * Gets the value of the vendingServerId property.
     */
    public int getVendingServerId() {
        return vendingServerId;
    }

    /**
     * Sets the value of the vendingServerId property.
     */
    public void setVendingServerId(int value) {
        this.vendingServerId = value;
    }

}
