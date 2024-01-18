//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.24 at 09:54:18 AM CAT 
//


package com.jedco.jedcoinspectionspring.conlog;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for PingServerState complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PingServerState"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}ServerState"&gt;
 *       &lt;attribute name="roundTripTime" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PingServerState")
@XmlSeeAlso({
        PingAndActivityServerState.class
})
public class PingServerState
        extends ServerState {

    @XmlAttribute(name = "roundTripTime", required = true)
    protected int roundTripTime;

    /**
     * Gets the value of the roundTripTime property.
     */
    public int getRoundTripTime() {
        return roundTripTime;
    }

    /**
     * Sets the value of the roundTripTime property.
     */
    public void setRoundTripTime(int value) {
        this.roundTripTime = value;
    }

}