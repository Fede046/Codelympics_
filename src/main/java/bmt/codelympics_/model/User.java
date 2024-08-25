package bmt.codelympics_.model;

public class User {
    private int id;
    private String avatar;
    private String user;
    private int pt;
    private int arg;
    private int bro;
    private int oro;

    // costruttori
    public User(String avatar, String user, int pt, int oro, int arg, int bro) {
        this.avatar = avatar;
        this.user = user;
        this.oro = oro;
        this.arg = arg;
        this.bro = bro;
        this.pt = pt;
    }

    public User(int id, String avatar, String user, int pt, int oro, int arg, int bro) {
        this.id = id;
        this.avatar = avatar;
        this.user = user;
        this.oro = oro;
        this.arg = arg;
        this.bro = bro;
        this.pt = pt;
    }

    // get e set
    public int getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getUser() {
        return user;
    }

    public int getPt() {
        return pt;
    }

    public int getArg() {
        return arg;
    }

    public int getBro() {
        return bro;
    }

    public int getOro() {
        return oro;
    }

    public String getColore() {
        return avatar;
    }

}
