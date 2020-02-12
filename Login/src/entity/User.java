package entity;

public class User {

    private String uname;
    private String upswd;

    public User() {
    }

    public User(String uname, String upswd) {
        this.uname = uname;
        this.upswd = upswd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpswd() {
        return upswd;
    }

    public void setUpswd(String upswd) {
        this.upswd = upswd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", upswd='" + upswd + '\'' +
                '}';
    }
}
