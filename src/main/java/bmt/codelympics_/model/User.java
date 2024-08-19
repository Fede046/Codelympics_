package bmt.codelympics_.model;

public class User {

    private String user;
    private String pt;
    private String arg;
    private String bro;
    private String oro;
    private String time;
    private String data;
    private String es;

    public User(String user, String pt, String arg, String bro, String oro, String time, String data, String es) {
        this.user = user;
        this.pt = pt;
        this.arg = arg;
        this.bro = bro;
        this.oro = oro;
        this.time = time;
        this.data = data;
        this.es = es;
    }

    public String getUser() {
        return user;
    }

    public String getPt() {
        return pt;
    }

    public String getArg() {
        return arg;
    }

    public String getBro() {
        return bro;
    }

    public String getOro() {
        return oro;
    }

    public String getTime() {
        return time;
    }

    public String getData() {
        return data;
    }

    public String getEs() {
        return es;
    }

}
