package homework;

public abstract class Animal {
    protected int MAX_DISTANCE_RUN;
    protected int MAX_DISTANCE_SWIMM;
    public abstract void swim(int distance);
    public abstract void run(int distance);
    public abstract void eat(Plate p);


}
