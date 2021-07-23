package class04;

import java.util.Arrays;

/**
 * 归并排序的思想：通过排序得到局部有序，再由局部有序到全局有序
 *      递归写法：二分 + base case
 *      非递归写法
 */
public class Code01_MergeSort {

    public static void main(String[] args) {
//        int[] array = {5,4,3,1,2};
        int[] array = {4,5,9,3,1,2};
        int[] ans = mergeSort(array);
        System.out.println(Arrays.toString(ans));

    }
    public static int[] mergeSort(int[] arr){

        if(arr == null || arr.length < 2){
            return arr;
        }
//        process(arr, 0, arr.length-1);
        process_2(arr);
        return arr;

    }

    private static void process(int[] arr, int l, int r) {

        // base case
        if(l == r){
            return;
        }
        // 取中位数
        int m = l + (r - l) / 2;
        // 左递归，得到有序数组
        process(arr, l,m);
        // 右递归，得到有序数组
        process(arr, m+1, r);
        // 将左右有序数组归并为整体有序数组
        mergeSort(arr, l,m,r);
    }

    private static void mergeSort(int[] arr, int l, int m, int r) {
        int[] tempArr = new int[r - l + 1];
        int p1 = l;
        int p2 = m+1;
        int i = 0;
        while(p1 <= m && p2 <= r){
            tempArr[i++] = arr[p1] > arr[p2]? arr[p2++] : arr[p1++];
        }
        while(p1 <= m){
            tempArr[i++] = arr[p1++];
        }

        while(p2 <= r){
            tempArr[i++] = arr[p2++];
        }

        for(int j = 0; j < tempArr.length; j++){
            arr[l + j] = tempArr[j];
        }
    }


    /**
     * 非递归方法
     *  注意事项：
     *      1、步长2的阶层底层，边界判断（步长大于数组长度）
     *      2、在某一步长中，选择比较对时，若左比较对<步长结束、若右比较对=0结束
     * @param arr
     */
    private static void process_2(int[] arr) {

        int spaceSize = 1;
        int length = arr.length;
        while(spaceSize < length){
            int l = 0;
            while (true){
                int m = l + spaceSize - 1;
                // 已经凑不齐 两个比较对了
                if(m >= length -1){
                    break;
                }
                // 边界判断
                int r = Math.min(m + spaceSize, length - 1);
                // 进行归并
                mergeSort(arr,l,m,r);
                l = r+1;

            }
            spaceSize = spaceSize << 1;
        }


    }

}
