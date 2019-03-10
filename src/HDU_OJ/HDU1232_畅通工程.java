package HDU_OJ;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/3/5 14:48
 * @Version 1.0
 * @Function:   并查集相关题目
 *
 * Problem Description
 * 某省调查城镇交通状况，得到现有城镇道路统计表，表中列出了每条道路直接连通的城镇。
 * 省政府“畅通工程”的目标是使全省任何两个城镇间都可以实现交通
 * （但不一定有直接的道路相连，只要互相间接通过道路可达即可）。问最少还需要建设多少条道路？
 *
 *
 * Input
 * 测试输入包含若干测试用例。每个测试用例的第1行给出两个正整数，分别是城镇数目N ( < 1000 )和道路数目M；
 * 随后的M行对应M条道路，每行给出一对正整数，分别是该条道路直接连通的两个城镇的编号。为简单起见，城镇从1到N编号。
 * 注意:两个城市之间可以有多条道路相通,也就是说
 * 3 3
 * 1 2
 * 1 2
 * 2 1
 * 这种输入也是合法的
 * 当N为0时，输入结束，该用例不被处理。
 *
 *
 * Output
 * 对每个测试用例，在1行里输出最少还需要建设的道路数目。
 *
 *
 * Sample Input
 * 4 2
 * 1 3
 * 4 3
 * 3 3
 * 1 2
 * 1 3
 * 2 3
 * 5 2
 * 1 2
 * 3 5
 * 999 0
 * 0
 *
 *
 * Sample Output
 * 1
 * 0
 * 2
 * 998
 */
public class HDU1232_畅通工程 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int N = scan.nextInt();//城镇数目
            if(N == 0){break;}//N为0输入结束
            int M = scan.nextInt();//道路数目

            int[] id = new int[N+1];//城镇id
            int num = 0;//需要修建的数目

            //初始化
            for(int i = 1; i <= N; i++){
                id[i] = i;
            }

            //道路合并，连接
            while(M > 0){
                int x = scan.nextInt();
                int y = scan.nextInt();
                union(x,y,id);
                M--;
            }

            //计算没有路的数目，画图即明白
            for(int i = 1; i <= N; i++){
                if (id[i] == i){
                    num++;
                }
            }
            System.out.println(num-1);
        }
        scan.close();
    }
    //并查集——查找
    public static int find(int q, int[] id){
        int r = q;
        while(r != id[r]){
            r = id[r];
        }
        return r;
    }

    //并查集——连接
    public static void union(int p, int q, int[] id){
        int pRoot = find(p, id);
        int qRoot = find(q, id);
        if(pRoot != qRoot){
            id[pRoot] = qRoot;
        }
    }
}
