package 剑指offer;

import java.util.HashMap;

/**
 * @Author: pyh
 * @Date: 2019/2/18 16:16
 * @Version 1.0
 * @Function:
 *      数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *      例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *      由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 */
public class 数组中出现次数超过一半的数字 {

    //方法一：使用HashMap存储
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < array.length; i++){
            if(!map.containsKey(array[i])){
                map.put(array[i], 1);
            } else if(map.containsKey(array[i])){
                int num = map.get(array[i]);
                map.put(array[i], num+1);
            }
        }

        for(int key : map.keySet()){
            if(map.get(key) > array.length/2){
                return key;
            }
        }
        return 0;
    }

    //方法二：巧解：采用题意特点
    public int MoreThanHalfNum_Solution1(int [] array){
        if(array == null || array.length == 0){
            return 0;
        }

        int num = array[0];
        int count = 1;
        for(int i = 1; i < array.length; i++){
            if(array[i] == num){
                count++;
            } else{
                count--;
            }
            if(count == 0){
                num = array[i];
                count = 1;
            }
        }

        //验证
        //验证的原因：如果这个数组中根本不存在个数大于数组长度一半的数，那么这个num就是一个不确定的值
        count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == num){
                count++;
            }
        }
        return (count*2 > array.length) ? num : 0;
    }

    //方法三：此数组排序后，如果有出现次数超过数据长度一半的数组，中间的数字必是这个数字

    public static void main(String[] args){

    }

}
