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
 * <p>Java class for DeviceFault complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DeviceFault"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}MeterFaultReport"&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceFault", namespace = "http://www.eskom.co.za/xmlvend/meter-ext/2.1/schema")
@XmlSeeAlso({
        KeepsTripping.class,
        TokensNotWorking.class,
        NoTrip.class,
        SeriousBoxDamage.class,
        FireWaterDamage.class,
        MeterDead.class,
        DisplayLightsButtons.class
})
public abstract class DeviceFault
        extends MeterFaultReport {


}