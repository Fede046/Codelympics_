/*package bmt.codelympics_.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTime {

    private static final CurrentTime instance = new CurrentTime();
    private String stringTime;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    public CurrentTime() {
    }

    public static CurrentTime getInstance() {
        return instance;
    }

    public void saveTime(String stringTime){
        this.stringTime=stringTime;
    }

    public String getSaveTime(){
        return stringTime;
    }


}
*/