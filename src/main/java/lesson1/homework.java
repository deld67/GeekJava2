package lesson1;

import java.util.Random;

public class homework {
    public static Equipment[] initTrack(){
        int equip_len = new Random().nextInt(10);
        while (equip_len == 0 ){
            equip_len = new Random().nextInt(10);
        }
        Equipment[] obCourse = new Equipment[equip_len];
        int i = 0;
        while (i < equip_len) {
            switch (new Random().nextInt(3)){
                case(0): break;
                case(1): obCourse[i] = new Racetrack(); i++; break;
                case(2): obCourse[i] = new Wall(); i++; break;
            }
        }
        return obCourse;
    }

    private static String GetName(int i) {
        String[] CatsName = new String[]{"Муся","Васька","Мурка","Мышка"};
        String[] HumanName = new String[]{"Вася", "Петя","Маша","Даша","Эдуард"};
        switch (i){
            case(0): return CatsName[new Random().nextInt(CatsName.length)];
            case(1): return HumanName[new Random().nextInt(HumanName.length)];
        }
        return "";
    }

    private static Run[] initPersons() {
        int person_len = new Random().nextInt(20);
        while (person_len == 0) {
            person_len = new Random().nextInt(20);
        }
        Run[] persons = new Run[person_len];
        int i =0;

        while (i<person_len){
            switch (new Random().nextInt(4)){
                case (0): break;
                case (1): persons[i] = new Cat(GetName(0)); i++; break;
                case (2): persons[i] = new Robot("Вертер"+1); i++; break;
                case (3): persons[i] = new Human(GetName(1)); i++; break;
            }
        }
        return persons;
    }



    public static void main(String[] args) throws InterruptedException {
        Equipment[] obCourses = initTrack();
        Run[] persons = initPersons();
        boolean isRuning  = true;
        System.out.println("Состав участников:");
        for (int i = 0; i < persons.length; i++) {
            System.out.println("\t"+persons[i]);
        }

        System.out.println("Приступаем к полосе препятствий (всего "+obCourses.length+" заданий):");
        for (int i = 0; i < obCourses.length; i++) {
            isRuning = false;
            System.out.println("Задание №"+(i+1)+"."+obCourses[i]);
                for (int j = 0; j < persons.length; j++) {
                     if (persons[j].isActive()) {
                         isRuning = true;
                         System.out.printf("\tПопытка "+ persons[j].getName());
                         if (!obCourses[i].doRuning(persons[j])) {
                             persons[j].discvalified();
                             System.out.println("\t\tУвы попытка не удачная. Спортсмен выбывает.");

                         }
                     }
                }
            if (!isRuning) {
                System.out.println("Никто из спортсменов не смог приодолеть полосу препятствий полностью.");
                return;
            }
        }

    }


}
