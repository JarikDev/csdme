package checkservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TestSubjectAdder {
    private static final Logger log = LoggerFactory.getLogger(TestSubjectAdder.class);
    private NdsRequest2 ndsRequest2 = new NdsRequest2();

    public List<NdsRequest2.NP> addTestSubject() {
        int i = 0;
        while ( true) {
            log.info("Введите данные проверяемого контрагента, или фразу \"ПРОВЕРИТЬ\". ");
            Scanner scanner = new Scanner(System.in);
            log.info("Введите ИНН: ");
            String inn = scanner.nextLine();
            if (inn.equals("ПРОВЕРИТЬ")) {
                break;
            } else {
                ndsRequest2.getNP().add(new NdsRequest2.NP());
                ndsRequest2.getNP().get(i).setINN(inn);
                log.info("Введите КПП: ");
                String kpp = scanner.next();
                ndsRequest2.getNP().get(i).setKPP(kpp);
                ndsRequest2.getNP().get(i).setDT(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")).toString());
                i++;
            }
        }
        return ndsRequest2.getNP();
    }
}
