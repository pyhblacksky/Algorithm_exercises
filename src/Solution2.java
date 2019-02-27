import java.util.*;

public class Solution2 {

    /*
     * 数据流中的中位数
     * 从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     * 方法二：维护两个堆，大根堆和小根堆
     * */
    public static void heapAdjust(int[] arr, int parent, int length){
        int child = parent*2+1;
        while(child < length){
            if(child+1 < length && arr[child+1] < arr[child]){
                child++;
            }
            if(arr[parent] < arr[child]){
                break;
            }

            swap(arr, parent, child);
            parent = child;
            child = parent*2+1;
        }
    }
    public static void sink(int[] arr, int k){
        while(arr[k] < arr[k/2]){
            swap(arr, k, k/2);
            k = k/2;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapSort(int[] a){
        for(int i = 0; i < a.length; i++){
            sink(a, i);
        }
        for(int i = a.length-1; i > 0; i--){
            swap(a, i, 0);
            heapAdjust(a, 0, i);
        }
    }
    /***********************************************************************************/

    //用PriorityQueue，默认是小根堆，可以使用比较器改为大根堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    private int count = 0;

    public void Insert(Integer num){
        count++;
        if(count % 2 == 0){//偶数
            maxHeap.offer(num);
            int filter = maxHeap.poll();
            minHeap.offer(filter);
        } else {
            minHeap.offer(num);
            int filter = minHeap.poll();
            maxHeap.offer(filter);
        }
    }

    public Double GetMedian(){
        double res;
        if(count % 2 == 0){
            res = (maxHeap.peek()+minHeap.peek())/2.0;
        } else{
            res = maxHeap.peek();
        }
        return res;
    }

    /***********************************************************************************/
    /*
    * 实现按行打印二叉树
    * */
    public static class TreeNode{
        TreeNode left = null;
        TreeNode right = null;
        int val = 0;
        TreeNode(int val){
            this.val = val;
        }
    }

    //按行打印，设置标志位
    public static ArrayList<ArrayList<Integer>> PrintTreeRow(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        ArrayList<Integer> saveRow = new ArrayList<>();

        TreeNode pre = root;
        TreeNode after = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            saveRow.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
                after = node.left;
            }
            if(node.right != null){
                queue.offer(node.right);
                after = node.right;
            }

            if(pre == node){
                res.add(saveRow);
                saveRow = new ArrayList<>();
                pre = after;
            }
        }

        return res;
    }

    //按Z打印，设置标志位,方法1
    public static ArrayList<ArrayList<Integer>> PrintTreeZ1(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        ArrayList<Integer> saveRow = new ArrayList<>();

        TreeNode pre = root;
        TreeNode after = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean change = false;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            saveRow.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
                after = node.left;
            }
            if(node.right != null){
                queue.offer(node.right);
                after = node.right;
            }

            if(pre == node){
                if(!change){
                    res.add(saveRow);
                    saveRow = new ArrayList<>();
                    pre = after;
                    change = !change;
                } else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    for(int i = saveRow.size() - 1; i >= 0; i--){
                        temp.add(saveRow.get(i));
                    }
                    saveRow = new ArrayList<>();
                    res.add(temp);
                    pre = after;
                    change = !change;
                }
            }
        }
        return res;
    }

    //按Z打印，使用两个队列，方法2
    public static ArrayList<ArrayList<Integer>> PrintTreeZ2(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        ArrayList<Integer> saveRow = new ArrayList<>();

        TreeNode pre = root;
        TreeNode after = root;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> quque2 = new LinkedList<>();
        queue1.offer(root);
        boolean change = false;
        while(!queue1.isEmpty()){
            TreeNode node = queue1.poll();
            saveRow.add(node.val);
            if(node.left != null){
                queue1.offer(node.left);
                after = node.left;
            }
            if(node.right != null){
                queue1.offer(node.right);
                after = node.right;
            }

            if(pre == node){
                if(!change){
                    res.add(saveRow);
                    saveRow = new ArrayList<>();
                    pre = after;
                    change = !change;
                } else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    for(int i = saveRow.size() - 1; i >= 0; i--){
                        temp.add(saveRow.get(i));
                    }
                    saveRow = new ArrayList<>();
                    res.add(temp);
                    pre = after;
                    change = !change;
                }
            }
        }
        return res;
    }


    /***********************************************************************************/

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node5.right = node7;

        ArrayList<ArrayList<Integer>> res = PrintTreeZ1(node1);
        for(int i = 0; i < res.size(); i++){
            for(int j = 0; j < res.get(i).size(); j++){
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main1(String[] args){
        int[] a1 = {5,2,3,4,1,6,7,0,8};

        Solution2 s = new Solution2();
        s.Insert(5);
        System.out.println(s.GetMedian());
        s.Insert(2);
        System.out.println(s.GetMedian());
        s.Insert(3);
        System.out.println(s.GetMedian());
        s.Insert(4);
        System.out.println(s.GetMedian());
        s.Insert(1);
        System.out.println(s.GetMedian());
        s.Insert(6);
        System.out.println(s.GetMedian());
        s.Insert(7);
        System.out.println(s.GetMedian());
        s.Insert(0);
        System.out.println(s.GetMedian());
        s.Insert(8);
        System.out.println(s.GetMedian());
    }

    public static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
}
