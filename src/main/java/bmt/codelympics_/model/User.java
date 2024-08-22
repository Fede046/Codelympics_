package bmt.codelympics_.model;

public class User {
    private int id;
    private String avatar;
    private String user;
    private int pt;
    private String arg;
    private String bro;
    private String oro;

    public User(String avatar, String user, int pt, String arg, String bro, String oro) {
        this.avatar = avatar;
        this.user = user;
        this.oro = oro;
        this.arg = arg;
        this.bro = bro;
        this.pt = pt;
    }

    public User(int id, String avatar, String user, int pt, String arg, String bro, String oro) {
        this.id = id;
        this.avatar = avatar;
        this.user = user;
        this.oro = oro;
        this.arg = arg;
        this.bro = bro;
        this.pt = pt;
    }

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

    public String getArg() {
        return arg;
    }

    public String getBro() {
        return bro;
    }

    public String getOro() {
        return oro;
    }

    public String getColore() {
        return avatar;
    }

}
