package checkservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import java.util.List;

public class CSClient extends WebServiceGatewaySupport {
    private int resultCounter = 1;
    private static final Logger log = LoggerFactory.getLogger(CSClient.class);

    public void getNdsResponse2(List<NdsRequest2.NP> checkList) {

        for (int i = 0; i < checkList.size(); i++, resultCounter++) {
            NdsRequest2 request = new NdsRequest2();
            request.getNP().clear();
            request.getNP().add(checkList.get(i));
            NdsResponse2 response = (NdsResponse2) getWebServiceTemplate().
                    marshalSendAndReceive("http://npchk.nalog.ru/FNSNDSCAWS_2?xsd=1", request, new SoapActionCallback("http://npchk.nalog.ru/FNSNDSCAWS_2?xsd=2"));

            log.info("############ Результат № " + resultCounter + " ############");
            log.info("Дата проверки: " + response.getNP().get(0).getDT());
            log.info("Проверяемый ИНН: " + response.getNP().get(0).getINN());
            log.info("Проверяемый КПП: " + response.getNP().get(0).getKPP());
            log.info("Вернувшийся статус ответа сервиса: " + response.getNP().get(0).getState());
            String statusEncrypt = new CSResponseMessage().getResponseMessage(Integer.parseInt(response.getNP().get(0).getState()));
            log.info("Расшифровка статуса: " + statusEncrypt);

        }
    }
}
