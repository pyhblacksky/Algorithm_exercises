package 图相关算法;

/**
 * @Author: pyh
 * @Date: 2019/3/1 19:13
 * @Version 1.0
 * @Function:   Prim算法      最小生成树算法
 *
 * 普里姆(Prim)算法，是用来求加权连通图的最小生成树的算法。
 *
 * 基本思想
 * 对于图G而言，V是所有顶点的集合；现在，设置两个新的集合U和T，
 * 其中U用于存放G的最小生成树中的顶点，T存放G的最小生成树中的边。
 * 从所有uЄU，vЄ(V-U) (V-U表示出去U的所有顶点)的边中选取权值最小的边(u, v)，将顶点v加入集合U中，
 * 将边(u, v)加入集合T中，如此不断重复，直到U=V为止，
 * 最小生成树构造完毕，这时集合T中包含了最小生成树中的所有边。
 */
public class Prim {

    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵
    private static final int INF = Integer.MAX_VALUE;   // 最大值

    /*
     * prim最小生成树
     *
     * 参数说明：
     *   start -- 从图中的第start个元素开始，生成最小树
     */
    public void prim(int start){
        int num = mVexs.length;     //顶点个数
        int index = 0;              //prim最小树的索引，即prims数组的索引
        char[] prims = new char[num];//prim最小树的结果数组
        int[] weights = new int[num];//顶点间边的权值

        //prim最小生成树中第一个数是“图中第start个顶点”，因为从start开始
        prims[index++] = mVexs[start];

        //初始化“顶点权值数组”，将每个顶点的权值初始化为“第start个顶点”到“该顶点”的权值
        for(int i = 0; i < num;i++){
            weights[i] = mMatrix[start][i];
        }
        //将第start个顶点的权值初始化为0，可以理解为“第start个顶点到自身的距离为0”
        weights[start] = 0;

        for(int i = 0; i < num; i++){
            //由于从start开始，因此不需要再对start个顶点进行处理
            if(start == i){continue;}

            int j = 0, k = 0, min = INF;
            //在未被加入到最小生成树的顶点中，找出权值最小的顶点
            while(j < num){
                //若weights[j] == 0，表示“第j个节点已经被排序过（已经加入到最小生成树中）”
                if(weights[j] != 0 && weights[j] < min){
                    min = weights[j];
                    k = j;  //最小节点
                }
                j++;
            }

            //经过上面处理后，在未被加入到最小生成树的顶点中，权值最小的顶点是第k个顶点
            //将第k个顶点加入到最小生成树的结果数组中
            prims[index++] = mVexs[k];

            //将“第k个顶点”的权值标记为0，表示第k个顶点已经排序过（已经加入最小生成树中）
            weights[k] = 0;

            //当第k个顶点被加入到最小生成树的结果数组中之后，更新其它顶点的权值
            for(j = 0; j < num; j++){
                //当第j个节点没有被处理，并且需要更新时才被更新
                if(weights[j] != 0 && mMatrix[k][j] < weights[j]){
                    weights[j] = mMatrix[k][j];
                }
            }
        }

        //计算最小生成树的权值
        int sum = 0;
        for(int i = 1; i < index; i++){
            int min = INF;
            //获取prims[i]在mMatrix中的位置
            int n = getPosition(prims[i]);
            //在 vexs[0...i]中，找出到j的权值最小的顶点
            for(int j = 0; j < i; j++){
                int m = getPosition(prims[j]);
                min = Math.min(mMatrix[m][n], min);
            }
            sum += min;
        }

        //打印最小生成树
        System.out.println("Prim = " + sum);
        for(int i = 0; i < index; i++){
            System.out.print(prims[i]);
        }
        System.out.println();
    }

    /*
     * 返回ch位置
     */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++)
            if(mVexs[i]==ch)
                return i;
        return -1;
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
        Prim pG = new Prim(vexs, matrix);

        pG.prim(0);   // Kruskal算法生成最小生成树
    }

    /*
     * 创建图(用已提供的矩阵)
     *
     * 参数说明：
     *     vexs  -- 顶点数组
     *     matrix-- 矩阵(数据)
     */
    public Prim(char[] vexs, int[][] matrix) {

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

    }
}
