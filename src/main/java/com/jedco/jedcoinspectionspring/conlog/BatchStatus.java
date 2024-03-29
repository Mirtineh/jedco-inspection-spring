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
 * <p>Java class for BatchStatus complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BatchStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="banking" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BatchStatusType" /&gt;
 *       &lt;attribute name="sales" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BatchStatusType" /&gt;
 *       &lt;attribute name="shift" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BatchStatusType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchStatus")
public class BatchStatus {

    @XmlAttribute(name = "banking", required = true)
    protected BatchStatusType banking;
    @XmlAttribute(name = "sales", required = true)
    protected BatchStatusType sales;
    @XmlAttribute(name = "shift", required = true)
    protected BatchStatusType shift;

    /**
     * Gets the value of the banking property.
     *
     * @return possible object is
     * {@link BatchStatusType }
     */
    public BatchStatusType getBanking() {
        return banking;
    }

    /**
     * Sets the value of the banking property.
     *
     * @param value allowed object is
     *              {@link BatchStatusType }
     */
    public void setBanking(BatchStatusType value) {
        this.banking = value;
    }

    /**
     * Gets the value of the sales property.
     *
     * @return possible object is
     * {@link BatchStatusType }
     */
    public BatchStatusType getSales() {
        return sales;
    }

    /**
     * Sets the value of the sales property.
     *
     * @param value allowed object is
     *              {@link BatchStatusType }
     */
    public void setSales(BatchStatusType value) {
        this.sales = value;
    }

    /**
     * Gets the value of the shift property.
     *
     * @return possible object is
     * {@link BatchStatusType }
     */
    public BatchStatusType getShift() {
        return shift;
    }

    /**
     * Sets the value of the shift property.
     *
     * @param value allowed object is
     *              {@link BatchStatusType }
     */
    public void setShift(BatchStatusType value) {
        this.shift = value;
    }

}
