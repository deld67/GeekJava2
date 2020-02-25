package lesson1;

import java.util.Random;

public class Wall extends Equipment {
    private int distance;
    static final String MYNAME = "стена";
    static final int MAX_WALL_HEIGHT = 5;

    public Wall() {
        super(MYNAME);
        this.distance = new Random().nextInt(MAX_WALL_HEIGHT); //getHeight();
        while (this.distance == 0 ) this.distance = new Random().nextInt(MAX_WALL_HEIGHT);
    }

    public String toString() {
        return " Снаряд \'"+getName()+"\'  высотой "+this.distance;
    }

    @Override
    public boolean doRuning(Jump person) throws InterruptedException {
        System.out.println(" высота "+this.distance+" рекорд спортсмена "+person.getMaxJump());
        if (person.getMaxJump() >= this.distance){
            person.jumpUp();
        }
        return false;
    }
}
