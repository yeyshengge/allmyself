package Day09.Test;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        Phone p1 = new Phone("小米MIX2", 2999, "新机皇");
        Phone p2 = new Phone("Iphone8", 5888, "火爆新机");
        Phone p3 = new Phone("VIVO X9s", 1998, "火爆新机");




        ArrayList<Phone> list_phone = new ArrayList<>();
        list_phone.add(p1);
        list_phone.add(p2);
        list_phone.add(p3);

        ArrayList<Phone> f = filter(list_phone, 2000);
        System.out.println("返回的list集合中的所有元素信息：");
        for (int i = 0; i < f.size(); i++) {
            System.out.println(f.get(i).getName()+" "+(int)(f.get(i).getPrice())+" "+f.get(i).getType());
        }

    }

    public static ArrayList<Phone> filter(ArrayList<Phone> list, double price) {
        ArrayList<Phone> list2 = new ArrayList<Phone>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() > price) {
                list2.add(list.get(i));
            }
        }
        return list2;
    }
}
