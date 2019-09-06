package 校招笔试2020._360_831;

import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/8/31 16:00
 * @Version: 1.0
 * @Function:
 * @Description:
 * 寻找子串
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 英语老师看你老是在英语课上和周围同学交头接耳，所以给你布置了一份额外的家庭作业来惩罚惩罚你：
 * 你有一个字符串s，请你在s的所有子串中，找到出现次数最多的子串，告诉老师它的出现次数。
 *
 * 输入
 * 共一行，一个字符串s，仅由英文小写字母组成，1≤|s|≤10000。
 *
 * 输出
 * 一个正整数，表示最大出现次数。
 *
 *
 * 样例输入
 * aba
 * 样例输出
 * 2
 *
 * 提示
 * aba的所有子串为a、b、a、ab、ba、aba，其中a的出现次数最多，出现了2次。
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(getRes(s));
    }

    //18%，内存超限
    static int getMax(String str){
        Map<String, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < str.length(); i++){
            for(int j = i+1; j <= str.length(); j++){
                //System.out.println(str.substring(i,j));
                map.put(str.substring(i, j), map.getOrDefault(str.substring(i,j), 0) + 1);
            }
        }

        int max = 1;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            max = Math.max(entry.getValue(), max);
        }

        return max;
    }

    //AC
    static int getRes(String input){
        char[] chars = input.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        TreeSet<String> set = new TreeSet<>();
        for(char c : chars){
            list.add(String.valueOf(c));
            set.add(String.valueOf(c));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
        }
        input = sb.toString();

        int max = 0;
        Iterator<String> its = set.iterator();
        while(its.hasNext()){
            String os = its.next();
            int begin = input.indexOf(os);
            int end = input.lastIndexOf(os);
            int value = end-begin+1;
            if(value >= max){
                max = value;
            }
        }

        return max;
    }

}
