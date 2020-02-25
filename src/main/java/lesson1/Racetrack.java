package lesson1;

import java.util.Random;

public class Racetrack extends Equipment {
    private int distance;
    static final String MYNAME = "беговая дорожка";
    static final int MAX_WALL_LENGTH = 50;

    public Racetrack() {
        super(MYNAME);
        this.distance = new Random().nextInt(MAX_WALL_LENGTH); //getHeight();
        while (this.distance == 0 ) this.distance = new Random().nextInt(MAX_WALL_LENGTH);
    }

    public String toString() {
        return " Снаряд "+this.getName()+"  длиной "+this.distance;
    }

    @Override
    public boolean doRuning(Run person) throws InterruptedException {
        System.out.println(" дистанция "+this.distance+" рекорд спортсмена "+person.getMaxRun());
        if (person.getMaxRun() >= this.distance){
            person.runing();
            return true;
        }
        return false;
    }


}
