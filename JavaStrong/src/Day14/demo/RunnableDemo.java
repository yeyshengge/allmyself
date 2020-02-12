package Day14.demo;

public class RunnableDemo {
    public static void main(String[] args) {

        //匿名内部类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程启动了");
            }
        });


        startThread(()-> System.out.println(Thread.currentThread().getName() + "线程启动了"));

    }

    private static void startThread(Runnable r) {
       new Thread(r).start();
    }
}
