package lesson1;

import java.util.Random;

public class Robot implements Jump, Run {
    private String name;
    private String model;
    private String yearMade;
    private int maxJumpUp;
    private int maxRun;
    private boolean active = true;

    public  Robot(String name){
        this.name = name;
        setModel();
        setYearMade();
        setMaxJump();
        setMaxRun();
    }

    @Override
    public String toString() {
        return " Я робот "+name+" модели " + model +" года выпуска:"+yearMade+"."+
                "Я могу прыгнуть на " + maxJumpUp +" метров и "+
                "пробежать " + maxRun + " км.";
    }

    private void setModel(){
        char[] symbols = new char[]
           {'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'};
        this.model = "";
        for (int i = 0; i < 4; i++) {
            this.model += symbols[new Random().nextInt(symbols.length)];
        }
        switch (new Random().nextInt(3)){
            case (0): model += "_";
                break;
            case (1): model += "-";
                break;
            case (2): model += "/";
                break;
            case (3): model += ".";
        }
        for (int i = 0; i < 3; i++) {
            model += new Random().nextInt(10);
        }

    }
    private void setYearMade(){
        yearMade = "20";
        while (yearMade.length() < 4)
            yearMade += new Random().nextInt(10);

    }
    private void setMaxJump(){
        maxJumpUp = new Random().nextInt(10);
    }
    private void setMaxRun(){
        maxRun = new Random().nextInt(100);
    }

    public void runing() throws InterruptedException {
        System.out.println("I am run");
    }

    public void discvalified() {
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public void jumpUp() throws InterruptedException {
        System.out.println("I`m JUMP");
    }

    public int getMaxJump() {
        return maxJumpUp;
    }

    public String getName() {
        return this.name;
    }
}
