import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Solution {
    int[] arr = new int[0];
    public static void main(String[] args){

        Solution s = new Solution();
        s.Insert('g');
        s.Insert('o');
        s.Insert('o');
        s.Insert('g');
        s.Insert('l');
        s.Insert('e');
        System.out.println(s.FirstAppearingOnce());

        //5,2,3,4,1,6,7,0,8
        s.Insert(5);
        s.GetMedian();
        s.Insert(2);
        s.GetMedian();
        s.Insert(3);
        s.GetMedian();
        s.Insert(4);
        s.GetMedian();
        s.Insert(1);
        s.GetMedian();
        s.Insert(6);
        s.GetMedian();
        s.Insert(7);
        s.GetMedian();
        s.Insert(0);
        s.GetMedian();
        s.Insert(8);
        s.GetMedian();
    }

    /*
    * 字符流中第一个不重复的字母
    * descript:
    * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
    * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
    * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
    * */
    ArrayList<Character> list = new ArrayList<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        list.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> collect = new HashSet<>();
        for(int i = 0; i < list.size(); i++){
            char temp = list.get(i);
            if(!collect.contains(temp)){
                collect.add(temp);
            } else{
                set.add(temp);
            }
        }

        char ch = '#';
        for(int i = 0; i < list.size(); i++){
            if(!set.contains(list.get(i))){
                return list.get(i);
            }
        }
        return ch;
    }

    /*
    * 数据流中的中位数
    * 从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
    * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
    * */

    public void Insert(Integer num) {
        int[] temp = new int[arr.length];
        for(int i = 0; i < temp.length; i++){
            temp[i] = arr[i];
        }
        arr = new int[temp.length+1];
        for(int i = 0; i < temp.length; i++){
            arr[i] = temp[i];
        }
        arr[arr.length-1] = num;

        sink(arr, arr.length-1);

    }

    public void sink(int[] arr, int k){
        while(k > 0 && arr[k] < arr[k-1]){
            swap(arr, k, k-1);
            k = k-1;
        }
    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public Double GetMedian() {
        printArr(arr);
        if(arr.length % 2 == 0){
            //偶数
            double res = (double) (arr[arr.length/2] + arr[arr.length/2 - 1]) / 2;
            return res;
        } else{
            return (double) arr[arr.length/2];
        }
    }

    public void printArr(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /*
    * 方法二：维护两个堆，大根堆和小根堆
    * */

}
