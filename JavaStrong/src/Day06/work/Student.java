package Day06.work;
/*
5. 十三、分别用Comparable和Comparator两个接口对下列四位同学的成绩做降序排序，
如果成绩一样，那在成绩排序的基础上按照年龄由小到大排序。
姓名（String）	年龄（int）	分数（double）
liusan	          20	90.0
lisi		      22	90.0
wangwu		      20	99.0
sunliu		      22	100.0

 */
public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private double score;

    public Student() {
    }

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student s) {
        int num =(int)(s.getScore()-this.score);
        int num2 =num==0?(this.age-s.getAge()):num;
        return num2;
    }
}
