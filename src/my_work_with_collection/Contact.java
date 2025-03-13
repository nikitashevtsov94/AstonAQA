package my_work_with_collection;

public class Contact {
    private String phone;
    private String lastName;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Contact(String lastName, String phone) {
        this.lastName = lastName;
        this.phone = phone;
        System.out.printf("Создан новый телефонный контакт: Имя %s - Телефон %s.%n", lastName, phone);
    }
}
