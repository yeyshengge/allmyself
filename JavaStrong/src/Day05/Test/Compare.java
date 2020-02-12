package Day05.Test;

/*
3.定义一个方法
		public static ? equals(int[] arr1,int[] arr2)
		功能:比较两个数组是否相等(长度和内容均相等则认为两个数组是相同的)
 */
public class Compare {
    public static void main(String[] args) {
        int[] arr = {1, 2, 13, 14, 511, 46, 1};
        int[] arr1 = {1, 2, 13, 14, 511, 46};
        boolean b = equals(arr, arr1);
        System.out.println(b);
    }

    public static boolean equals(int[] arr, int[] arr1) {
        if (arr.length == arr1.length) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == arr1[i]) {
                    continue;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }
}
