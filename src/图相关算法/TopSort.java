package 图相关算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: pyh
 * @Date: 2019/3/1 15:16
 * @Version 1.0
 * @Function:       拓扑排序算法实现
 *
 * 拓扑排序算法的基本步骤：
 * 1. 构造一个队列Q(queue) 和 拓扑排序的结果队列T(topological)；
 * 2. 把所有没有依赖顶点的节点放入Q；
 * 3. 当Q还有顶点的时候，执行下面步骤：
 * 3.1 从Q中取出一个顶点n(将n从Q中删掉)，并放入T(将n加入到结果集中)；
 * 3.2 对n每一个邻接点m(n是起点，m是终点)；
 * 3.2.1 去掉边<n,m>;
 * 3.2.2 如果m没有依赖顶点，则把m放入Q;
 * 注：顶点A没有依赖顶点，是指不存在以A为终点的边。
 *
 */
public class TopSort {

    // 邻接表中表对应的链表的顶点
    private class ENode {
        int ivex;       // 该边所指向的顶点的位置
        ENode nextEdge; // 指向下一条弧的指针
    }

    // 邻接表中表的顶点
    private class VNode {
        char data;          // 顶点信息
        ENode firstEdge;    // 指向第一条依附该顶点的弧
    }

    private List<VNode> mVexs;  // 顶点数组

    /*
     * 拓扑排序
     *
     * 返回值：
     *     -1 -- 失败(由于内存不足等原因导致)
     *      0 -- 成功排序，并输入结果
     *      1 -- 失败(该有向图是有环的)
     */
    public int topologicalSort(){
        int index = 0;
        int num = mVexs.size();
        int[] ins = new int[num];                   //入度数组
        char[] tops = new char[num];                //拓扑排序结果数组，记录每个节点的排序后的序号
        Queue<Integer> queue = new LinkedList<>();  //辅助队列

        //统计每个顶点的入度数
        for(int i = 0; i < num; i++){
            ENode node = mVexs.get(i).firstEdge;
            while(node != null){
                ins[node.ivex]++;
                node = node.nextEdge;
            }
        }

        //将所有入度为0的顶点入队列
        for(int i = 0; i < num; i++){
            if (ins[i] == 0)
                queue.offer(i); //入队列
        }

        while(!queue.isEmpty()){                //队列非空
            int j = queue.poll().intValue();    //出队列，j时顶点的序号
            tops[index++] = mVexs.get(j).data;  //将该顶点添加到tops中，tops是排序结果
            ENode node = mVexs.get(j).firstEdge;//获取以该顶点为起点的出边队列

            //将与node关联的节点的入度减1；
            //若减1之后，该节点的入度为0；则将该节点添加到队列中
            while(node != null){
                //将节点（序号为node.ivex）的入度减1
                ins[node.ivex]--;
                //若节点的入度为0，则将其入队列
                if(ins[node.ivex] == 0){
                    queue.offer(node.ivex);
                }

                node = node.nextEdge;
            }
        }

        //该图存在环
        if(index != num){
            System.out.println("Graph has a cycle");
            return 1;
        }

        //打印拓扑排序结果
        System.out.println(" == TopSort : ");
        for(int i = 0; i < num; i++){
            System.out.println(tops[i]);
        }
        System.out.println();

        return 0;
    }

    /****************************************************************************************************/
    /*
     * 创建图(用已提供的矩阵)
     *
     * 参数说明：
     *     vexs  -- 顶点数组
     *     edges -- 边数组
     */
    public TopSort(char[] vexs, char[][] edges) {

        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;
        int elen = edges.length;

        // 初始化"顶点"
        mVexs = new ArrayList<VNode>();
        for (int i = 0; i < vlen; i++) {
            // 新建VNode
            VNode vnode = new VNode();
            vnode.data = vexs[i];
            vnode.firstEdge = null;
            // 将vnode添加到数组mVexs中
            mVexs.add(vnode);
        }

        // 初始化"边"
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点和结束顶点
            char c1 = edges[i][0];
            char c2 = edges[i][1];
            // 读取边的起始顶点和结束顶点
            int p1 = getPosition(edges[i][0]);
            int p2 = getPosition(edges[i][1]);

            // 初始化node1
            ENode node1 = new ENode();
            node1.ivex = p2;
            // 将node1链接到"p1所在链表的末尾"
            if(mVexs.get(p1).firstEdge == null)
                mVexs.get(p1).firstEdge = node1;
            else
                linkLast(mVexs.get(p1).firstEdge, node1);
        }
    }

    /*
     * 将node节点链接到list的最后
     */
    private void linkLast(ENode list, ENode node) {
        ENode p = list;

        while(p.nextEdge!=null)
            p = p.nextEdge;
        p.nextEdge = node;
    }

    /*
     * 返回ch位置
     */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.size(); i++)
            if(mVexs.get(i).data==ch)
                return i;
        return -1;
    }


    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = new char[][]{
                {'A', 'G'},
                {'B', 'A'},
                {'B', 'D'},
                {'C', 'F'},
                {'C', 'G'},
                {'D', 'E'},
                {'D', 'F'}};
        TopSort pG = new TopSort(vexs, edges);

        pG.topologicalSort();     // 拓扑排序
    }
}
