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
 * <p>Java class for StraightTariffBreakdown complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StraightTariffBreakdown"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.conlog.co.za/xmlvend/base-ext/2.1.1/schema}TariffBreakdown"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rate" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StraightTariffBreakdown", namespace = "http://www.conlog.co.za/xmlvend/base-ext/2.1.1/schema", propOrder = {
        "rate"
})
public class StraightTariffBreakdown
        extends TariffBreakdown {

    protected Currency rate;

    /**
     * Gets the value of the rate property.
     *
     * @return possible object is
     * {@link Currency }
     */
    public Currency getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     *
     * @param value allowed object is
     *              {@link Currency }
     */
    public void setRate(Currency value) {
        this.rate = value;
    }

}
