
package com.blogspot.jpdevelopment.batch;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for getBatchJobStatusResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getBatchJobStatusResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://batch.ws.toplife.schantz.com/}batchJobStatusResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBatchJobStatusResponse", propOrder = {
    "_return"
})
public class GetBatchJobStatusResponse {

    @XmlElement(name = "return")
    protected BatchJobStatusResult _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link BatchJobStatusResult }
     *     
     */
    public BatchJobStatusResult getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchJobStatusResult }
     *     
     */
    public void setReturn(BatchJobStatusResult value) {
        this._return = value;
    }

}
