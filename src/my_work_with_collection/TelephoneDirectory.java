package my_work_with_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TelephoneDirectory {
    private final HashMap<String, String> contacts = new HashMap<>();
    private final Set<Map.Entry<String, String>> entrySet = contacts.entrySet();

    public void addNewContact(Contact contact) {
        contacts.put(contact.getPhone(), contact.getLastName());
    }

    public void getAllInfoFromTelephoneDirectory() {
        System.out.println("Контакты в справочнике:");
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.printf("Имя контакта: %s, номер телефона: %s.%n", entry.getValue(), entry.getKey());
        }
    }

    public void getPhoneNumberByLastName(String lastName) {
        System.out.printf("Поиск номера телефона для контакта: %s.%nРезультат поиска:%n", lastName);
        boolean isFound = false;
        for (Map.Entry<String, String> entry : entrySet) {
            if (lastName.equals(entry.getValue())) {
                System.out.println(entry.getKey());
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Отсутствует номер телефона для контакта с фамилией: " + lastName);
        }
    }
}
