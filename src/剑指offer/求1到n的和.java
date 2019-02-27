package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/19 15:17
 * @Version 1.0
 * @Function:
 *      求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class 求1到n的和 {

    //利用&&短路特性
    public int Sum_Solution(int n) {
        int ans = n;
        boolean judge = (n != 0) && (ans += (Sum_Solution(n-1))) != 0;
        return ans;
    }

}
