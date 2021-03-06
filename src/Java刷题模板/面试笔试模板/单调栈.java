package Java刷题模板.面试笔试模板;

import java.io.PrintStream;
import java.util.Stack;

/**
 * @Author: pyh
 * @Date: 2019/4/28 14:17
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * leetCode 42 接雨水那题类似单调栈的思路
 *
 *  解决的是: 快速寻找一个数组中每一个元素　左右两边离它arr[i]最近的比它大/小的数。
 *
 *  测试用例： 3 4 5 1 2
 */
public class 单调栈 {

    static PrintStream out = System.out;

    public static void main1(String[] args){
        int[] arr = {3,4,5,1,2};//测试数据
        int n = arr.length;

        /*  找到左边第一个比arr[i]大的    */
        int[] LL = new int[n];//LL[i]存的是左边第一个比arr[i]大的数的下标！
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    LL[top] = -1;//左边没有比arr[i]大的数
                } else{
                    LL[top] = stack.peek();
                }
            }
            stack.push(i);//下标入栈
        }

        //如果栈不为空，处理剩下的
        while(!stack.isEmpty()){
            int top = stack.pop();
            if(stack.isEmpty()){
                LL[top] = -1;
            } else{
                LL[top] = stack.peek();
            }
        }

        /***************************************/
        for(int i = 0; i < n; i++){
            out.print(LL[i] + " ");//打印下标
        }
        out.println();
        /**************************************/

        /*    找右边的第一个比arr[i]大的    */
        int[] RR = new int[n];//RR[i]存的是右边第一个比arr[i]大的数的下标
        stack = new Stack<>();
        for(int i = n -1; i >= 0; i--){
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    RR[top] = -1;//右边没有比arr[i]大的数
                } else{
                    RR[top] = stack.peek();
                }
            }
            stack.push(i);//下标入栈
        }

        //栈不为空
        while(!stack.isEmpty()){
            int top = stack.pop();
            if(stack.isEmpty()){
                RR[top] = -1;
            } else{
                RR[top] = stack.peek();
            }
        }

        /*****************************************/
        for(int i = 0; i < n; i++){
            out.print(RR[i] + " ");
        }
        out.println();
    }

    //给你一个数组 T = [73, 74, 75, 71, 69, 72, 76, 73]对于每一天，
    // 你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0 。
    static class Solution{
        public int[] getAns(int[] arr){
            if(arr == null || arr.length == 0)
                return arr;

            int[] ans = new int[arr.length];
            Stack<Integer> stack = new Stack<>();//存放的是下标
            int index = ans.length - 1;
            for(int i = arr.length-1; i >= 0; i--){
                while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                    stack.pop();
                }
                ans[index--] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return arr;
        }
    }


    public static void main(String[] args){
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        //答案  1, 1, 4, 2, 1, 1, 0, 0
        Solution solution = new Solution();
        solution.getAns(arr);
        String str = "abcdef";
        int a = str.indexOf("de");
        System.out.println(a);
    }
}
