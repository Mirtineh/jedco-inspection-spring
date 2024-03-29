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
 * <p>Java class for CMFTToken complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CMFTToken"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Token"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Cipher1" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STS1Token" minOccurs="0"/&gt;
 *         &lt;element name="Cipher2" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STS1Token" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CMFTToken", propOrder = {
        "cipher1",
        "cipher2"
})
public class CMFTToken
        extends Token {

    @XmlElement(name = "Cipher1")
    protected STS1Token cipher1;
    @XmlElement(name = "Cipher2")
    protected STS1Token cipher2;

    /**
     * Gets the value of the cipher1 property.
     *
     * @return possible object is
     * {@link STS1Token }
     */
    public STS1Token getCipher1() {
        return cipher1;
    }

    /**
     * Sets the value of the cipher1 property.
     *
     * @param value allowed object is
     *              {@link STS1Token }
     */
    public void setCipher1(STS1Token value) {
        this.cipher1 = value;
    }

    /**
     * Gets the value of the cipher2 property.
     *
     * @return possible object is
     * {@link STS1Token }
     */
    public STS1Token getCipher2() {
        return cipher2;
    }

    /**
     * Sets the value of the cipher2 property.
     *
     * @param value allowed object is
     *              {@link STS1Token }
     */
    public void setCipher2(STS1Token value) {
        this.cipher2 = value;
    }

}
