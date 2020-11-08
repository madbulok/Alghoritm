package homework.lesson1;

import homework.lesson1.chellange.Track;
import homework.lesson1.chellange.Wall;
import homework.lesson1.implements_class.Overcomable;
import homework.lesson1.model.Cat;
import homework.lesson1.model.Human;
import homework.lesson1.model.Robot;
import homework.lesson1.model.Participant;

import java.util.*;

public class MainClass {



    public static void main(String[] args) {

        // участники забега
        Participant[] objects = {
                new Human("Artem", 100, 2),
                new Cat("Барсик", 20, 4),
                new Robot("T-1000", 1000, 20),
                new Human("Sergey", 100, 2),
                new Cat("Пушистик", 20, 3),
                new Robot("K-005", 300, 10)
        };

        // полоса препядствий
        Overcomable[] challenges = {
                new Track(10),
                new Wall(2),
                new Track(5),
                new Wall(1),
                new Track(9),
                new Wall(3),
                new Track(20),
                new Wall(4)
        };

        List<Participant> finishers = new ArrayList<>();

        // каждый участник проходит по очереди каждое препядствие
        for (Participant participant : objects) {
            boolean canIsOvercome = true; //флаг того, что участник смог преодолеть все препятствия
            for(Overcomable challenge: challenges) {
                canIsOvercome = challenge.doOvercome(participant);
                if (!canIsOvercome) break; // на первом "провале" испытания завершаем полосу препятствий и запускаем следующего участника
            }

            if (canIsOvercome) finishers.add(participant);
        }

        // выводим кто дошёл до конца
        System.out.println();
        System.out.println("До ФИНИША дошли:");
        for (Participant p : finishers) {
            System.out.println(p.getName());
        }

    }
}
