package myWorkWithCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TelephoneDirectory {
    private HashMap<Integer, String> listOfContacts = new HashMap<>();
    private Set<Map.Entry<Integer, String>> entrySet = listOfContacts.entrySet();

    public void addNewContact(Contact contact) {
        listOfContacts.put(contact.getPhone(), contact.getLastName());
    }

    public void getAllInfoFromTelephoneDirectory() {
        System.out.println("Контакты в справочнике:");
        for (Map.Entry<Integer, String> entry : entrySet) {
            System.out.printf("Имя контакта: %s, номер телефона: %d.%n", entry.getValue(), entry.getKey());
        }
    }

    public void searchName(String lastName) {
        System.out.printf("Поиск номера телефона для контакта: %s.%nРезультат поиска:%n", lastName);
        for (Map.Entry<Integer, String> entry : entrySet) {
            if (lastName.equals(entry.getValue())) {
                System.out.println(entry.getKey());
            }
        }
    }


}
