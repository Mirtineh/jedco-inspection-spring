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
 * <p>Java class for MakeMerchantDepositResp complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MakeMerchantDepositResp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DepositSuccessful" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="TransactionReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MakeMerchantDepositResp", propOrder = {
        "depositSuccessful",
        "transactionReference"
})
public class MakeMerchantDepositResp
        extends BaseResp {

    @XmlElement(name = "DepositSuccessful")
    protected boolean depositSuccessful;
    @XmlElement(name = "TransactionReference")
    protected String transactionReference;

    /**
     * Gets the value of the depositSuccessful property.
     */
    public boolean isDepositSuccessful() {
        return depositSuccessful;
    }

    /**
     * Sets the value of the depositSuccessful property.
     */
    public void setDepositSuccessful(boolean value) {
        this.depositSuccessful = value;
    }

    /**
     * Gets the value of the transactionReference property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTransactionReference() {
        return transactionReference;
    }

    /**
     * Sets the value of the transactionReference property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTransactionReference(String value) {
        this.transactionReference = value;
    }

}
