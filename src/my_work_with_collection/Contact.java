package my_work_with_collection;

public class Contact {
    private int phone;
    private  String lastName;

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Contact(String lastName, int phone) {
        this.lastName = lastName;
        this.phone =phone;
        System.out.printf("Создан новый телефонный контакт: Имя %s - Телефон %d.%n", lastName, phone);
    }
}
