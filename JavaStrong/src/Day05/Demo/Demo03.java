package Day05.Demo;

public class Demo03 {
    public static void main(String[] args) {
        //数组的折半查找  二分查找
        //前提: 一定是有序的数组
        int[] arr = {1,3,5,6,9};
        binarySearch(arr);
        //int i = Arrays.binarySearch(arr, 15);
       // System.out.println(i);
    }

    public static void binarySearch(int[] arr) {
        //要找 5 在数组中出现的索引
        int num = 6;
        //定义三个索引
        //最小
        int min = 0;
        //最大
        int max = arr.length-1;
        //中间
        //int mid = (min + max) / 2;
        int mid = (min + max) >> 1;

        //由于不确定到底要找几次,所以使用循环
        while(true){
            //判断,中间索引对应的元素到底是大于还是小于或者等于要找的元素
            if(arr[mid] == num){
                System.out.println(mid);
                break;
            }else if(num < arr[mid]){
                max = mid - 1;
            }else if(num > arr[mid]){
                min = mid + 1;
            }

            //每次循环都需要重新计算 中间索引的位置
            mid = (min + max) >> 1;
            //如果没有找到,需要结束循环
            if(min > max){
                System.out.println(num+" ,在数组中不存在");
                break;
            }
        }
    }
}
