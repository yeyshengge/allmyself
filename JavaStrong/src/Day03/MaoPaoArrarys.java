package Day03;


public class MaoPaoArrarys {
    public static void main(String[] args) {
       /* int[] arr = new int[5];
        arr[0] = 150;
        arr[1] = 120;
        arr[2] = 230;
        arr[3] = 160;
        arr[4] = 180;
        int temp = 0;


                for (int j = 0; j < arr.length-1; j++) {

                    for (int i = 0; i < arr.length-j-1; i++) {
                    temp = arr[i] < arr[i + 1] ? arr[i] : arr[i + 1];
                    if (arr[i] < arr[i + 1]) {
                        arr[i] = arr[4 - i];
                    } else {
                        arr[i + 1] = arr[4 - i];
                    }
                    arr[4 - i] = temp;
                }
            }
            for (int j = 0; j < 5; j++) {
                System.out.println(arr[j]);

            }*/

        int[] arr = {220, 100, 160, 80, 120};
        int temp = 0;
        for (int j=0;j<arr.length-1;j++){
        for (int i = 0; i < arr.length-1-j; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;

            }
        }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }

}
