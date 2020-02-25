package lesson1;

import java.util.Random;

public class Human implements Jump, Run{
    private String name;
    private int age;
    private String race;
    private int maxRun;
    private int maxJumpUp;
    private boolean active = true;

    public Human(String name ) {
        this.name = name;
        setRandomAge();
        setRandomRace();
        setMaxRun();
        setMaxJumpUp();
    }

    @Override
    public String toString() {
        return " Я - " + name + "." +
                "Мне " + age + " лет. Моя расса:" + race + ". Мой рекорд в беге:" + maxRun +
                ", по прыжкам в высоту:" + maxJumpUp +'.';
    }

    private void setRandomAge(){
        this.age = new Random().nextInt(100);
    }

    private void setRandomRace(){
        String[] races = new String[]{"европеоидная","негроидная","эфиопская", "монголоидная", "американоидная", "австралоидная"};
        this.race = races[new Random().nextInt(races.length-1)];
    }

    private void setMaxRun(){
        if (age < 2 ){
            maxRun = 0;
        }else if (age < 10){
            maxRun = 1;
        }else if (age < 40){
            maxRun = new Random().nextInt(100);
        }else if (age < 60){
            maxRun = new Random().nextInt(100);
        }else if (age < 75){
            maxRun = 5;
        }else {
            maxRun = 0;
        }
    }
    private void setMaxJumpUp() {

        if (age < 5){
            maxJumpUp = 0;
        }else if (age < 10) {
            maxJumpUp = 1;
        }else  if (age < 40){
            maxJumpUp = new Random().nextInt(5);
        }else if (age < 75){
            maxJumpUp = new Random().nextInt(10);
        }else{
            maxJumpUp = 0;
        }
    }

    public void runing() throws InterruptedException {
        System.out.println("Раз два три .. БЕГИ! ");
        for (int i = 0; i < 10 ; i++) {
            System.out.printf(". ");
        }
        System.out.println();
    }

    public void discvalified() {
        this.active = false;
    }

    public boolean isActive() {
        return this.active;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public void jumpUp() throws InterruptedException {
        System.out.println("И раз, и два, и три .. Прыг!");
        for (int i = 0; i < 10 ; i++) {
            System.out.printf(". ");
        }
        System.out.println();
    }

    public int getMaxJump() {
        return maxJumpUp;
    }

    public String getName() {
        return this.name;
    }
}
