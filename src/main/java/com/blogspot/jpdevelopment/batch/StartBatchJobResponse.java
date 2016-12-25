
package com.blogspot.jpdevelopment.batch;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for startBatchJobResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="startBatchJobResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://batch.ws.toplife.schantz.com/}batchJobStartResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "startBatchJobResponse", propOrder = {
    "_return"
})
public class StartBatchJobResponse {

    @XmlElement(name = "return")
    protected BatchJobStartResult _return;

    /**
     * Gets the value of the return property.
     *
     * @return
     *     possible object is
     *     {@link BatchJobStartResult }
     *
     */
    public BatchJobStartResult getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     *
     * @param value
     *     allowed object is
     *     {@link BatchJobStartResult }
     *
     */
    public void setReturn(BatchJobStartResult value) {
        this._return = value;
    }

}
