package 校招真题_2018.唯品会_2018;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/8 15:41
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 输入一个字符串，输出该字符串中相邻字符的所有组合。(注意 相邻字符)
 * 举个例子，如果输入abc，它的组合有a、b、c、ab、bc、abc。（注意：输出的组合需要去重）（40分）
 * 输入描述:
 * 一个字符串
 * 输出描述:
 * 一行，每个组合以空格分隔，相同长度的组合需要以字典序排序，且去重。
 *
 * 示例1
 * 输入
 * bac
 *
 * 输出
 * a b c ac ba bac
 *
 * 输入
 * array
 * 输出
 * a r y ar ay ra rr arr ray rra arra rray array
 */
public class 字符串组合 {

    //(注意 相邻字符)
    //检查是否连续，用str.contains()方法
    //实际应该是寻找字符串的所有子串

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        String[] res = getSelectStr(str);
        for(String s : res){
            System.out.print(s+" ");
        }
        System.out.println();
    }

    static String[] getSelectStr(String str){
        if(str == null || str.length() == 0){
            return null;
        }

        String temp = new String();
        char[] arr = str.toCharArray();
        HashSet<String> set = new HashSet<>();
        count(0, temp, arr, set);

        //将set中的元素排序
        String[] res = new String[set.size()-1];//排除空字符串
        int index = 0;
        int countNoAdjoin = 0;
        for(String s : set){
            if(s != null && s.length() > 0){
                res[index++] = s;
                if(!str.contains(s)){
                    countNoAdjoin++;
                }
            }
        }

        //去除不相邻
        String[] result = new String[res.length-countNoAdjoin];
        int resIndex = 0;
        for(int i = 0; i < res.length; i++){
            if(!str.contains(res[i])){
                continue;
            }
            result[resIndex++] = res[i];
        }

        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()){
                    return 1;
                } else if(o1.length() < o2.length()){
                    return -1;
                } else{
                    //长度相等，以字典序排序
                    for(int i = 0; i < o1.length(); i++){
                        if(o1.charAt(i) > o2.charAt(i)){
                            return 1;
                        } else if(o1.charAt(i) < o2.charAt(i)){
                            return -1;
                        }
                    }
                    return 0;
                }
            }
        });

        return result;
    }

    //i : 当前位置   arr数组长度    输出字符
    static void count(int i, String str, char[] arr, HashSet<String> set) {
        if(i == arr.length){
            set.add(str);//去重
            return;
        }
        count(i+1, str, arr, set);//不选

        if(str != null && str.length() > 0){
            char before = str.charAt(str.length()-1);
            if(i > 0 && arr[i-1] == before){
                //字符连续,才选
                count(i+1, str+arr[i], arr, set);//选
            }
        } else{
            count(i+1, str+arr[i], arr, set);//选
        }
    }
}
