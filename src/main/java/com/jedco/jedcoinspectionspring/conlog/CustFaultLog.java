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
 * <p>Java class for CustFaultLog complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CustFaultLog"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="custDetail" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}CustDetail" minOccurs="0"/&gt;
 *         &lt;element name="faultReport" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}CustFaultReport" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="refNo" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustFaultLog", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
        "custDetail",
        "faultReport"
})
public class CustFaultLog {

    protected CustDetail custDetail;
    protected CustFaultReport faultReport;
    @XmlAttribute(name = "refNo")
    protected String refNo;

    /**
     * Gets the value of the custDetail property.
     *
     * @return possible object is
     * {@link CustDetail }
     */
    public CustDetail getCustDetail() {
        return custDetail;
    }

    /**
     * Sets the value of the custDetail property.
     *
     * @param value allowed object is
     *              {@link CustDetail }
     */
    public void setCustDetail(CustDetail value) {
        this.custDetail = value;
    }

    /**
     * Gets the value of the faultReport property.
     *
     * @return possible object is
     * {@link CustFaultReport }
     */
    public CustFaultReport getFaultReport() {
        return faultReport;
    }

    /**
     * Sets the value of the faultReport property.
     *
     * @param value allowed object is
     *              {@link CustFaultReport }
     */
    public void setFaultReport(CustFaultReport value) {
        this.faultReport = value;
    }

    /**
     * Gets the value of the refNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRefNo() {
        return refNo;
    }

    /**
     * Sets the value of the refNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRefNo(String value) {
        this.refNo = value;
    }

}
