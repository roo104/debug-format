
package com.blogspot.jpdevelopment.batch;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.*;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.schantz.toplife.ws.batch package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetBatchJobStatus_QNAME = new QName("http://batch.ws.toplife.schantz.com/", "getBatchJobStatus");
    private final static QName _GetBatchJobStatusResponse_QNAME = new QName("http://batch.ws.toplife.schantz.com/", "getBatchJobStatusResponse");
    private final static QName _StartBatchJob_QNAME = new QName("http://batch.ws.toplife.schantz.com/", "startBatchJob");
    private final static QName _StartBatchJobResponse_QNAME = new QName("http://batch.ws.toplife.schantz.com/", "startBatchJobResponse");
    private final static QName _StopBatchJob_QNAME = new QName("http://batch.ws.toplife.schantz.com/", "stopBatchJob");
    private final static QName _StopBatchJobResponse_QNAME = new QName("http://batch.ws.toplife.schantz.com/", "stopBatchJobResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.schantz.toplife.ws.batch
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBatchJobStatus }
     *
     */
    public GetBatchJobStatus createGetBatchJobStatus() {
        return new GetBatchJobStatus();
    }

    /**
     * Create an instance of {@link GetBatchJobStatusResponse }
     *
     */
    public GetBatchJobStatusResponse createGetBatchJobStatusResponse() {
        return new GetBatchJobStatusResponse();
    }

    /**
     * Create an instance of {@link StartBatchJob }
     *
     */
    public StartBatchJob createStartBatchJob() {
        return new StartBatchJob();
    }

    /**
     * Create an instance of {@link StartBatchJobResponse }
     *
     */
    public StartBatchJobResponse createStartBatchJobResponse() {
        return new StartBatchJobResponse();
    }

    /**
     * Create an instance of {@link StopBatchJob }
     *
     */
    public StopBatchJob createStopBatchJob() {
        return new StopBatchJob();
    }

    /**
     * Create an instance of {@link StopBatchJobResponse }
     *
     */
    public StopBatchJobResponse createStopBatchJobResponse() {
        return new StopBatchJobResponse();
    }

    /**
     * Create an instance of {@link BatchJobStatusResult }
     *
     */
    public BatchJobStatusResult createBatchJobStatusResult() {
        return new BatchJobStatusResult();
    }

    /**
     * Create an instance of {@link BatchJobStartResult }
     *
     */
    public BatchJobStartResult createBatchJobStartResult() {
        return new BatchJobStartResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBatchJobStatus }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://batch.ws.toplife.schantz.com/", name = "getBatchJobStatus")
    public JAXBElement<GetBatchJobStatus> createGetBatchJobStatus(GetBatchJobStatus value) {
        return new JAXBElement<GetBatchJobStatus>(_GetBatchJobStatus_QNAME, GetBatchJobStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBatchJobStatusResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://batch.ws.toplife.schantz.com/", name = "getBatchJobStatusResponse")
    public JAXBElement<GetBatchJobStatusResponse> createGetBatchJobStatusResponse(GetBatchJobStatusResponse value) {
        return new JAXBElement<GetBatchJobStatusResponse>(_GetBatchJobStatusResponse_QNAME, GetBatchJobStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartBatchJob }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://batch.ws.toplife.schantz.com/", name = "startBatchJob")
    public JAXBElement<StartBatchJob> createStartBatchJob(StartBatchJob value) {
        return new JAXBElement<StartBatchJob>(_StartBatchJob_QNAME, StartBatchJob.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartBatchJobResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://batch.ws.toplife.schantz.com/", name = "startBatchJobResponse")
    public JAXBElement<StartBatchJobResponse> createStartBatchJobResponse(StartBatchJobResponse value) {
        return new JAXBElement<StartBatchJobResponse>(_StartBatchJobResponse_QNAME, StartBatchJobResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopBatchJob }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://batch.ws.toplife.schantz.com/", name = "stopBatchJob")
    public JAXBElement<StopBatchJob> createStopBatchJob(StopBatchJob value) {
        return new JAXBElement<StopBatchJob>(_StopBatchJob_QNAME, StopBatchJob.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopBatchJobResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://batch.ws.toplife.schantz.com/", name = "stopBatchJobResponse")
    public JAXBElement<StopBatchJobResponse> createStopBatchJobResponse(StopBatchJobResponse value) {
        return new JAXBElement<StopBatchJobResponse>(_StopBatchJobResponse_QNAME, StopBatchJobResponse.class, null, value);
    }

}
