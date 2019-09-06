package 校招笔试2020.英语流利说;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: pyh
 * @Date: 2019/8/19 18:35
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class Solution2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        String[] times = line1.split(" ");
        String[] outTimes = line2.split(" ");
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for(int i = 0; i < times.length; i++){
            stack.push(i);
            max = Math.max(max, stack.size());
            while(!stack.isEmpty() && i+1 < times.length && Integer.valueOf(times[i+1]) >= Integer.valueOf(outTimes[stack.peek()])){
                stack.pop();
            }
        }

        System.out.println(max);
    }

}
