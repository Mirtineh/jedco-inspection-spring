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
 * <p>Java class for ExtMeterDetail complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ExtMeterDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterDetail"&gt;
 *       &lt;attribute name="useSTT" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="track2Data" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtMeterDetail")
public class ExtMeterDetail
        extends MeterDetail {

    @XmlAttribute(name = "useSTT")
    protected Boolean useSTT;
    @XmlAttribute(name = "track2Data")
    protected String track2Data;

    /**
     * Gets the value of the useSTT property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isUseSTT() {
        return useSTT;
    }

    /**
     * Sets the value of the useSTT property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setUseSTT(Boolean value) {
        this.useSTT = value;
    }

    /**
     * Gets the value of the track2Data property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTrack2Data() {
        return track2Data;
    }

    /**
     * Sets the value of the track2Data property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTrack2Data(String value) {
        this.track2Data = value;
    }

}
