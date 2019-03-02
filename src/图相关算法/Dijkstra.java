package 图相关算法;

/**
 * @Author: pyh
 * @Date: 2019/3/1 20:07
 * @Version 1.0
 * @Function:   Dijkstra算法  最短路径算法
 *
 * 操作步骤
 * (1) 初始时，S只包含起点s；U包含除s外的其他顶点，且U中顶点的距离为"起点s到该顶点的距离"
 *      [例如，U中顶点v的距离为(s,v)的长度，然后s和v不相邻，则v的距离为∞]。
 * (2) 从U中选出"距离最短的顶点k"，并将顶点k加入到S中；同时，从U中移除顶点k。
 * (3) 更新U中各个顶点到起点s的距离。之所以更新U中顶点的距离，是由于上一步中确定了k是求出最短路径的顶点，
 *      从而可以利用k来更新其它顶点的距离；例如，(s,v)的距离可能大于(s,k)+(k,v)的距离。
 * (4) 重复步骤(2)和(3)，直到遍历完所有顶点。
 */
public class Dijkstra {

    //使用邻接矩阵
    private int mEdgNum;        // 边的数量
    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵
    private static final int INF = Integer.MAX_VALUE;   // 最大值

    /*
     * Dijkstra最短路径。
     * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
     *
     * 参数说明：
     *       vs -- 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
     *     prev -- 前驱顶点数组。即，
     *          prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
     *     dist -- 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
     */
    public void dijkstra(int vs, int[] prev, int[] dist){
         //flag[i] = true,表示"顶点vs"到“顶点i”的最短路径已经成功获取
        boolean[] flag = new boolean[mVexs.length];

        //初始化
        for(int i = 0; i < mVexs.length; i++){
            flag[i] = false;            //顶点i的最短路径还没获取到
            prev[i] = 0;                //顶点i的前驱节点为0
            dist[i] = mMatrix[vs][i];   //顶点i的最短路径为“顶点vs”到“顶点i”的权
        }

        //对“顶点vs”自身进行初始化
        flag[vs] = true;
        dist[vs] = 0;

        //遍历mVex.length-1次(除开自己)， 每次找出一个顶点的最短路径
        int k = 0;
        for(int i = 1; i < mVexs.length; i++){
            //寻找当前最短路径，即在未获取最短路径的顶点中，找到离vs最近的顶点(k)
            int min = INF;
            for(int j = 0; j < mVexs.length; j++){
                if(flag[j] == false && dist[j] < min){
                    min = dist[j];
                    k = j;
                }
            }

            //标记顶点k为已获取到的最短路径
            flag[k] = true;

            //修正当前最短路径和前驱顶点，
            // 即，当已经获取到“顶点k的最短路径”后，更新“未获取最短路径顶点的最短路径和前驱顶点”
            for(int j = 0; j < mVexs.length; j++){
                int temp = (mMatrix[k][j] == INF ? INF : (min + mMatrix[k][j]));
                if(flag[j] == false && (temp < dist[j])){
                    dist[j] = temp;
                    prev[j] = k;
                }
            }
        }

        //打印dijkstra最短路径的结果
        System.out.println("dijkstra(" + mVexs[vs] + "):");
        for(int i = 0; i < mVexs.length; i++){
            System.out.println("Shortest " + mVexs[vs] + ", " + mVexs[i] + " = " + dist[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                        /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        Dijkstra pG = new Dijkstra(vexs, matrix);

        int[] prev = new int[pG.mVexs.length];
        int[] dist = new int[pG.mVexs.length];
        // dijkstra算法获取"第4个顶点"到其它各个顶点的最短距离
        pG.dijkstra(3, prev, dist);
    }

    /*
     * 创建图(用已提供的矩阵)
     *
     * 参数说明：
     *     vexs  -- 顶点数组
     *     matrix-- 矩阵(数据)
     */
    public Dijkstra(char[] vexs, int[][] matrix) {

        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;

        // 初始化"顶点"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++)
            mVexs[i] = vexs[i];

        // 初始化"边"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++)
            for (int j = 0; j < vlen; j++)
                mMatrix[i][j] = matrix[i][j];

        // 统计"边"
        mEdgNum = 0;
        for (int i = 0; i < vlen; i++)
            for (int j = i+1; j < vlen; j++)
                if (mMatrix[i][j]!=INF)
                    mEdgNum++;
    }
}
