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
 * <p>Java class for GetVendingServerStateResp complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GetVendingServerStateResp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="serverState" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}ServerState" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetVendingServerStateResp", propOrder = {
        "serverState"
})
public class GetVendingServerStateResp
        extends BaseResp {

    protected ServerState serverState;

    /**
     * Gets the value of the serverState property.
     *
     * @return possible object is
     * {@link ServerState }
     */
    public ServerState getServerState() {
        return serverState;
    }

    /**
     * Sets the value of the serverState property.
     *
     * @param value allowed object is
     *              {@link ServerState }
     */
    public void setServerState(ServerState value) {
        this.serverState = value;
    }

}
