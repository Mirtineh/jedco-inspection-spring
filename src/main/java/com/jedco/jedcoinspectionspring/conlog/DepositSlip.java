//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.24 at 09:54:18 AM CAT 
//


package com.jedco.jedcoinspectionspring.conlog;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DepositSlip complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DepositSlip"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="header" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency" minOccurs="0"/&gt;
 *         &lt;element name="beneficiary" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Beneficiary" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="bankingRefNo" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DepositSlip", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
        "header",
        "amt",
        "beneficiary"
})
public class DepositSlip {

    protected String header;
    protected Currency amt;
    protected Beneficiary beneficiary;
    @XmlAttribute(name = "bankingRefNo")
    protected String bankingRefNo;

    /**
     * Gets the value of the header property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHeader(String value) {
        this.header = value;
    }

    /**
     * Gets the value of the amt property.
     *
     * @return possible object is
     * {@link Currency }
     */
    public Currency getAmt() {
        return amt;
    }

    /**
     * Sets the value of the amt property.
     *
     * @param value allowed object is
     *              {@link Currency }
     */
    public void setAmt(Currency value) {
        this.amt = value;
    }

    /**
     * Gets the value of the beneficiary property.
     *
     * @return possible object is
     * {@link Beneficiary }
     */
    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    /**
     * Sets the value of the beneficiary property.
     *
     * @param value allowed object is
     *              {@link Beneficiary }
     */
    public void setBeneficiary(Beneficiary value) {
        this.beneficiary = value;
    }

    /**
     * Gets the value of the bankingRefNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBankingRefNo() {
        return bankingRefNo;
    }

    /**
     * Sets the value of the bankingRefNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBankingRefNo(String value) {
        this.bankingRefNo = value;
    }

}
