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
 * <p>Java class for KCToken complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="KCToken"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Token"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="set1stMeterKey" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STS1Token" minOccurs="0"/&gt;
 *         &lt;element name="set2ndMeterKey" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STS1Token" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KCToken", propOrder = {
        "set1StMeterKey",
        "set2NdMeterKey"
})
public class KCToken
        extends Token {

    @XmlElement(name = "set1stMeterKey")
    protected STS1Token set1StMeterKey;
    @XmlElement(name = "set2ndMeterKey")
    protected STS1Token set2NdMeterKey;

    /**
     * Gets the value of the set1StMeterKey property.
     *
     * @return possible object is
     * {@link STS1Token }
     */
    public STS1Token getSet1StMeterKey() {
        return set1StMeterKey;
    }

    /**
     * Sets the value of the set1StMeterKey property.
     *
     * @param value allowed object is
     *              {@link STS1Token }
     */
    public void setSet1StMeterKey(STS1Token value) {
        this.set1StMeterKey = value;
    }

    /**
     * Gets the value of the set2NdMeterKey property.
     *
     * @return possible object is
     * {@link STS1Token }
     */
    public STS1Token getSet2NdMeterKey() {
        return set2NdMeterKey;
    }

    /**
     * Sets the value of the set2NdMeterKey property.
     *
     * @param value allowed object is
     *              {@link STS1Token }
     */
    public void setSet2NdMeterKey(STS1Token value) {
        this.set2NdMeterKey = value;
    }

}