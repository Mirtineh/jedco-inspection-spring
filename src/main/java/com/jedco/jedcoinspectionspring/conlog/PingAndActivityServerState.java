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
 * <p>Java class for PingAndActivityServerState complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PingAndActivityServerState"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PingServerState"&gt;
 *       &lt;attribute name="activityTime" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PingAndActivityServerState")
public class PingAndActivityServerState
        extends PingServerState {

    @XmlAttribute(name = "activityTime", required = true)
    protected int activityTime;

    /**
     * Gets the value of the activityTime property.
     */
    public int getActivityTime() {
        return activityTime;
    }

    /**
     * Sets the value of the activityTime property.
     */
    public void setActivityTime(int value) {
        this.activityTime = value;
    }

}
