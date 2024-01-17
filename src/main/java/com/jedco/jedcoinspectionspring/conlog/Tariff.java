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
 * <p>Java class for Tariff complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Tariff"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TariffSetID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SGC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="baseRateBreakdownSteps" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}TariffBaseRateBreakdownStep" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="baseRate" type="{http://www.conlog.co.za/xmlvend/base-ext/2.1.1/schema}TariffBaseRate" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tariff", propOrder = {
        "name",
        "desc",
        "tariffSetID",
        "sgc",
        "baseRateBreakdownSteps",
        "baseRate"
})
public class Tariff {

    protected String name;
    protected String desc;
    @XmlElement(name = "TariffSetID")
    protected String tariffSetID;
    @XmlElement(name = "SGC")
    protected String sgc;
    protected List<TariffBaseRateBreakdownStep> baseRateBreakdownSteps;
    protected TariffBaseRate baseRate;

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the desc property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Gets the value of the tariffSetID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTariffSetID() {
        return tariffSetID;
    }

    /**
     * Sets the value of the tariffSetID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTariffSetID(String value) {
        this.tariffSetID = value;
    }

    /**
     * Gets the value of the sgc property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSGC() {
        return sgc;
    }

    /**
     * Sets the value of the sgc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSGC(String value) {
        this.sgc = value;
    }

    /**
     * Gets the value of the baseRateBreakdownSteps property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the baseRateBreakdownSteps property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaseRateBreakdownSteps().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TariffBaseRateBreakdownStep }
     */
    public List<TariffBaseRateBreakdownStep> getBaseRateBreakdownSteps() {
        if (baseRateBreakdownSteps == null) {
            baseRateBreakdownSteps = new ArrayList<TariffBaseRateBreakdownStep>();
        }
        return this.baseRateBreakdownSteps;
    }

    /**
     * Gets the value of the baseRate property.
     *
     * @return possible object is
     * {@link TariffBaseRate }
     */
    public TariffBaseRate getBaseRate() {
        return baseRate;
    }

    /**
     * Sets the value of the baseRate property.
     *
     * @param value allowed object is
     *              {@link TariffBaseRate }
     */
    public void setBaseRate(TariffBaseRate value) {
        this.baseRate = value;
    }

}
