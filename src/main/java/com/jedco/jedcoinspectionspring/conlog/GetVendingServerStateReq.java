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
 * <p>Java class for GetVendingServerStateReq complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GetVendingServerStateReq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="serverID" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}DeviceID" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetVendingServerStateReq", propOrder = {
        "serverID"
})
public class GetVendingServerStateReq
        extends BaseReq {

    protected DeviceID serverID;

    /**
     * Gets the value of the serverID property.
     *
     * @return possible object is
     * {@link DeviceID }
     */
    public DeviceID getServerID() {
        return serverID;
    }

    /**
     * Sets the value of the serverID property.
     *
     * @param value allowed object is
     *              {@link DeviceID }
     */
    public void setServerID(DeviceID value) {
        this.serverID = value;
    }

}
