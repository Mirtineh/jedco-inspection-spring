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
 * <p>Java class for VerifyResp complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VerifyResp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseVendResp"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="creditVendTx" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}CreditVendTx" minOccurs="0"/&gt;
 *         &lt;element name="tokenInfo" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}TokenInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerifyResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
        "creditVendTx",
        "tokenInfo"
})
public class VerifyResp
        extends BaseVendResp {

    protected CreditVendTx creditVendTx;
    protected TokenInfo tokenInfo;

    /**
     * Gets the value of the creditVendTx property.
     *
     * @return possible object is
     * {@link CreditVendTx }
     */
    public CreditVendTx getCreditVendTx() {
        return creditVendTx;
    }

    /**
     * Sets the value of the creditVendTx property.
     *
     * @param value allowed object is
     *              {@link CreditVendTx }
     */
    public void setCreditVendTx(CreditVendTx value) {
        this.creditVendTx = value;
    }

    /**
     * Gets the value of the tokenInfo property.
     *
     * @return possible object is
     * {@link TokenInfo }
     */
    public TokenInfo getTokenInfo() {
        return tokenInfo;
    }

    /**
     * Sets the value of the tokenInfo property.
     *
     * @param value allowed object is
     *              {@link TokenInfo }
     */
    public void setTokenInfo(TokenInfo value) {
        this.tokenInfo = value;
    }

}