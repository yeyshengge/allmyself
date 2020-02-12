package Day13.work;

import java.security.PrivateKey;

/*
1.定义学生类:
	a)	成员变量 姓名：String name;
	b)	成员变量 成绩：int score；
	c)	无参及全参构造
	d)	重写toString()

 */
public class Student {
    private String name;
    private int score;

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
