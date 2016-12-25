
package com.blogspot.jpdevelopment.batch;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for getBatchJobStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getBatchJobStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "getBatchJobStatus", propOrder = {
    "userId",
    "activityRequestUid"
})
public class GetBatchJobStatus {

    protected String userId;
    protected String activityRequestUid;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

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
