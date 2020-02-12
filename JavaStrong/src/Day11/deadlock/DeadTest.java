package Day11.deadlock;

public class DeadTest {
    public static void main(String[] args) {
        DeadLock dl = new DeadLock();
        new Thread(dl,"哲学家一").start();
        new Thread(dl,"哲学家二").start();
    }
}
