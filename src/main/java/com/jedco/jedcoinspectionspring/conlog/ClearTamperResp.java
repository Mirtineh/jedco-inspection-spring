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
 * <p>Java class for ClearTamperResp complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ClearTamperResp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}MeterSpecificEngResp"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="clearTamper" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}ClearTamperTokenIssue" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClearTamperResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
        "clearTamper"
})
public class ClearTamperResp
        extends MeterSpecificEngResp {

    protected ClearTamperTokenIssue clearTamper;

    /**
     * Gets the value of the clearTamper property.
     *
     * @return possible object is
     * {@link ClearTamperTokenIssue }
     */
    public ClearTamperTokenIssue getClearTamper() {
        return clearTamper;
    }

    /**
     * Sets the value of the clearTamper property.
     *
     * @param value allowed object is
     *              {@link ClearTamperTokenIssue }
     */
    public void setClearTamper(ClearTamperTokenIssue value) {
        this.clearTamper = value;
    }

}