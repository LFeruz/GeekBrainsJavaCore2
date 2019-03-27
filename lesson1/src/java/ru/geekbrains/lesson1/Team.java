package ru.geekbrains.lesson1;

/**
 * Класс - комманда участников соревнований
 */
public class Team {

    private Participant[] participants;
    private boolean isOnDistance;

    // здесь используется конструктор с переменным числом параметров
    public Team(Participant... participants) {
        // внутри метода переменное число параметров интерпретируется как массив
        this.participants = participants;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void showResults(){
        for (Participant participant : participants){
            participant.status();
            this.isOnDistance = participant.isOnDistance();
           if (isOnDistance == true){
               System.out.println("Команда прошла полосу препятствий");
               return;
           }
        }
        System.out.println("Команда НЕ прошла полосу препятствий");
    }
}
