package homework;

public class Dog extends Animal {

    private String name;
    private static int countDog = 0;
    private int appetite;

    public Dog(String name) {
        this.name = name;
        MAX_DISTANCE_RUN = 500;
        MAX_DISTANCE_SWIMM = 10;
        countDog++;
    }
    public Dog(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        MAX_DISTANCE_RUN = 500;
        MAX_DISTANCE_SWIMM = 10;
        countDog++;
    }

    public static int getCountDog() {
        return countDog;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run(int distance) {
        if (distance < 0) return;
        if (distance < MAX_DISTANCE_RUN) System.out.printf("%s пробежал %d метров.\n", name, distance);
        else System.out.printf("%d метров слишком много!\n", distance);
    }

    @Override
    public void eat(Plate p) {
        if (p.getFood() >= appetite){
            p.decreaseFood(appetite);
            System.out.println("Кот " + name + " поел из тарелки " + appetite + " кусочков.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance < 0) return;
        if (distance < MAX_DISTANCE_SWIMM) System.out.printf("%s проплыл %d метров.\n", name, distance);
        else System.out.printf("%d метров слишком много!\n", distance);
    }
}
