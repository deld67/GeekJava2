package lesson3;


public class homework3 {
    public static void main(String[] args) {
        System.out.println("============== задание 1 =====================");
        Words task1 = new Words();
        String[] task1Array = task1.initArray();
        System.out.printf("Набор слов: ");
        task1.printTask1(task1Array);
        task1.printUniqueElements(task1Array);
        System.out.println("============== задание 2 =====================");
        Phonebook phonebook = new Phonebook();
        phonebook.add("МЧС", "01");
        phonebook.add("МЧС", "101");
        phonebook.add("МЧС", "112");
        phonebook.add("Полиция", "02");
        phonebook.add("Полиция", "102");
        phonebook.add("Полиция", "911");
        phonebook.add("Скорая помощь", "03");
        phonebook.add("Скорая помощь", "103");
        phonebook.add("Служба мосгаза", "04");

        System.out.println("Телефоны абонента \"МЧС\" "+phonebook.get("МЧС"));
        System.out.println("Телефоны абонента \"Полиция\" "+phonebook.get("Полиция"));
        System.out.println("Телефоны абонента \"Скорая помощь\" "+phonebook.get("Скорая помощь"));
        System.out.println("Телефоны абонента \"Служба мосгаза\" "+phonebook.get("Служба мосгаза"));
    }

}
