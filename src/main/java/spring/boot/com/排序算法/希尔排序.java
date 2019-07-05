package spring.boot.com.排序算法;

/**
 * @author: yiqq
 * @date: 2019/6/3
 * @description:
 */
public class 希尔排序 {

    /**性质：1、时间复杂度：O(nlogn) 2、空间复杂度：O(1) 3、非稳定排序 4、原地排序*/
    public static void main(String[] args) {

        int[] ins = {2,3,5,1,23,6,78,34,23,4,5,78,34,65,32,65,76,32,76,1,9};
        int[] ins2 = shell(ins);
        for(int in: ins2){
            System.out.println(in);
        }

//        int[] num = {64,55,3,266,232,66,44};
//        shellSort(num);
//        for (int i = 0; i < num.length; i++) {
//            System.out.println(num[i]);
//        }
    }

    public static int[] shell(int[] arrays) {
        //增量每次都/2
        for (int step = arrays.length / 2; step > 0; step /= 2) {
            //从增量那组开始进行插入排序，直至完毕
            for (int i = step; i < arrays.length; i++) {
                int j = i;
                int temp = arrays[j];
                // j - step 就是代表与它同组隔壁的元素
                while (j - step >= 0 && arrays[j - step] > temp) {
                    arrays[j] = arrays[j - step];
                    j = j - step;
                }
                arrays[j] = temp;
            }
        }
        return arrays;
    }


//    public static int[] shellSort(int[] ins) {
//        int n = ins.length;
//        int gap = n/2;
//        while(gap > 0){
//            for(int j = gap; j < n; j++){
//                int i=j;
//                while(i >= gap && ins[i-gap] > ins[i]){
//                    int temp = ins[i-gap]+ins[i];
//                    ins[i-gap] = temp-ins[i-gap];
//                    ins[i] = temp-ins[i-gap];
//                    i -= gap;
//                }
//            }
//            gap = gap/2;
//        }
//        return ins;
//    }

}
