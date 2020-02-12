package Day06.set;
/*
哈希值。hashCode();
 */
public class HashDemo {
    public static void main(String[] args) {

        Student s1 = new Student("迪丽热巴",18);
        Student s2 = new Student("迪丽热巴",18);

        System.out.println(s1.hashCode());//621009875
        System.out.println(s2.hashCode());//1265094477 Student类中可以重写hashCode  都变成了289833432

        String s3 ="Good";
        String s4 ="Good";
        System.out.println(s3.hashCode());//2225373
        System.out.println(s4.hashCode());//2225373


    }
}
