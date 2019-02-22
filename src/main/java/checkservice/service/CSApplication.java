package checkservice.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

@SpringBootApplication
public class CSApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CSConfiguration.class);
        List<NdsRequest2.NP> testSubjectList = new TestSubjectAdder().addTestSubject();
        CSClient CSClient = context.getBean(CSClient.class);
        CSClient.getNdsResponse2(testSubjectList);
    }
}

