package 校招笔试2020._360_831;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: pyh
 * @Date: 2019/8/31 16:00
 * @Version: 1.0
 * @Function:
 * @Description:
 * 散步
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 饭后散步是一个很好的习惯，一天晚上，小A在一条笔直的路上散步，起点在路上某处，
 * 但是因为路上没有标识，他并不知道这个位于路上的那个位置，现在将道路划分为N-1个等距的部分，
 * 你可以把这条路当成一个数轴，道路上的结点标记为1~N，起点和终点只可能是这N个点中的一个。
 *
 * 但是小A还提供了一个重要信息，他每隔一段时间就会用手机看一下自己走了多远，
 * 记作D，但是他并不记得他是朝着哪个方向走的，唯一可以确定的是，
 * 在两次看手机的间隔中他不会改变方向，每次看完手机后他可能继续向前或者回头走。
 *
 * 那么问题来了，已知他在散步过程中始终在1~N的范围内，那么符合上述条件的“终点”可能有多少个呢？
 *
 * 输出
 * 输出仅包含一个整数，表示可能的起点的数量。
 *
 *
 * 样例输入
 * 10 3
 * 5
 * 2
 * 6
 * 样例输出
 * 8
 * (3,8不行)
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[M];
        for(int i = 0; i < M; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(getRes(N, arr));
    }

    //尝试模拟      AC
    static int getRes(int N, int[] arr){
        //求终点的个数
        Set<Integer> set = new LinkedHashSet<>();
        for(int i = 1; i <= N; i++){
            isRight(arr, i, 0, N, set);
        }

        return set.size();
    }

    static boolean isRight(int[] arr, int now, int index, int thread, Set<Integer> set){
        if(now < 1 || now > thread)
            return false;
        if(index >= arr.length){
            if(set.contains(now))
                return false;
            set.add(now);
            return true;
        }


        boolean left = isRight(arr, now - arr[index], index+1, thread, set);//左走
        boolean right = isRight(arr, now + arr[index], index+1, thread, set);//右走

        return left || right;
    }

}
