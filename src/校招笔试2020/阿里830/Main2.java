package 校招笔试2020.阿里830;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/8/30 18:54
 * @Version: 1.0
 * @Function:
 * @Description:
 * 小明和朋友们在学校里玩最幸福男生和最大团体的游戏，首先男生女生随机站成一圈，
 * 请你帮忙选出身边女生最多的男生为最幸福男生，以及按序号连续选择一批同学，
 * 最多可以选择k个女生，选出男生最多的团体并输出最多有多少个男生。
 *
输入:
bgbbbggbg(站成一圈的同学，首尾相接，b代表男生g代表女生)
k(最大团队最多可选女生数量)
输出:
最幸福男生所在位置(序号从0开始，如果存在多个，取按序号排第一个)，最大男生团队男生人数
输入范例:
bgbbbgbggbgbg
3
输出范例:
6 6
 */
public class Main2 {

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    //AC    80%
    static String getIndexAndLongest(String users, int k) {
        int max = -1;
        int maxIndex = -1;
        for(int i = 0; i < users.length(); i++){
            char c = users.charAt(i);
            if(c == 'b'){
                int p = i-1;
                int count = 0;
                while(p >= 0){
                    if(users.charAt(p) == 'g'){
                        count++;
                    } else if(users.charAt(p) == 'b')
                        break;
                    p--;
                }
                p = i+1;
                while(p < users.length()){
                    if(users.charAt(p) == 'g'){
                        count++;
                    }else if(users.charAt(p) == 'b')
                        break;
                    p++;
                }
                if(count > max){
                    max = count;
                    maxIndex = i;
                }
            }
        }

        //找女孩
        int removeCount = k;
        int maxBoy = 0;
        for(int i = 0; i < users.length(); i++){
            int count = 0;
            boolean flag = true;
            for(int j = i; j < users.length(); j++){
                char c = users.charAt(j);
                if (c == 'b') {
                    count++;
                } else if (c == 'g') {
                    removeCount--;
                }

                if(removeCount < 0){
                    flag = false;
                    break;
                }
                if(j+1 == users.length())
                    j = -1;//从头开始
            }

            if(!flag){
                maxBoy = Math.max(maxBoy, count);
                removeCount = k;
            }
        }


        return maxIndex + " " + maxBoy;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }

        int k = Integer.valueOf(in.nextLine());

        res = getIndexAndLongest(_users, k);
        System.out.println(res);
    }

}
