package Day05.newwork;

/*
4. 分析以下需求，并用代码实现
	1.定义Student类
		属性:
			姓名：String name
			年龄：int age
			成绩：int score
		行为:
			空参构造方法
			有参构造方法
			set和get方法
 */
public class Subject04Student {
    private String name;
    private int age;
    private int score;

    public Subject04Student() {
    }

    public Subject04Student(String name, int age, int score) {
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Subject04Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
