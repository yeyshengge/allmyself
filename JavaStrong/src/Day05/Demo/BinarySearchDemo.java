package Day05.Demo;

/*
二分查找
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 9, 17, 22, 31};
        int min = 0;
        int max = arr.length - 1;
        int mid = (min + max) / 2;
        int num = 22;
        while (true) {
            if (arr[mid] == num) {
                System.out.println("要查找的索引为：" + mid);
                break;
            } else if (num < arr[mid]) {
                max = mid - 1;
            } else if (num > arr[mid]) {
                min = mid + 1;
            }
            mid = (max + min) / 2;

            if (min > max) {
                System.out.println("查找的数据不在数组中");
                break;
            }
        }
    }
}
