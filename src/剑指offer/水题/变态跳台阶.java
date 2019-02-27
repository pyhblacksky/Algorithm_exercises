package 剑指offer.水题;

/**
 * @Author: pyh
 * @Date: 2019/2/16 20:38
 * @Version 1.0
 * @Function:
 *      一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 *      思路：得出规律，写函数
 */
public class 变态跳台阶 {

    //观察得出规律
    public static int JumpFloorII(int target) {
        if(target <= 0){
            return 0;
        }

        int res = (int) Math.pow(2, target-1);
        return res;
    }

    public static void main(String[] args){
        for(int i = 1; i < 10; i++){
            System.out.println(JumpFloorII(i));
        }
    }

}
