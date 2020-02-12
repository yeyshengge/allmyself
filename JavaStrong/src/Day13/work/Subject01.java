package Day13.work;

/*
第一题：根据需求完成代码
	1.	定义一个函数式接口CurrentTimePrinter,其中抽象方法void printCurrentTime()，使用注解@FunctionalInterface
	2.	在测试类中定义static void showLongTime(CurrentTimePrinter timePrinter)，该方法的预期行为是
		使用timePrinter打印系统当前毫秒值
	3.	测试showLongTime(),通过lambda表达式完成需求
 */
public class Subject01 {
    public static void main(String[] args) {

        showLongTime(() -> System.out.println(System.currentTimeMillis()));
    }

    static void showLongTime(CurrentTimePrinter timePrinter) {
        timePrinter.printCurrentTime();
    }
}
