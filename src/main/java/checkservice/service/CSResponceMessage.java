package checkservice.service;

public class CSResponceMessage {
    String responceMesage;

    public String getResponceMessage(int status) {
        switch (status) {
            case 0:
                responceMesage = "Налогоплательщик зарегистрирован в ЕГРН и имел статус действующего в указанную дату.";
                break;
            case 1:
                responceMesage = "Налогоплательщик зарегистрирован в ЕГРН, но не имел статус действующего в указанную дату.";
                break;
            case 2:
                responceMesage = "Налогоплательщик зарегистрирован в ЕГРН.";
                break;
            case 3:
                responceMesage = "Налогоплательщик с указанным ИНН зарегистрирован в ЕГРН, КПП не соответствует ИНН или не указан.";
                break;
            case 4:
                responceMesage = "Налогоплательщик с указанным ИНН не зарегистрирован в ЕГРН.";
                break;
            case 5:
                responceMesage = "Некорректный ИНН.";
                break;
            case 6:
                responceMesage = "Недопустимое количество символов ИНН.";
                break;
            case 7:
                responceMesage = "Недопустимое количество символов КПП.";
                break;
            case 8:
                responceMesage = "Недопустимые символы в ИНН.";
                break;
            case 9:
                responceMesage = "Недопустимые символы в КПП.";
                break;
            case 10:
                responceMesage = "КПП не должен использоваться при проверке ИП.";
                break;
            case 11:
                responceMesage = "некорректный формат даты.";
                break;
            case 12:
                responceMesage = "некорректная дата (ранее 01.01.1991 или позднее текущей даты).";
                break;
        }
        return responceMesage;
    }
}

