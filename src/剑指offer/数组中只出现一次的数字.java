package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/19 8:50
 * @Version 1.0
 * @Function:
 *      一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 *
 *      找出只出现一次的两个数字！！    2个！
 *
 *      异或运算的性质 可以 找出只有一个数字出现了一次，其他出现了偶数次
 *
 *      思考方向：分组，以第一次全遍历的异或结果进行分组。
 *          分组方法：diff必不为0，diff写为二进制，必然有一位不为1，以此来进行分组
 */
public class 数组中只出现一次的数字 {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        int diff = 0;
        for(int i = 0; i < array.length; i++){
            diff = diff ^ array[i];
        }

        //分组标准是数字在这个位上的值是否为1
        for(int index = 0; index < 32; index++){
            if((diff & (1 << index)) != 0){
                diff = diff & (1 << index);
                break;
            }
        }

        num1[0] = 0;
        num2[0] = 0;
        for(int i = 0; i < array.length; i++){
            if((array[i] & diff) != 0){
                num1[0] ^= array[i];
            } else{
                num2[0] ^= array[i];
            }
        }

    }

    //扩展
    /**
     * 数组a中只有一个数出现一次，其他数都出现了2次，找出这个数字
     * @param a
     * @return
     */
    public static int find1From2(int[] a){
        int len = a.length, res = 0;
        for(int i = 0; i < len; i++){
            res = res ^ a[i];
        }
        return res;
    }
    /**
     * 数组a中只有一个数出现一次，其他数字都出现了3次，找出这个数字
     * @param a
     * @return
     *  申请了32位数组,然后把原数组中的每一个数字,展开成二进制,哪一位为1,那么bits[]那一位就+1.
     *  最终,判断bit中每一位是否是3的倍数(或者是0),如果是,那么我们要找的数字在这一位肯定为0,反之为1
     *  可以推广到n
     */
    public static int find1From3(int[] a){
        int[] bits = new int[32];
        int len = a.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < 32; j++){
                bits[j] = bits[j] + ((a[i]>>>j) & 1);
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++){
            if(bits[i] % 3 !=0){
                res = res | (1 << i);
            }
        }
        return res;
    }



    public static void main(String[] args){
        int[] arr = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];

        FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
    }
}
