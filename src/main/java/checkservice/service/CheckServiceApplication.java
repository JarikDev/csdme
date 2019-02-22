package checkservice.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CheckServiceApplication {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CheckServiceConfiguration.class);
        CheckServiceClient checkServiceClient = context.getBean(CheckServiceClient.class);
        NdsResponse2 ndsResponse2 = checkServiceClient.getNdsResponse2();
        System.out.println("####################################");
        System.out.println(ndsResponse2.getNP().get(0).getDT());
        System.out.println(ndsResponse2.getNP().get(0).getINN());
        System.out.println(ndsResponse2.getNP().get(0).getKPP());
        System.out.println(ndsResponse2.getNP().get(0).getState());
        System.out.println("####################################");
        int responseStatus = Integer.parseInt(ndsResponse2.getNP().get(0).getState());
        switch (responseStatus) {
            case 0:
                System.out.println("Налогоплательщик зарегистрирован в ЕГРН и имел статус действующего в указанную дату");
                break;
            case 1:
                System.out.println("Налогоплательщик зарегистрирован в ЕГРН, но не имел статус действующего в указанную дату");
                break;
            case 2:
                System.out.println("Налогоплательщик зарегистрирован в ЕГРН");
                break;
            case 3:
                System.out.println("Налогоплательщик с указанным ИНН зарегистрирован в ЕГРН, КПП не соответствует ИНН или не указан");
                break;
            case 4:
                System.out.println("Налогоплательщик с указанным ИНН не зарегистрирован в ЕГРН");
                break;
            case 5:
                System.out.println("Некорректный ИНН");
                break;
            case 6:
                System.out.println("Недопустимое количество символов ИНН");
                break;
            case 7:
                System.out.println("Недопустимое количество символов КПП");
                break;
            case 8:
                System.out.println("Недопустимые символы в ИНН");
                break;
            case 9:
                System.out.println("Недопустимые символы в КПП");
                break;
            case 10:
                System.out.println("КПП не должен использоваться при проверке ИП");
                break;
            case 11:
                System.out.println("некорректный формат даты");
                break;
            case 12:
                System.out.println("некорректная дата (ранее 01.01.1991 или позднее текущей даты)");
                break;

        }

    }
}
