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
 * <p>Java class for ReprintEndBatchResp complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ReprintEndBatchResp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="endBatchReprint" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}EndBatchResp" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReprintEndBatchResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
        "endBatchReprint"
})
public class ReprintEndBatchResp
        extends BaseResp {

    protected EndBatchResp endBatchReprint;

    /**
     * Gets the value of the endBatchReprint property.
     *
     * @return possible object is
     * {@link EndBatchResp }
     */
    public EndBatchResp getEndBatchReprint() {
        return endBatchReprint;
    }

    /**
     * Sets the value of the endBatchReprint property.
     *
     * @param value allowed object is
     *              {@link EndBatchResp }
     */
    public void setEndBatchReprint(EndBatchResp value) {
        this.endBatchReprint = value;
    }

}