//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.24 at 09:54:18 AM CAT 
//


package com.jedco.jedcoinspectionspring.conlog;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NonMeterSpecificEngReq complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NonMeterSpecificEngReq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="meterType" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterType" minOccurs="0"/&gt;
 *         &lt;element name="vendingServerId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="manufacturerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NonMeterSpecificEngReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
        "meterType",
        "vendingServerId",
        "manufacturerCode"
})
@XmlSeeAlso({
        DispTIReq.class,
        DispKRNReq.class,
        DispTamperReq.class,
        DispInstPwrReq.class,
        DispConsTotReq.class,
        DispPhUnbalanceReq.class,
        TestDispenserReq.class,
        TestAllReq.class,
        TestDisplayReq.class,
        DispVerReq.class,
        MenuAccessReq.class,
        DispRegistersReq.class,
        DispPwrLmtReq.class,
        TestBreakerReq.class
})
public abstract class NonMeterSpecificEngReq
        extends BaseReq {

    protected MeterType meterType;
    protected int vendingServerId;
    protected String manufacturerCode;

    /**
     * Gets the value of the meterType property.
     *
     * @return possible object is
     * {@link MeterType }
     */
    public MeterType getMeterType() {
        return meterType;
    }

    /**
     * Sets the value of the meterType property.
     *
     * @param value allowed object is
     *              {@link MeterType }
     */
    public void setMeterType(MeterType value) {
        this.meterType = value;
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

    /**
     * Gets the value of the manufacturerCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getManufacturerCode() {
        return manufacturerCode;
    }

    /**
     * Sets the value of the manufacturerCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setManufacturerCode(String value) {
        this.manufacturerCode = value;
    }

}
