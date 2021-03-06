package 图相关算法;

/**
 * @Author: pyh
 * @Date: 2019/3/1 8:24
 * @Version 1.0
 * @Function:      弗洛伊德(Floyd)算法是一种用于寻找给定的加权图中顶点间最短路径的算法
 * 可以正确处理有向图或负权的最短路径问题
 *
 * 基本思想：
 * 通过Floyd计算图G=(V,E)中各个顶点的最短路径时，
 * 需要引入一个矩阵S，矩阵S中的元素a[i][j]表示顶点i(第i个顶点)到顶点j(第j个顶点)的距离。
 */
public class Floyd {

    private int mEdgNum;        // 边的数量
    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵
    private static final int INF = Integer.MAX_VALUE;   // 最大值

    /*
     * floyd最短路径。
     * 即，统计图中各个顶点间的最短路径。
     *
     * 参数说明：
     *     path -- 路径。path[i][j]=k表示，"顶点i"到"顶点j"的最短路径会经过顶点k。
     *     dist -- 长度数组。即，dist[i][j]=sum表示，"顶点i"到"顶点j"的最短路径的长度是sum。
     */
    public void floyd(int[][] path, int[][] dist){
        //初始化
        for(int i = 0; i < mVexs.length; i++){
            for(int j = 0; j < mVexs.length; j++){
                dist[i][j] = mMatrix[i][j]; //"顶点i"到"顶点j"的路径长度为"i到j的权值"
                path[i][j] = j; //"顶点i"到"顶点j"的最短路径是经过顶点j
            }
        }

        //计算最短路径
        for(int k = 0; k < mVexs.length; k++){
            for(int i = 0; i < mVexs.length; i++){
                for(int j = 0; j < mVexs.length; j++){
                    //如果经过下标为k顶点路径比原两点间路径更短，则更新dist[i][j]和path[i][j]
                    int temp = (dist[i][k] == INF || dist[k][j] == INF) ? INF : (dist[i][k] + dist[k][j]);
                    if(dist[i][j] > temp){
                        //"i到j最短路径"对应的值设为更小的一个(即经过k)
                        dist[i][j] = temp;
                        //"i到j最短路径"对应的路径，经过k
                        path[i][j] = path[i][k];
                    }
                }
            }
        }

        //打印floyd最短路径的结果
        System.out.println("floyd:");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf("%2d ", dist[i][j]);
            System.out.println();
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
        Floyd pG = new Floyd(vexs, matrix);

        int[] prev = new int[pG.mVexs.length];
        int[] dist = new int[pG.mVexs.length];

        int[][] path = new int[pG.mVexs.length][pG.mVexs.length];
        int[][] floy = new int[pG.mVexs.length][pG.mVexs.length];
        // floyd算法获取各个顶点之间的最短距离
        pG.floyd(path, floy);
    }

    /*
     * 创建图(用已提供的矩阵)
     *
     * 参数说明：
     *     vexs  -- 顶点数组
     *     matrix-- 矩阵(数据)
     */
    public Floyd(char[] vexs, int[][] matrix) {

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
