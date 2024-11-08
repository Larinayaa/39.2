import java.util.List;
import java.util.Map;

public class Oshibki {
    public static boolean proverkaNaOshibki(Map<Person, List<Account>> accountsMap) {//метод проверка на наличие ошибок в мап
        for (Map.Entry<Person, List<Account>> entry : accountsMap.entrySet()) {
            Person person = entry.getKey();
            List<Account> accounts = entry.getValue();
            for (Account account : accounts) {
                if (!account.getOwner().equals(person)) {  // если персона не владелец то ошибка найдена
                    return true; // Ошибка найдена, возвращаем true
                }
            }
        }
        return false; // если нет ошибок то возврат фальш - проверка дала негативный результат, ошибок нет
    }
}
