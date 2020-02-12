package Day06.work;

import java.util.Comparator;
import java.util.TreeSet;

/*
3.分析以下需求，并用代码实现：
	(1)定义一个员工类Employee，包含三个属性：姓名(String name)、年龄(int age)、工资(int salary)
	(2)创建5个对象装入TreeSet，按照工资从高到底排序输出结果(工资相同，按照年龄从低到高，工资和年龄都相同，
		按照姓名字典顺序排列) */
public class Subject03 {
    public static void main(String[] args) {
        Employee e1 =new Employee("马小云",56,17000);
        Employee e2 =new Employee("马华腾",54,19000);
        Employee e3 =new Employee("王健林",46,18000);
        Employee e4 =new Employee("王宝强",42,18000);
        Employee e5 =new Employee("张三",42,18000);

        TreeSet<Employee> ts = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
               int num =e2.getSalary()-e1.getSalary();
               int num2 =num==0?e1.getAge()-e2.getAge():num;
               int num3 = num2==0?e1.getName().compareTo(e2.getName()):num2;
               return  num3;
            }
        });

        ts.add(e1);
        ts.add(e2);
        ts.add(e3);
        ts.add(e4);
        ts.add(e5);

        for(Employee e :ts){
            System.out.println(e.getName()+","+e.getAge()+","+e.getSalary());
        }

    }
}
