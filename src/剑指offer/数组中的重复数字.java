package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/19 16:59
 * @Version 1.0
 * @Function:
 *      在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 *      数组中某些数字是重复的，但不知道有几个数字是重复的。
 *      也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *      例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 */
public class 数组中的重复数字 {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length == 0 || numbers == null || numbers.length == 0){
            return false;
        }

        //桶计数
        int[] bits = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            bits[numbers[i]]++;
            if(bits[numbers[i]] > 1){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

}
