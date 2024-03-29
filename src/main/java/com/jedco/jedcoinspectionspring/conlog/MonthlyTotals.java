//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.24 at 09:54:18 AM CAT 
//


package com.jedco.jedcoinspectionspring.conlog;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MonthlyTotals complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MonthlyTotals"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Debts" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Total" minOccurs="0"/&gt;
 *         &lt;element name="TransactionAmount" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Total" minOccurs="0"/&gt;
 *         &lt;element name="FixedCharge" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Total" minOccurs="0"/&gt;
 *         &lt;element name="StepPctCharge" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Total" minOccurs="0"/&gt;
 *         &lt;element name="StepFixedCharge" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Total" minOccurs="0"/&gt;
 *         &lt;element name="IndivAccPctCharge" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Total" minOccurs="0"/&gt;
 *         &lt;element name="PurchaseTax" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Total" minOccurs="0"/&gt;
 *         &lt;element name="StampDuty" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Total" minOccurs="0"/&gt;
 *         &lt;element name="ServiceFeeAmount" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Total" minOccurs="0"/&gt;
 *         &lt;element name="ServiceCharge" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Total" minOccurs="0"/&gt;
 *         &lt;element name="CostOfUnits" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Total" minOccurs="0"/&gt;
 *         &lt;element name="Units" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Total" minOccurs="0"/&gt;
 *         &lt;element name="AddChargesMonthlyList" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}AddChargesMonthlyList" minOccurs="0"/&gt;
 *         &lt;element name="StepsUnitsCost" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}StepsUnitsCost" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MonthlyTotals", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
        "debts",
        "transactionAmount",
        "fixedCharge",
        "stepPctCharge",
        "stepFixedCharge",
        "indivAccPctCharge",
        "purchaseTax",
        "stampDuty",
        "serviceFeeAmount",
        "serviceCharge",
        "costOfUnits",
        "units",
        "addChargesMonthlyList",
        "stepsUnitsCost"
})
public class MonthlyTotals {

    @XmlElement(name = "Debts")
    protected Total debts;
    @XmlElement(name = "TransactionAmount")
    protected Total transactionAmount;
    @XmlElement(name = "FixedCharge")
    protected Total fixedCharge;
    @XmlElement(name = "StepPctCharge")
    protected Total stepPctCharge;
    @XmlElement(name = "StepFixedCharge")
    protected Total stepFixedCharge;
    @XmlElement(name = "IndivAccPctCharge")
    protected Total indivAccPctCharge;
    @XmlElement(name = "PurchaseTax")
    protected Total purchaseTax;
    @XmlElement(name = "StampDuty")
    protected Total stampDuty;
    @XmlElement(name = "ServiceFeeAmount")
    protected Total serviceFeeAmount;
    @XmlElement(name = "ServiceCharge")
    protected Total serviceCharge;
    @XmlElement(name = "CostOfUnits")
    protected Total costOfUnits;
    @XmlElement(name = "Units")
    protected Total units;
    @XmlElement(name = "AddChargesMonthlyList")
    protected AddChargesMonthlyList addChargesMonthlyList;
    @XmlElement(name = "StepsUnitsCost")
    protected StepsUnitsCost stepsUnitsCost;

    /**
     * Gets the value of the debts property.
     *
     * @return possible object is
     * {@link Total }
     */
    public Total getDebts() {
        return debts;
    }

    /**
     * Sets the value of the debts property.
     *
     * @param value allowed object is
     *              {@link Total }
     */
    public void setDebts(Total value) {
        this.debts = value;
    }

    /**
     * Gets the value of the transactionAmount property.
     *
     * @return possible object is
     * {@link Total }
     */
    public Total getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Sets the value of the transactionAmount property.
     *
     * @param value allowed object is
     *              {@link Total }
     */
    public void setTransactionAmount(Total value) {
        this.transactionAmount = value;
    }

    /**
     * Gets the value of the fixedCharge property.
     *
     * @return possible object is
     * {@link Total }
     */
    public Total getFixedCharge() {
        return fixedCharge;
    }

    /**
     * Sets the value of the fixedCharge property.
     *
     * @param value allowed object is
     *              {@link Total }
     */
    public void setFixedCharge(Total value) {
        this.fixedCharge = value;
    }

    /**
     * Gets the value of the stepPctCharge property.
     *
     * @return possible object is
     * {@link Total }
     */
    public Total getStepPctCharge() {
        return stepPctCharge;
    }

