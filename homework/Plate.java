package homework;

public class Plate {

    private int food;
    private int MAX_FOOD = 40;


    public Plate(int food) {
        if (food > MAX_FOOD) this.food = MAX_FOOD;
        else if (food < 0) food = 1;
        else food = 1;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int n) {
        if (food - n < 0) {
            System.out.println("В тарелке меньше еды чем кот пытается покушать!");
        } else {
            food -= n;
        }
    }

    public void increaseFood(int n) {
        if (food + n >= 100) food = MAX_FOOD;
        food += n;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

}
