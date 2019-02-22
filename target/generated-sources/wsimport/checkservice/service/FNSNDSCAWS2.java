package checkservice.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 */
@WebServiceClient(name = "FNSNDSCAWS2", targetNamespace = "http://ws.unisoft", wsdlLocation = "http://npchk.nalog.ru/FNSNDSCAWS_2?wsdl")
public class FNSNDSCAWS2 extends Service {

    private final static URL FNSNDSCAWS2_WSDL_LOCATION;
    private final static WebServiceException FNSNDSCAWS2_EXCEPTION;
    private final static QName FNSNDSCAWS2_QNAME = new QName("http://ws.unisoft", "FNSNDSCAWS2");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://npchk.nalog.ru/FNSNDSCAWS_2?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FNSNDSCAWS2_WSDL_LOCATION = url;
        FNSNDSCAWS2_EXCEPTION = e;
    }

    public FNSNDSCAWS2() {
        super(__getWsdlLocation(), FNSNDSCAWS2_QNAME);
    }

    public FNSNDSCAWS2(WebServiceFeature... features) {
        super(__getWsdlLocation(), FNSNDSCAWS2_QNAME, features);
    }

    public FNSNDSCAWS2(URL wsdlLocation) {
        super(wsdlLocation, FNSNDSCAWS2_QNAME);
    }

    public FNSNDSCAWS2(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FNSNDSCAWS2_QNAME, features);
    }

    public FNSNDSCAWS2(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FNSNDSCAWS2(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns FNSNDSCAWS2Port
     */
    @WebEndpoint(name = "FNSNDSCAWS2_Port")
    public FNSNDSCAWS2Port getFNSNDSCAWS2Port() {
        return super.getPort(new QName("http://ws.unisoft", "FNSNDSCAWS2_Port"), FNSNDSCAWS2Port.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns FNSNDSCAWS2Port
     */
    @WebEndpoint(name = "FNSNDSCAWS2_Port")
    public FNSNDSCAWS2Port getFNSNDSCAWS2Port(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.unisoft", "FNSNDSCAWS2_Port"), FNSNDSCAWS2Port.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FNSNDSCAWS2_EXCEPTION != null) {
            throw FNSNDSCAWS2_EXCEPTION;
        }
        return FNSNDSCAWS2_WSDL_LOCATION;
    }

}
