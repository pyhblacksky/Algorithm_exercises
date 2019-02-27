package 剑指offer.水题;

/**
 * @Author: pyh
 * @Date: 2019/2/16 20:52
 * @Version 1.0
 * @Function:
 *      我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 *      请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 *      思路：写出前几个结果，观察得出规律
 */
public class 矩形覆盖 {

    public int RectCover(int target) {
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
            target--;
            int temp = n2;
            n2 = n1 + n2;
            n1 = temp;
        }
        return n2;
    }

}
