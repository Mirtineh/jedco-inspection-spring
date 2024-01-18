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
 * <p>Java class for MeterCreditTransferReq complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MeterCreditTransferReq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseVendReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="chgOutUnits" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}PurchaseValueUnits" minOccurs="0"/&gt;
 *         &lt;element name="creditTransferDetail" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}CreditTransferDetail" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterCreditTransferReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
        "chgOutUnits",
        "creditTransferDetail"
})
public class MeterCreditTransferReq
        extends BaseVendReq {

    protected PurchaseValueUnits chgOutUnits;
    protected CreditTransferDetail creditTransferDetail;

    /**
     * Gets the value of the chgOutUnits property.
     *
     * @return possible object is
     * {@link PurchaseValueUnits }
     */
    public PurchaseValueUnits getChgOutUnits() {
        return chgOutUnits;
    }

    /**
     * Sets the value of the chgOutUnits property.
     *
     * @param value allowed object is
     *              {@link PurchaseValueUnits }
     */
    public void setChgOutUnits(PurchaseValueUnits value) {
        this.chgOutUnits = value;
    }

    /**
     * Gets the value of the creditTransferDetail property.
     *
     * @return possible object is
     * {@link CreditTransferDetail }
     */
    public CreditTransferDetail getCreditTransferDetail() {
        return creditTransferDetail;
    }

    /**
     * Sets the value of the creditTransferDetail property.
     *
     * @param value allowed object is
     *              {@link CreditTransferDetail }
     */
    public void setCreditTransferDetail(CreditTransferDetail value) {
        this.creditTransferDetail = value;
    }

}