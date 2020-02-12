package Day11.deadlock;

public class DeadLock implements Runnable {
    private String k1 = "筷子左";
    private String k2 = "筷子右";

    @Override
    public void run() {
        int i = 0;
        while (true) {
            String name = Thread.currentThread().getName();
            if (i % 2 == 0) {
                synchronized (k1) {
                    System.out.println(name + "拿到了" + k1);
                    synchronized (k2) {
                        System.out.println(name + "拿到了" + k2 + "可以开吃了");
                    }
                }
            } else {
                synchronized (k2) {
                    System.out.println(name + "拿到了" + k2);
                    synchronized (k1) {
                        System.out.println(name + "拿到了" + k1 + "可以开吃了");
                    }
                }
            }
            i++;
        }
    }
}
