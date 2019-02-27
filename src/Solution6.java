import java.util.ArrayList;
import java.util.Arrays;

public class Solution6 {

    /**
     * 题目：扑克牌顺子
     * 描述：
     *  LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
     *  他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
     *  “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,
     *  决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),
     *  “So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
     *  如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
     *
     * 方法：
     * */
    public boolean isContinuous(int [] numbers) {
        //输入的是5个数，为空，返回false
        if(numbers.length == 0){
            return false;
        }

        //排序
        Arrays.sort(numbers);

        //计算为0数,可以代替所有数
        int countZero = 0;
        //计算相差数
        int gap = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[0] == 0){
                countZero++;
                continue;
            }

            if(i+1 < numbers.length){
                //相同，直接返回false
                if(numbers[i+1] == numbers[i]){
                    return false;
                }
                gap += numbers[i+1] - numbers[i] - 1;
            }
        }

        if(countZero >= gap){
            return true;
        }
        return  false;
    }

    /**
     * 题目：孩子们的游戏（圆圈中最后剩下的数）
     * 描述：
     *  每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
     *  HF作为牛客的资深元老,自然也准备了一些小游戏。
     *  其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
     *  然后,他随机指定一个数m,让编号为0的小朋友开始报数。
     *  每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
     *  从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
     *  并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
     *  请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
     *
     *  方法：
     *      举例推理
     * */
    public int LastRemaining_Solution(int n, int m) {

        if(n <= 0 || m <= 0){
            return -1;
        }

        if(n == 1){
            return 0;
        }

        //添加编号
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i);
        }

        //目标，list中只剩一个
        int save = 0;//保存上一次报数编号
        int index = -1;//当前报数编号
        while(list.size() > 1){
            //每一轮
            for(int i = 0; i < m; i++){
                if(index >= list.size()-1){
                    index = 0;//回归0开始
                    continue;
                }
                index++;
            }
            System.out.println("移除编号： " + list.get(index));
            list.remove(index);
            index--;//从下一个开始，因为删除了，所以前推
        }

        return list.get(0);
    }

    public static void main(String[] args){
        Solution6 s6 = new Solution6();
        int[] a1 = {1,2,3,4,5};
        int[] a2 = {1,3,4,5,6};
        int[] a3 = {0,0,0,7,5};
        int[] a4 = {0,3,2,6,4};
        p(s6.isContinuous(a1));
        p(s6.isContinuous(a2));
        p(s6.isContinuous(a3));
        p(s6.isContinuous(a4));

        System.out.println(s6.LastRemaining_Solution(5,7));

    }

    public static void p(boolean a){
        System.out.println(a);
    }

}
