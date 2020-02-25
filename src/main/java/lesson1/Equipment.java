package lesson1;

import java.util.Random;

public abstract class Equipment {
    private final String name;

    protected Equipment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean doRuning(Run person) throws InterruptedException   {
        return false;
    }

    public boolean doRuning(Jump person) throws InterruptedException   {
        return false;
    }
}
