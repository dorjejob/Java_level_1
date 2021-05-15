package Lesson_5;

public class Firm  {
    public static void main(String[] args) {
        staff[] person = new staff[5];
        person[0] = new staff("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", 892312312, 30000, 30);
        person[1] = new staff("Mariya Petrova", "Accountant", "mariyap@mailbox.com", 893212132, 50000,45);
        person[2] = new staff("Valerij Kuznestov", "Hunker", "kuznechik@mailbox.com", 893211245, 10000,25);
        person[3] = new staff("Zinaida Volkova", "Security", "volk_zina@mailbox.com", 892211111, 60000, 65);
        person[4] = new staff("Petr Volkov", "Big Boss", "petrvolkov@mailbox.com", 892200000, 100000, 40);



        for (int i = 0; i < person.length; i++) {
            if (person[i].age > 39)
                System.out.println("Сотрудники чей возраст превышает 40 лет: " + person[i].firstLastName + "\t" + person[i].position + "\t" + person[i].email + "\t" + person[i].phone + "\t" + person[i].salary + "\t" + person[i].age);
        }
    }
}
