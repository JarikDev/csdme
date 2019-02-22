package checkservice.service;

import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



@SpringBootApplication
public class CheckServiceApplication {
    public static void main(String[] args) {
        org.slf4j.Logger log = LoggerFactory.getLogger(CheckServiceApplication.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CheckServiceConfiguration.class);
        CheckServiceClient checkServiceClient = context.getBean(CheckServiceClient.class);
        NdsResponse2 ndsResponse2 = checkServiceClient.getNdsResponse2();
        log.info("####################################");
        log.info("Дата проверки: " + ndsResponse2.getNP().get(0).getDT());
        log.info("Проверяемый ИНН: "+ ndsResponse2.getNP().get(0).getINN());
        log.info("Проверяемый КПП: "+ ndsResponse2.getNP().get(0).getKPP());
        log.info("Вернувшийся статус ответа сервиса: "+ ndsResponse2.getNP().get(0).getState());
        log.info("####################################");
        String statusEncrypt= new CSResponceMessage().getResponceMessage(Integer.parseInt(ndsResponse2.getNP().get(0).getState()));
        log.info("Расшифровка статуса: "+statusEncrypt);



        }

    }

