package spring.boot.com.排序算法;

/**
 * @author: yiqq
 * @date: 2019/7/24
 * @description:
 */
public class 二分查找 {
    public static void main(String[] args) {
        int[] num = {34,46,77,999,665,13,5,5667,66};
    }


    //递推查找
    public static int rank(int key,int[] arr,int low,int high){
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return arr[mid];
        } else if (arr[mid] < key) {
            return rank(key, arr, mid + 1, high);
        } else {
            return rank(key, arr, low, mid - 1);
        }
    }

    //非递归查找
    public static  int rank(int key,int[] arr){
        int low = 0;
        int high = arr.length - 1;
        //中间数的下标
        int mid = (low + high) / 2;
        while (low <= high) {   //退出循环的条件  若一直没找到这个数，则会退出循环
            if (arr[mid] == key) {
                return arr[mid]; //数组中间的数正好是被查找的数直接返回}
            } else if (arr[mid] < key) {
                low = mid + 1; //若小于被查找的数 则证明被查找的数只可能在数组右部分，则将右部分的数组重新进行一次二分查找
            } else {
                high = mid - 1;//同理
            }
                mid = (low + high) / 2;
            }
        return -1;
    }
}
