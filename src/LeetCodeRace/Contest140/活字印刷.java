package LeetCodeRace.Contest140;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: pyh
 * @Date: 2019/6/9 10:37
 * @Version: 1.0
 * @Function:
 * @Description:
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 *
 * 输入："AAABBC"
 * 输出：188
 *
 *
 * 提示：
 *
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 */
public class 活字印刷 {

    //优化方法
    public int numTilePossibilities(String tiles) {
        if(tiles == null || tiles.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tiles.length(); i++){
            char c = tiles.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return help(map)-1;
    }
    private int help(Map<Character, Integer> map){
        int res = 1;
        for(char c : map.keySet()){
            if(map.get(c) == 0){
                continue;
            }
            map.put(c, map.get(c) - 1);
            res += help(map);
            map.put(c, map.get(c) + 1);
        }
        return res;
    }


    /********************************************************************/
    //排列+组合   方法2
    public int numTilePossibilities1(String tiles) {
        HashSet<String> set = new HashSet<>();
        char[] chs = tiles.toCharArray();
        for(int i = 0; i <= tiles.length(); i++)
            count(0, "", chs, i, set);
        return set.size() - 1;//去除一个空串
    }

    private static void count(int i, String str, char[] num, int n, HashSet<String> set) {
        if(n==0){
            permutation(new char[str.length()], str.toCharArray(), 0, str.length(), set);
            set.add(str);
            return;
        }
        if(i==num.length){
            return;
        }
        count(i+1,str+num[i],num,n-1, set);  //选，注意n-1，未选数
        count(i+1,str,num,n, set);       //不选
    }


    //数组的去重全排列
    //tmp存放排列，arr是原数组
    static void permutation(char[] tmp, char[] arr, int cur, int n, HashSet<String> set){
        if(cur == n){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                //System.out.print(tmp[i] + " ");
                sb.append(tmp[i]);
            }
            set.add(sb.toString());
            //System.out.println();
        } else{
            for(int i = 0; i < n; i++){
                if(i == 0 || arr[i] != arr[i-1]){
                    int c1 = 0;
                    int c2 = 0;
                    for(int j = 0; j < n; j++){
                        if(arr[j] == arr[i]){
                            //重复元素的个数
                            c1++;
                        }
                    }
                    for (int j = 0; j < cur; j++){
                        if(tmp[j] == arr[i]){
                            //前面已经排列的重复元素的个数
                            c2++;
                        }
                    }
                    if(c2 < c1){
                        tmp[cur] = arr[i];
                        permutation(tmp, arr, cur+1, n, set);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        活字印刷 solution = new 活字印刷();
        String str = "AAABBC";
        System.out.println(solution.numTilePossibilities(str));
    }

}
