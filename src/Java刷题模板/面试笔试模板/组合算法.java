package Java刷题模板.面试笔试模板;

import java.util.Arrays;

/**
 * @Author: pyh
 * @Date: 2019/5/8 16:15
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 *  对应的组合算法
 */
public class 组合算法 {

    public static void main(String[] args) {
        int[] num=new int[]{1,2,3,4,5,6,7};
        String str="";
        //求3个数的组合个数
//        count(0,str,num,3);
//        求1 - n个数的组合个数
        count1(4,str,num);
    }

    //i:当前位置，str:临时存储，num:要组合的数组
    private static void count1(int i, String str, int[] num) {
        if(i==num.length){
            System.out.println(str);
            return;
        }
        count1(i+1,str,num);    //不选
        count1(i+1,str+num[i]+",",num);     //选
    }

    //i:当前位置，str:临时存储，num:要组合的数组，n:未选数
    private static void count(int i, String str, int[] num,int n) {
        if(n==0){
            System.out.println(str);
            return;
        }
        if(i==num.length){
            return;
        }
        count(i+1,str+num[i]+",",num,n-1);  //选，注意n-1，未选数
        count(i+1,str,num,n);       //不选
    }

    public static void dfs(int[] input, int[] output, int index, int start) {
        if (index == output.length)//产生一个组合序列
            System.out.println(Arrays.toString(output));
        else {
            for (int j = start; j < input.length; j++) {
                output[index] = input[j];//记录选取的元素
                dfs(input, output, index + 1, j + 1);//选取下一个元素，可选下标区间为[j+1,input.length]
            }
        }
    }

}
