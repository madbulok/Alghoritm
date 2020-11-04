package homework.lesson1.chellange;

import homework.lesson1.implements_class.Overcomable;
import homework.lesson1.model.Participant;

public class Wall implements Overcomable {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean doOvercome(Participant model) {
        if (model.getMAX_HEIGHT_JUMP() > height){
            System.out.printf("%s перепрыгнул стену \n", model.getName());
            return true;
        } else {
            System.out.printf("%s не перепрыгнул стену \n", model.getName());
            return false;
        }
    }
}
