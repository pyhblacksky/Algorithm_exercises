package HDU_OJ;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/3/5 15:33
 * @Version 1.0
 * @Function:   并查集相关问题
 *
 * 问题描述
 * 今天是伊格纳修斯的生日。他邀请了很多朋友。现在是晚餐时间。伊格纳修斯想知道他至少需要多少张桌子。
 * 你必须注意到并非所有的朋友都相互认识，并且所有的朋友都不想和陌生人呆在一起。
 *
 * 这个问题的一个重要规则是，如果我告诉你A知道B，B知道C，那意味着A，B，C彼此了解，所以他们可以留在一个表中。
 *
 * 例如：如果我告诉你A知道B，B知道C，D知道E，所以A，B，C可以留在一个表中，D，E必须留在另一个表中。
 * 所以Ignatius至少需要2张桌子。
 *
 *
 * 输入
 * 输入以整数T（1 <= T <= 25）开始，表示测试用例的数量。然后是T测试案例。
 * 每个测试用例以两个整数N和M开始（1 <= N，M <= 1000）。N表示朋友的数量，
 * 朋友从1到N标记。然后M行跟随。每一行由两个整数A和B（A！= B）组成，
 * 这意味着朋友A和朋友B彼此了解。两个案例之间会有一个空白行。
 *
 *
 * 输出
 * 对于每个测试用例，只输出Ignatius至少需要多少个表。不要打印任何空白。
 *
 *
 * 样本输入
 * 2
 * 5 3
 * 1 2
 * 2 3
 * 4 5
 *
 * 5 1
 * 2 5
 *
 *
 * 样本输出
 * 2
 * 4
 */
public class HDU1213_HowManyTables {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int T = scan.nextInt();
            while(T > 0){
                T--;
                int N = scan.nextInt();//朋友数量
                int M = scan.nextInt();//关系的行数

                int[] id = new int[N+1];//朋友间的认识关系
                //初始化
                for(int i = 1; i <= N; i++){
                    id[i] = i;
                }

                while(M > 0){
                    M--;
                    int x = scan.nextInt();
                    int y = scan.nextInt();
                    union(x, y, id);
                }

                //统计数量
                int num = 0;
                for(int i = 1; i <= N; i++){
                    if(id[i] == i){
                        num++;
                    }
                }
                System.out.println(num);
            }
        }
    }

    //并查集
    public static int find(int p, int[] id){
        while(p != id[p]){
            p = id[p];
        }
        return p;
    }
    public static void union(int p, int q, int[] id){
        int pRoot = find(p, id);
        int qRoot = find(q, id);

        if(pRoot != qRoot){
            id[pRoot] = qRoot;
        }
    }
}
