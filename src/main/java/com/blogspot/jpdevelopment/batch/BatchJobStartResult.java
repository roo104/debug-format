
package com.blogspot.jpdevelopment.batch;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for batchJobStartResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="batchJobStartResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="activityRequestUid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "batchJobStartResult", propOrder = {
    "activityRequestUid"
})
public class BatchJobStartResult {

    protected String activityRequestUid;

    /**
     * Gets the value of the activityRequestUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityRequestUid() {
        return activityRequestUid;
    }

    /**
     * Sets the value of the activityRequestUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityRequestUid(String value) {
        this.activityRequestUid = value;
    }

}
