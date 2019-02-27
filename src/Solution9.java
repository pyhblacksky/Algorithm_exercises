import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Solution9 {

    //归并排序
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        mergeSort(arr, 0, arr.length-1);
    }
    private static void mergeSort(int[] arr, int lo, int hi){
        if(lo == hi){
            return;
        }
        int mid = lo + (hi-lo)/2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid+1, hi);
        merge(arr,lo, mid, hi);
    }
    private static void merge(int[] arr,int lo, int mid,int hi){
        int[] help = new int[hi-lo+1];
        int index = 0;
        int p1 = lo;
        int p2 = mid+1;
        while(p1 <= mid && p2 <= hi){
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[index++] = arr[p1++];
        }
        while(p2 <= hi){
            help[index++] = arr[p2++];
        }
        for(int i = 0; i < help.length; i++){
            arr[lo+i] = help[i];
        }
    }


    /**
     * 题目：数组中的逆序对
     * 描述：
     *  在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     *  输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
     *  即输出P%1000000007
     * */
    public static int mergeNum(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        int[] res = new int[1];
        res[0] = 0;
        mergeNum(arr, 0, arr.length - 1, res);
        return res[0] % 1000000007;
    }

    public static void mergeNum(int[] arr, int lo, int hi, int[] res){
        if(lo >= hi){
            return;
        }

        int mid = lo + (hi-lo)/2;
        mergeNum(arr, lo, mid, res);
        mergeNum(arr, mid+1, hi, res);
        mergeCount(arr, lo, mid, hi, res);
    }

    //归并时，计算比当前数大的数
    public static void mergeCount(int[] arr, int lo, int mid ,int hi, int[] res){
        int[] help = new int[hi-lo+1];
        int index = 0;
        int p1 = lo;
        int p2 = mid+1;
        while(p1 <= mid && p2 <= hi){

            if(arr[p1] <= arr[p2]){
                help[index++] = arr[p1++];
            } else{
                help[index++] = arr[p2++];
                //合并数组，合并时，出现前面的数组值arr[p1]大于后面数组值arr[p2]时,即arr[p1] > arr[p2]；
                // 则前面数组arr[p1]~arr[mid]都是大于arr[p2]的，count += mid + 1 - p1
                res[0] += mid - p1 +1;
                res[0] = res[0] % 1000000007;
            }
        }
        while(p1 <= mid){
            help[index++] = arr[p1++];
        }
        while(p2 <= hi){
            help[index++] = arr[p2++];
        }
        for(int i = 0; i < help.length; i++){
            arr[lo+i] = help[i];
        }
    }

    public static void main(String[] args){

        int[] arr = {1,2,3,2,5,6,7,0};
        /*
        Tools.printArrInt(arr);
        Solution9 s = new Solution9();
        s.mergeSort(arr);
        Tools.printArrInt(arr);
        */
        System.out.println(mergeNum(arr));
        //新建时间对象
        Date date = new Date();
        //getTime()是以当前秒数输出，date是默认格式输出
        System.out.println(date.getTime()+ "\n" + date);
        //需要自定义时间格式需要新建一个DateFormat对象，"yyyy-MM-dd HH:mm:ss"是指定格式输出
        //每个字母代表的意义建议查询jdk doc文件
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //使用这样的方法来将DateFormat格式套用到Date中：df.format(date)
        System.out.println(df.format(date));
        System.out.println(UUID.randomUUID());
    }


}
