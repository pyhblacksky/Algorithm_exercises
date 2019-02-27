package 剑指offer;

import java.util.ArrayList;

/**
 * @Author: pyh
 * @Date: 2019/2/18 19:47
 * @Version 1.0
 * @Function:
 *      把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 *      例如6、8都是丑数，但14不是，因为它包含质因子7。
 *      习惯上我们把1当做是第一个丑数。
 *      求按从小到大的顺序的第N个丑数。
 */
public class 丑数 {

    public static int GetUglyNumber_Solution(int index) {
        if(index == 0){
            return 0;
        }
        if(index == 1){
            return 1;
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for(int i = 0; i < index; i++){
            int min = Math.min(Math.min(list.get(p2)*2, list.get(p3)*3),list.get(p5)*5);

            if(min == list.get(p2)*2){
                p2++;
            }
            if(min == list.get(p3)*3){
                p3++;
            }
            if(min == list.get(p5)*5){
                p5++;
            }
            list.add(min);
        }
        return list.get(index-1);
    }

    public static void main(String[] args){
        GetUglyNumber_Solution(2);
    }
}
