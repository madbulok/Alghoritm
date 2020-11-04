package homework.lesson1.model;

public abstract class Participant {

    String name;
    private int MAX_DISTANCE_RUN;
    private int MAX_HEIGHT_JUMP;

    public Participant(String name, int MAX_DISTANCE_RUN, int MAX_HEIGHT_JUMP) {
        this.name = name;
        this.MAX_DISTANCE_RUN = MAX_DISTANCE_RUN;
        this.MAX_HEIGHT_JUMP = MAX_HEIGHT_JUMP;
    }

    public String getName() {
        return name;
    }

    public int getMAX_DISTANCE_RUN() {
        return MAX_DISTANCE_RUN;
    }

    public int getMAX_HEIGHT_JUMP() {
        return MAX_HEIGHT_JUMP;
    }
}
