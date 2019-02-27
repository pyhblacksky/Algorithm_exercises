package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/18 20:23
 * @Version 1.0
 * @Function:
 *      在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *      输入一个数组,求出这个数组中的逆序对的总数P。
 *      并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 *      输入描述:
 *      题目保证输入的数组中没有的相同的数字
 *      数据范围：
 * 	    对于%50的数据,size<=10^4
 * 	    对于%75的数据,size<=10^5
 * 	    对于%100的数据,size<=2*10^5
 *
 */
public class 数组中的逆序对 {

    public int InversePairs(int [] array) {
        if(array == null || array.length <= 1){
            return 0;
        }
        int[] res = {0};
        div(array, 0, array.length-1, res);

        res[0] %= 1000000007;
        return res[0];
    }

    //归并改进
    public static void div(int[] arr, int L, int R, int[] res){
        if(L >= R){
            return;
        }

        int mid = L + ((R-L)>>1);
        div(arr, L, mid, res);
        div(arr, mid+1, R, res);
        merge(arr, L, mid, R, res);
    }
    private static void merge(int[] arr, int L, int mid, int R, int[] res){
        int p1 = L;
        int p2 = mid+1;
        int[] help = new int[R-L+1];
        int index = 0;
        while(p1 <= mid && p2 <= R){
            if(arr[p1] <= arr[p2]){
                help[index++] = arr[p1++];
            } else{
                help[index++] = arr[p2++];
                res[0] += mid - p1 + 1; //减去前面比此数小的，因为p1++过一次，所以mid - (p1-1)
                res[0] %= 1000000007;
            }
        }

        while(p1 <= mid){
            help[index++] = arr[p1++];
        }
        while(p2 <= R){
            help[index++] = arr[p2++];
        }

        for(int i = 0; i < help.length; i++){
            arr[L+i] = help[i];
        }
    }

}
