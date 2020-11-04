package homework;

public class Cat extends Animal {

    private String name;
    private static int countCat = 0;
    private int appetite;
    private boolean iSsatiety;


    public Cat(String name) {
        this.name = name;
        this.appetite = 20;
        MAX_DISTANCE_RUN = 200;
        MAX_DISTANCE_SWIMM = 0;
        countCat++;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        MAX_DISTANCE_RUN = 200;
        MAX_DISTANCE_SWIMM = 0;
        countCat++;
    }

    public static int getCountCat() {
        return countCat;
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
    public void swim(int distance) {
        if (distance < 0) return;
        System.out.println("Кот не уммет плавать!");
    }

    public void eat(Plate p) {
        if (p.getFood() >= appetite){
            p.decreaseFood(appetite);
            System.out.println("Кот " + name + " поел из тарелки " + appetite + " кусочков.");
            iSsatiety = true;
        } else {
            System.out.println("Кот " + name + " остался голодным!");
        }
    }
}
