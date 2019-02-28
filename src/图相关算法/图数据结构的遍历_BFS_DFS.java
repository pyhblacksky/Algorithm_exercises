package 图相关算法;

import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/2/28 16:14
 * @Version 1.0
 * @Function:   实现图数据结构的遍历      广度优先和深度优先遍历
 *
 * 宽度优先搜索(BFS）遍历图需要使用队列queue数据结构； 深度优先搜索(DFS, Depth First Search)的实现
 * 需要使用到栈stack数据结构。
 *
 * java中虽然有Queue接口，单java并没有给出具体的队列实现类，
 * 而Java中让LinkedList类实现了Queue接口，所以使用队列的时候，一般采用LinkedList。
 * 因为LinkedList是双向链表，可以很方便的实现队列的所有功能。
 * java中定义队列 一般这样定义： Queue queue = new LinkedList();
 *
 * java中的栈由java.util.Stack类实现，是一个后进先出（last in first out，LIFO）的堆栈，
 * 在Vector类的基础上扩展5个方法而来。
 */
public class 图数据结构的遍历_BFS_DFS {

    private Map<String, List<String>> graph = new HashMap<>();

    /**
     * 初始化图数据：使用邻居表来表示图数据。
     */
    public void initGraphData() {
//        图结构如下
//          1
//        /   \
//       2     3
//      / \   / \
//     4  5  6  7
//      \ | / \ /
//        8    9
        graph.put("1", Arrays.asList("2", "3"));
        graph.put("2", Arrays.asList("1", "4", "5"));
        graph.put("3", Arrays.asList("1", "6", "7"));
        graph.put("4", Arrays.asList("2", "8"));
        graph.put("5", Arrays.asList("2", "8"));
        graph.put("6", Arrays.asList("3", "8", "9"));
        graph.put("7", Arrays.asList("3", "9"));
        graph.put("8", Arrays.asList("4", "5", "6"));
        graph.put("9", Arrays.asList("6", "7"));
    }

    /******************************************************************************************************/
    /**
     * 宽度优先搜索(BFS, Breadth First Search)
     * BFS使用队列(queue)来实施算法过程
     * */
    private Queue<String> queue = new LinkedList<>();//存储数据
    private Map<String, Boolean> status1 = new HashMap<>();//用来判断是否已经遍历过

    /**
     * 开始点
     * */
    public void BFSSearch(String startPoint){
        //起始点放入queue
        queue.offer(startPoint);
        status1.put(startPoint, false);
        bfsLoop();
    }
    private void bfsLoop(){
        //  1) 从queue中取出队列头的点；更新状态为已经遍历。
        String currentQueueHeader = queue.poll();   //出队
        status1.put(currentQueueHeader, true);
        System.out.println(currentQueueHeader);
        //  2) 找出与此点邻接的且尚未遍历的点，进行标记，然后全部放入queue中。
        List<String> neighborPoints = graph.get(currentQueueHeader);
        for(String point : neighborPoints){
            //如果未被遍历
            if(!status1.getOrDefault(point, false)){
                //getOrDefault() 当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
                if(queue.contains(point))
                    continue;
                queue.offer(point);
                status1.put(point, false);
            }
        }

        //如果队列不为空继续遍历
        if(!queue.isEmpty()){
            bfsLoop();
        }
    }

    /******************************************************************************************************/
    /**
     * 深度优先搜索(DFS，Depth First Search)
     * DFS使用栈(Stack)来实现算法
     * stack具有后进先出的特性(LIFO)
     *
     * DFS步骤
     * 1. 把起始点放入stack
     * 2. 重复下述3个步骤，直到stack为空为止
     * 3. 从stack中访问栈顶的点
     * 4. 找出与此点邻接的且尚未遍历的点，进行标记，然后全部放入stack中
     * 5. 如果此点没有尚未遍历的邻接点，则将此点从stack中弹出
     * */
    private Stack<String> stack = new Stack<>();
    private Map<String, Boolean> status2 = new HashMap<>();
    public void DFSSearch(String startpoint){
        stack.push(startpoint);
        status2.put(startpoint, true);
        dfsLoop();
    }
    private void dfsLoop(){
        if(stack.isEmpty()){
            return;
        }

        //查看栈顶元素，但不出栈
        String stackTopPoint = stack.peek();
        //找出与此点邻接的且尚未遍历的点，进行标记，然后放入stack中
        List<String> neighborPoints = graph.get(stackTopPoint);
        for(String point : neighborPoints){
            if(!status2.getOrDefault(point, false)){//未被遍历
                stack.push(point);
                status2.put(point, true);
                dfsLoop();
            }
        }
        String popPoint = stack.pop();
        System.out.println(popPoint);//将顺序倒过来即为深搜
    }

    public static void main(String[] args){
        图数据结构的遍历_BFS_DFS test = new 图数据结构的遍历_BFS_DFS();
        test.initGraphData();
        //test.DFSSearch("1");
        test.BFSSearch("1");
    }
}
