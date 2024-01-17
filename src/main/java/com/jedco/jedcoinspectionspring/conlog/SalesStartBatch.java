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

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for SalesStartBatch complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SalesStartBatch"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}StartBatch"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="shiftStartBatch" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ShiftStartBatch" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="seqNo" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SalesStartBatch", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
        "shiftStartBatch"
})
public class SalesStartBatch
        extends StartBatch {

    protected List<ShiftStartBatch> shiftStartBatch;
    @XmlAttribute(name = "seqNo")
    protected String seqNo;

    /**
     * Gets the value of the shiftStartBatch property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the shiftStartBatch property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShiftStartBatch().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShiftStartBatch }
     */
    public List<ShiftStartBatch> getShiftStartBatch() {
        if (shiftStartBatch == null) {
            shiftStartBatch = new ArrayList<ShiftStartBatch>();
        }
        return this.shiftStartBatch;
    }

    /**
     * Gets the value of the seqNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSeqNo() {
        return seqNo;
    }

    /**
     * Sets the value of the seqNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSeqNo(String value) {
        this.seqNo = value;
    }

}
