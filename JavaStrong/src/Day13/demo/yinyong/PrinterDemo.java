package Day13.demo.yinyong;

public class PrinterDemo {
    public static void main(String[] args) {
        /*  usePrinter(new Printer() {
            @Override
            public void printUpperCase(String s) {
                System.out.println(s.toUpperCase());
            }
        });*/

        //usePrinter(s -> System.out.println(s.toUpperCase()));

        PrintString p = new PrintString();
        usePrinter(p::printUpper);
    }

    private static void usePrinter(Printer p) {
        p.printUpperCase("HelloWord");
    }
}
