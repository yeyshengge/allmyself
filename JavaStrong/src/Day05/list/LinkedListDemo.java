package Day05.list;
/*
LinkedList特有的方法：！！！因为是子类特有的功能，所以不能用多态来实现，(可以向下转型)
          void addFrist()在列队前插入指定元素
          void addLast()在队列末尾添加指定元素
          getFrast()返回队列的第一个元素
          getLast(),返回队列的最后一个element;
          removeFirst,删除第一个元素并返回
          removelast,删除最后一个元素并返回
 */


import java.util.LinkedList;
import java.util.List;


public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("ello");
        list.add("World");
        list.add("Jav");
        System.out.println(list);

        // void addFrist()在列队前插入指定元素
        // void addLast()在队列末尾添加指定元素
        list.addFirst("j");
        list.addLast("a");
        System.out.println(list);

        //getFrast()返回队列的第一个元素
        // getLast(),返回队列的最后一个element;
        String str = list.getFirst();
        System.out.println(str);
        String str2 = list.getLast();
        System.out.println(str2);

        System.out.println("-------");
        System.out.println(list);
        //removeFirst,删除第一个元素并返回
        //removelast,删除最后一个元素并返回

        String str3 = list.removeFirst();
        System.out.println(str3);
        String str4 = list.removeLast();
        System.out.println(str4);

        System.out.println(list);

        System.out.println("-----向下转型------");
        List<String> list1 = new LinkedList<>();
        LinkedList<String> li = (LinkedList<String>) list1;
        li.addLast("you");
        li.addFirst("love");
        li.addFirst("i");
        System.out.println(li);

    }
}
