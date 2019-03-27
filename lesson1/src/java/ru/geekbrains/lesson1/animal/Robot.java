package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Color;

/**
 * Робот не является животным, но может учавствовать в соревнованиях
 * так как реализует интерфейс {@link Participant}
 */
public class Robot implements Participant {

    private boolean isOnDistance;
    private int runDistance;
    private String name = "робот";

    public Robot (int runDistance) {
        this.isOnDistance = true;
        this.runDistance = runDistance;
    }

    public Robot (String name, int age, int runDistance) {
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.name = name;
    }

    public boolean isOnDistance() {
        return isOnDistance;
    }

    @Override
    public void run(int distance) {
        if (!isOnDistance) {
            return;
        }
        if (distance > runDistance) {
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("Робот %s пробежал кросс длинной %d", this.name, distance));
    }

    @Override
    public void jump(int height) {
            isOnDistance = false;
        System.out.println("Робот не может прыгать");
    }

    @Override
    public void swim(int distance) {
            isOnDistance = false;
        System.out.println("Робот не может плыть");
    }

    @Override
    public  void status(){
        if (!isOnDistance){
            System.out.println(String.format("робот %s не прошел", this.name));
        } else {
            System.out.println(String.format("робот %s прошел", this.name));
        }
    }
}
