package Day05.Test;
/*2.定义一个方法
public static ? fill(int[] arr,int value)
        功能:将数组arr中的所有元素的值改为value
        比如:
        调用方法如下 fill(arr , 23);
        最终遍历数组,该数组里的元素都是 23
        */


public class Chang {
    public static void main(String[] args) {
        int[] arr = {12, 23, 65, 4, 544, 88};
        fill(arr, 23);

    }

    public static void fill(int[] arr, int n) {
        StringBuilder sb =new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n;
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i] + ",");
                // System.out.println(arr[i]);
            }
        }
        sb.append("]");
        System.out.println(sb);
    }
}
