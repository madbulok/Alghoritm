package homework.lesson1.model;


import homework.lesson1.implements_class.Motivable;

public class Robot extends Participant implements Motivable{

    public Robot(String name, int max_distance_run, int max_height_jump) {
        super(name, max_distance_run, max_height_jump);
    }

    @Override
    public void run(int distance) {
        if (distance < 0) return;
        System.out.printf("Робот %s пробежал %d метров.\n", name, distance);
    }

    @Override
    public void jump(int height) {
        if (height < 0) return;
        System.out.printf("Робот %s подпрыгнул на %d метров.\n", name, height);
    }
}
