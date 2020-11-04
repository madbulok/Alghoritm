package homework.lesson1.chellange;

import homework.lesson1.implements_class.Overcomable;
import homework.lesson1.model.Participant;

public class Track implements Overcomable {
    private int lengthTrack;

    public Track(int lengthTrack) {
        this.lengthTrack = lengthTrack;
    }

    @Override
    public boolean doOvercome(Participant model) {
        if (model.getMAX_DISTANCE_RUN() > lengthTrack){
            System.out.printf("%s преодолел дорожку \n", model.getName());
            return true;
        } else {
            System.out.printf("%s не преодолел дорожку\n", model.getName());
            return false;
        }
    }
}
