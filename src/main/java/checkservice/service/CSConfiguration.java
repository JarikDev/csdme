package checkservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CSConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("checkservice.service");
        return marshaller;
    }

    @Bean
    public CSClient checkServiceClient(Jaxb2Marshaller marshaller) {
        CSClient client = new CSClient();
        client.setDefaultUri("http://npchk.nalog.ru/FNSNDSCAWS_2?wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
