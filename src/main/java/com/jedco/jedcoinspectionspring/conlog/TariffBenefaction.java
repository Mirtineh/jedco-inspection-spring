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
 * <p>Java class for TariffBenefaction complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TariffBenefaction"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="siUnit" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TariffBenefaction")
public class TariffBenefaction {

    @XmlAttribute(name = "description")
    protected String description;
    @XmlAttribute(name = "amount")
    protected String amount;
    @XmlAttribute(name = "siUnit")
    protected String siUnit;

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the amount property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAmount(String value) {
        this.amount = value;
    }

    /**
     * Gets the value of the siUnit property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSiUnit() {
        return siUnit;
    }

    /**
     * Sets the value of the siUnit property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSiUnit(String value) {
        this.siUnit = value;
    }

}