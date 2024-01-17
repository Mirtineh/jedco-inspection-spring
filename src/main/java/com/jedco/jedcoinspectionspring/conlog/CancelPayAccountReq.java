//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.24 at 09:54:18 AM CAT 
//


package com.jedco.jedcoinspectionspring.conlog;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CancelPayAccountReq complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CancelPayAccountReq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SubAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Amount" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency" minOccurs="0"/&gt;
 *         &lt;element name="VendingServerId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelPayAccountReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
        "accountNumber",
        "subAccountNumber",
        "amount",
        "vendingServerId"
})
public class CancelPayAccountReq
        extends BaseReq {

    @XmlElement(name = "AccountNumber")
    protected String accountNumber;
    @XmlElement(name = "SubAccountNumber")
    protected String subAccountNumber;
    @XmlElement(name = "Amount")
    protected Currency amount;
    @XmlElement(name = "VendingServerId")
    protected int vendingServerId;

    /**
     * Gets the value of the accountNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the subAccountNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSubAccountNumber() {
        return subAccountNumber;
    }

    /**
     * Sets the value of the subAccountNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSubAccountNumber(String value) {
        this.subAccountNumber = value;
    }

    /**
     * Gets the value of the amount property.
     *
     * @return possible object is
     * {@link Currency }
     */
    public Currency getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     *
     * @param value allowed object is
     *              {@link Currency }
     */
    public void setAmount(Currency value) {
        this.amount = value;
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
