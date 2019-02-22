package checkservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CheckServiceClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CheckServiceClient.class);

    public NdsResponse2 getNdsResponse2() {

        NdsRequest2 request = new NdsRequest2();
        request.getNP().add(new NdsRequest2.NP());
        request.getNP().get(0).setDT(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")).toString());
        request.getNP().get(0).setINN("6449013711");
        request.getNP().get(0).setKPP("644901001");

        log.info("Requesting location for " + request);
        NdsResponse2 response = (NdsResponse2) getWebServiceTemplate().
                marshalSendAndReceive("http://npchk.nalog.ru/FNSNDSCAWS_2?xsd=1", request, new SoapActionCallback("http://npchk.nalog.ru/FNSNDSCAWS_2?xsd=2"));

        return response;
    }

}
