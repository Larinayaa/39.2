import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Tests {
    private Person person1;
    private Person person2;
    private Person person3;
    private Account account1;
    private Account account2;
    private Account account3;
    private Account account4;
    @BeforeEach
    public void tearUp() {
        person1 = new Person("Иван");
        person2 = new Person("Анна");
        person3 = new Person("Катя");
        account1 = new Account("DE1234532", new BigDecimal("543"), person1); // по паре счетов каждому
        account2 = new Account("DE8754488", new BigDecimal("112"), person1);
        account3 = new Account("DE6544778", new BigDecimal("4532"), person2);
        account4 = new Account("DE8654788", new BigDecimal("9424"), person2);
    }
    @Test
    @DisplayName("proverkaNaOshibki():если ршибок не допущено то фальш (ошибок нет) ")
    public void test_Correct_bezOshibok() {
        Map<Person, List<Account>> accountsMap = Map.of(person2, List.of(account3, account4)
        );
        Assertions.assertFalse(Oshibki.proverkaNaOshibki(accountsMap));
    }
    @Test
    @DisplayName("proverkaNaOshibki():если владелец неправильный у счета то тру(ошибка есть)")
    public void test_NoCorrect_PersonOfAccount() {
        Map<Person, List<Account>> accountsMap = Map.of(
                person1, List.of(account1, account2, account3)
        );
        Assertions.assertTrue(Oshibki.proverkaNaOshibki(accountsMap));
    }
    @Test
    @DisplayName("proverkaNaOshibki():если мап пустой то фальш (ошибок нет)")
    public void test_PustoyMap_IsCorrect() {
        Map<Person, List<Account>> accountsMap = Map.of();
        Assertions.assertFalse(Oshibki.proverkaNaOshibki(accountsMap));
    }
    @Test
    @DisplayName("proverkaNaOshibki():нормально если владелец не имеет счета (ошибок нет)")
    public void testPersonWithoutAccounts_NoErrors() {
        Map<Person, List<Account>> accountsMap = Map.of(
                person3, List.of() // у кати нет счета
        );
        Assertions.assertFalse(Oshibki.proverkaNaOshibki(accountsMap));
    }
}
