package lesson1;

import java.util.Random;

public class Cat implements Jump, Run {
    private String name;
    private int age;
    private String color;
    private int maxJumpUp;
    private int maxRun;
    private boolean activ = true;


    public  Cat(String name){
        this.name = name;
        setAge();
        setColor();
        setMaxJump();
        setMaxRun();
    }

    @Override
    public String toString() {
        return " Я кошка по кличке " + name + '.' +
                "Мне " + age + " лет, у меня " + color + " окрас. Я могу прыгнуть вверх на " + maxJumpUp +
                " метров и пробежать " + maxRun + " км";
    }

    private void setAge(){
        age = new Random().nextInt(12);
        while (age == 0){
            age = new Random().nextInt(12);
        }
    }
    private void setColor(){
        String[] colors = new String[]{"черный","белый","рыжий","пятнистый"};
        color = colors[new Random().nextInt(colors.length-1)];
     }
    private void setMaxJump(){
        maxJumpUp = new Random().nextInt(5);
    }
    private void setMaxRun(){
        maxRun = new Random().nextInt(50);
    }

    public void runing() throws InterruptedException {
        System.out.printf("Побежали? Я уже бегу . ");
        for (int i = 0; i < 10 ; i++) {
            System.out.printf(". ");
        }
        System.out.println(". мяу:)");
    }

    public int getMaxRun() {
        return maxRun;
    }

    public void discvalified() {
        this.activ = false;
    }

    public boolean isActive() {
        return activ;
    }

    public String getName() {
        return this.name;
    }

    public void jumpUp() throws InterruptedException {
        System.out.printf("Ииии разз! Я прыгаю . ");
        String sumb = "." ;
        for (int i = 0; i < 5 ; i++) {
            sumb +=".";
            System.out.printf(" "+sumb);
             wait(1000, 0);
        }
        System.out.println(". мяу:)");

    }

    public int getMaxJump() {
        return maxJumpUp;
    }

}
