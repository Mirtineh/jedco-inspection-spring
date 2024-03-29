//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.24 at 09:54:18 AM CAT 
//


package com.jedco.jedcoinspectionspring.conlog;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MeterSpecificEng.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="MeterSpecificEng"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SetPwrLmt"/&gt;
 *     &lt;enumeration value="SetPhUnbalance"/&gt;
 *     &lt;enumeration value="AddDefaultCred"/&gt;
 *     &lt;enumeration value="ClearCred"/&gt;
 *     &lt;enumeration value="ClearTamper"/&gt;
 *     &lt;enumeration value="EngKCT"/&gt;
 *     &lt;enumeration value="SetWaterFact"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "MeterSpecificEng")
@XmlEnum
public enum MeterSpecificEng {

    @XmlEnumValue("SetPwrLmt")
    SET_PWR_LMT("SetPwrLmt"),
    @XmlEnumValue("SetPhUnbalance")
    SET_PH_UNBALANCE("SetPhUnbalance"),
    @XmlEnumValue("AddDefaultCred")
    ADD_DEFAULT_CRED("AddDefaultCred"),
    @XmlEnumValue("ClearCred")
    CLEAR_CRED("ClearCred"),
    @XmlEnumValue("ClearTamper")
    CLEAR_TAMPER("ClearTamper"),
    @XmlEnumValue("EngKCT")
    ENG_KCT("EngKCT"),
    @XmlEnumValue("SetWaterFact")
    SET_WATER_FACT("SetWaterFact");
    private final String value;

    MeterSpecificEng(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MeterSpecificEng fromValue(String v) {
        for (MeterSpecificEng c : MeterSpecificEng.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