    /**
     * Sets the value of the stepPctCharge property.
     *
     * @param value allowed object is
     *              {@link Total }
     */
    public void setStepPctCharge(Total value) {
        this.stepPctCharge = value;
    }

    /**
     * Gets the value of the stepFixedCharge property.
     *
     * @return possible object is
     * {@link Total }
     */
    public Total getStepFixedCharge() {
        return stepFixedCharge;
    }

    /**
     * Sets the value of the stepFixedCharge property.
     *
     * @param value allowed object is
     *              {@link Total }
     */
    public void setStepFixedCharge(Total value) {
        this.stepFixedCharge = value;
    }

    /**
     * Gets the value of the indivAccPctCharge property.
     *
     * @return possible object is
     * {@link Total }
     */
    public Total getIndivAccPctCharge() {
        return indivAccPctCharge;
    }

    /**
     * Sets the value of the indivAccPctCharge property.
     *
     * @param value allowed object is
     *              {@link Total }
     */
    public void setIndivAccPctCharge(Total value) {
        this.indivAccPctCharge = value;
    }

    /**
     * Gets the value of the purchaseTax property.
     *
     * @return possible object is
     * {@link Total }
     */
    public Total getPurchaseTax() {
        return purchaseTax;
    }

    /**
     * Sets the value of the purchaseTax property.
     *
     * @param value allowed object is
     *              {@link Total }
     */
    public void setPurchaseTax(Total value) {
        this.purchaseTax = value;
    }

    /**
     * Gets the value of the stampDuty property.
     *
     * @return possible object is
     * {@link Total }
     */
    public Total getStampDuty() {
        return stampDuty;
    }

    /**
     * Sets the value of the stampDuty property.
     *
     * @param value allowed object is
     *              {@link Total }
     */
    public void setStampDuty(Total value) {
        this.stampDuty = value;
    }

    /**
     * Gets the value of the serviceFeeAmount property.
     *
     * @return possible object is
     * {@link Total }
     */
    public Total getServiceFeeAmount() {
        return serviceFeeAmount;
    }

    /**
     * Sets the value of the serviceFeeAmount property.
     *
     * @param value allowed object is
     *              {@link Total }
     */
    public void setServiceFeeAmount(Total value) {
        this.serviceFeeAmount = value;
    }

    /**
     * Gets the value of the serviceCharge property.
     *
     * @return possible object is
     * {@link Total }
     */
    public Total getServiceCharge() {
        return serviceCharge;
    }

    /**
     * Sets the value of the serviceCharge property.
     *
     * @param value allowed object is
     *              {@link Total }
     */
    public void setServiceCharge(Total value) {
        this.serviceCharge = value;
    }

    /**
     * Gets the value of the costOfUnits property.
     *
     * @return possible object is
     * {@link Total }
     */
    public Total getCostOfUnits() {
        return costOfUnits;
    }

    /**
     * Sets the value of the costOfUnits property.
     *
     * @param value allowed object is
     *              {@link Total }
     */
    public void setCostOfUnits(Total value) {
        this.costOfUnits = value;
    }

    /**
     * Gets the value of the units property.
     *
     * @return possible object is
     * {@link Total }
     */
    public Total getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     *
     * @param value allowed object is
     *              {@link Total }
     */
    public void setUnits(Total value) {
        this.units = value;
    }

    /**
     * Gets the value of the addChargesMonthlyList property.
     *
     * @return possible object is
     * {@link AddChargesMonthlyList }
     */
    public AddChargesMonthlyList getAddChargesMonthlyList() {
        return addChargesMonthlyList;
    }

    /**
     * Sets the value of the addChargesMonthlyList property.
     *
     * @param value allowed object is
     *              {@link AddChargesMonthlyList }
     */
    public void setAddChargesMonthlyList(AddChargesMonthlyList value) {
        this.addChargesMonthlyList = value;
    }

    /**
     * Gets the value of the stepsUnitsCost property.
     *
     * @return possible object is
     * {@link StepsUnitsCost }
     */
    public StepsUnitsCost getStepsUnitsCost() {
        return stepsUnitsCost;
    }

    /**
     * Sets the value of the stepsUnitsCost property.
     *
     * @param value allowed object is
     *              {@link StepsUnitsCost }
     */
    public void setStepsUnitsCost(StepsUnitsCost value) {
        this.stepsUnitsCost = value;
    }

}
