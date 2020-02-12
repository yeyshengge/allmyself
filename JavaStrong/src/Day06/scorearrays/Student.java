package Day06.scorearrays;

public class Student implements Comparable<Student> {

    private String name;
    private int chinesescore;
    private int mathscore;

    public Student() {
    }

    public Student(String name, int chinesescore, int mathscore) {
        this.name = name;
        this.chinesescore = chinesescore;
        this.mathscore = mathscore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinesescore() {
        return chinesescore;
    }

    public void setChinesescore(int chinesescore) {
        this.chinesescore = chinesescore;
    }

    public int getMathscore() {
        return mathscore;
    }

    public void setMathscore(int mathscore) {
        this.mathscore = mathscore;
    }

    @Override
    public int compareTo(Student s) {
        int num =(s.chinesescore+s.mathscore)-(this.chinesescore+this.mathscore);
        int num2 = num==0?(this.name).compareTo(s.name):num;
        return num2;
    }
}
