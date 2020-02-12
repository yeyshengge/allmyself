package Day05.Test;

/*
4.定义一个方法
		public static ? fill(int[] arr,int fromIndex,int toIndex,int value)
		功能:将数组arr中的元素从索引fromIndex开始到toIndex(不包含toIndex)对应的值改为value
		比如：fill(arr,1,4,23)把 arr[1] 到 arr[3] 的元素都改成23
 */
public class Replace {
    public static void main(String[] args) {
        int[] arr ={5,6,4,8,9,4,7,55,6,4};
        StringBuilder ss = fill(arr, 3, 5, 100);
        System.out.println(ss);

    }

    public static StringBuilder fill(int[] arr, int fromIndex, int toIndex, int value) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < arr.length; i++) {
            if (i >= fromIndex && i <= toIndex) {
                arr[i] = value;
            }
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i] + ",");
                // System.out.println(arr[i]);
            }

        } sb.append("}");
        return sb;


    }


}