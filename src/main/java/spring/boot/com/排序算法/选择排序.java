package spring.boot.com.排序算法;

/**
 * @author: yiqq
 * @date: 2019/5/31
 * @description: 排序算法
 * https://zhuanlan.zhihu.com/p/57088609?utm_source=wechat_session&utm_medium=social&s_r=0#showWechatShareTip
 */
public class 选择排序 {
    /**
     *  首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)。
     *  其次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。这种方法我们称之为选择排序。
     *  性质：1、时间复杂度：O(n2) 2、空间复杂度：O(1) 3、非稳定排序 4、原地排序*/
    public static void main(String[] args) {
        int[] num = {64,55,3,266,232,66,44};
        selectSort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
    public static int[] selectSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if(a[min] > a[j]) {
                    min = j;
                }
            }
            //交换
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return a;
    }
    /**
     1、稳定排序：如果 a 原本在 b 的前面，且 a == b，排序之后 a 仍然在 b 的前面，则为稳定排序。

     2、非稳定排序：如果 a 原本在 b 的前面，且 a == b，排序之后 a 可能不在 b 的前面，则为非稳定排序。

     3、原地排序：原地排序就是指在排序过程中不申请多余的存储空间，只利用原来存储待排数据的存储空间进行比较和交换的数据排序。

     4、非原地排序：需要利用额外的数组来辅助排序。

     5、时间复杂度：一个算法执行所消耗的时间。

     6、空间复杂度：运行完一个算法所需的内存大小。
     */
}
