package bmt.codelympics_.model;

public class Time {
    private static final Time instance = new Time();
    private int hour=0;
    private int minute=0;
    private int second=0;

    public Time() {

    }

    public static Time getInstance() {
        return instance;
    }

    public void setTime(String stringa){
        String[] time = stringa.split(":");
        this.hour = Integer.parseInt(time[0]);
        this.minute = Integer.parseInt(time[1]);
        this.second = Integer.parseInt(time[2]);

    }
    public String getCurrentTime() {
        return hour + ":" + minute + ":" + second;
    }

    public void oneSecondPassed() {
        second++;
        if (second == 60) {
            minute++;
            second = 0;
            if (minute == 60) {
                hour++;
                minute = 0;
                if (hour == 24) {
                    hour = 0;
                    System.out.println("Next day");
                }
            }
        }
    }
}
