    package Day04;

    import java.util.Random;

    public class demo22 {

        public static void main(String[] args) {
            int[] arr = new int[6];
            Random r = new Random();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = r.nextInt(100);
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i] == arr[i + 1]) {
                        arr[i + 1] = r.nextInt(100);
                    }
                }
                System.out.println(arr[i]);
            }


        }
    }
