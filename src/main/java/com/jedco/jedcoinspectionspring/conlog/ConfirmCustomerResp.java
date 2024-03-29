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

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ConfirmCustomerResp complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ConfirmCustomerResp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="confirmCustResult" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ConfirmCustResult" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="CustomerNotes" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}CustomerNotes" minOccurs="0"/&gt;
 *         &lt;element name="CisVendingServerDetail" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}CisVendingServerDetail" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmCustomerResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
        "confirmCustResult",
        "customerNotes",
        "cisVendingServerDetail"
})
public class ConfirmCustomerResp
        extends BaseResp {

    protected List<ConfirmCustResult> confirmCustResult;
    @XmlElement(name = "CustomerNotes")
    protected CustomerNotes customerNotes;
    @XmlElement(name = "CisVendingServerDetail")
    protected CisVendingServerDetail cisVendingServerDetail;

    /**
     * Gets the value of the confirmCustResult property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the confirmCustResult property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfirmCustResult().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConfirmCustResult }
     */
    public List<ConfirmCustResult> getConfirmCustResult() {
        if (confirmCustResult == null) {
            confirmCustResult = new ArrayList<ConfirmCustResult>();
        }
        return this.confirmCustResult;
    }

    /**
     * Gets the value of the customerNotes property.
     *
     * @return possible object is
     * {@link CustomerNotes }
     */
    public CustomerNotes getCustomerNotes() {
        return customerNotes;
    }

    /**
     * Sets the value of the customerNotes property.
     *
     * @param value allowed object is
     *              {@link CustomerNotes }
     */
    public void setCustomerNotes(CustomerNotes value) {
        this.customerNotes = value;
    }

    /**
     * Gets the value of the cisVendingServerDetail property.
     *
     * @return possible object is
     * {@link CisVendingServerDetail }
     */
    public CisVendingServerDetail getCisVendingServerDetail() {
        return cisVendingServerDetail;
    }

    /**
     * Sets the value of the cisVendingServerDetail property.
     *
     * @param value allowed object is
     *              {@link CisVendingServerDetail }
     */
    public void setCisVendingServerDetail(CisVendingServerDetail value) {
        this.cisVendingServerDetail = value;
    }

}
