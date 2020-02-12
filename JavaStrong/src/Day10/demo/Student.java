package Day10.demo;

public class Student {
    private String name;
    private int Chinese;
    private int Math;
    private int Englist;

    public Student() {
    }

    public Student(String name, int chinese, int math, int englist) {
        this.name = name;
        Chinese = chinese;
        Math = math;
        Englist = englist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return Chinese;
    }

    public void setChinese(int chinese) {
        Chinese = chinese;
    }

    public int getMath() {
        return Math;
    }

    public void setMath(int math) {
        Math = math;
    }

    public int getEnglist() {
        return Englist;
    }

    public void setEnglist(int englist) {
        Englist = englist;
    }
}
