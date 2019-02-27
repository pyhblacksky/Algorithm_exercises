package 剑指offer.水题;

/**
 * @Author: pyh
 * @Date: 2019/2/16 20:28
 * @Version 1.0
 * @Function:
 *      一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 *      求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 *      思考：写出通项公式 F(n) = F(n-1)+F(n-2)，发现类似斐波那契数列
 */
public class 跳台阶 {

    //非递归版
    public int JumpFloor(int target) {
        if(target <= 0){
            return 0;
        }

        if(target == 1){
            return 1;
        }

        if(target == 2){
            return 2;
        }

        int n1 = 1;
        int n2 = 2;
        while(target >= 3){
            int temp = n2;
            n2 = n1 + n2;
            n1 = temp;
            target--;
        }
        return n2;
    }

    //递归版
    public int JumpFloor1(int target){
        if(target <= 0){
            return 0;
        }

        if(target == 1){
            return 1;
        }

        if(target == 2){
            return 2;
        }

        return JumpFloor1(target-1) + JumpFloor1(target -2);
    }

}
