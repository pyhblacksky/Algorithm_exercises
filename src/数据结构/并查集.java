package 数据结构;

/**
 * @Author: pyh
 * @Date: 2019/3/5 11:19
 * @Version 1.0
 * @Function:   并查集数据结构
 */
public class 并查集 {
    /**
     * 定义并查集的抽象方法
     * */
    public abstract class UF {

        protected int[] id;

        public UF(int N){
            id = new int[N];
            for(int i = 0; i < N; i++){
                id[i] = i;
            }
        }

        //判断连接方法
        public boolean connected(int p, int q){
            return find(p) == find(q);
        }
        //查找方法
        public abstract int find(int p);
        //合并方法
        public abstract void union(int p, int q);

    }

    /**
     * QuickFind
     * 可以快速进行 find 操作，也就是可以快速判断两个节点是否连通。
     * 相当于是一对多的树
     * 需要保证同一连通分量的所有节点的 id 值相等。
     *
     * 但是 union 操作代价却很高，需要将其中一个连通分量中的所有节点 id 值都修改为另一个节点的 id 值
     * */
    public class QuickFindUF extends UF{

        public QuickFindUF(int N){
            super(N);
        }

        @Override
        public int find(int p) {
            return id[p];
        }

        @Override
        public void union(int p, int q) {
            int qID = find(q);
            int pID = find(p);

            //说明已连接
            if(qID == pID){
                return;
            }

            for(int i = 0; i < id.length; i++){
                if(id[i] == pID){
                    id[i] = qID;
                }
            }
        }
    }

    /**
     * QuickUnion
     * Quick Union
     * 可以快速进行 union 操作，只需要修改一个节点的 id 值即可。
     *
     * 但是 find 操作开销很大，因为同一个连通分量的节点 id 值不同，
     * id 值只是用来指向另一个节点。因此需要一直向上查找操作，直到找到最上层的节点。
     * */
    public class QuickUnionUF extends UF{

        public QuickUnionUF(int N){
            super(N);
        }

        //找到其根节点
        @Override
        public int find(int p) {
            while(p != id[p]){
                p = id[p];
            }
            return p;
        }

        @Override
        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if(pRoot != qRoot){
                id[pRoot] = qRoot;
            }
        }
    }

    /**
     * 加权的Quick Union
     *
     * 为了解决 quick-union 的树通常会很高的问题，加权 quick-union 在 union 操作时会让较小的树连接较大的树上面。
     *
     * 理论研究证明，加权 quick-union 算法构造的树深度最多不超过 logN。
     * */
    public class WeightQuickUnionUF extends UF{

        //保存节点的数量信息
        private int[] sz;

        public WeightQuickUnionUF(int N){
            super(N);
            this.sz = new int[N];
            for(int i  = 0; i < N; i++){
                this.sz[i] = 1;
            }
        }

        @Override
        public int find(int p) {
            while(p != id[p]){
                p = id[p];
            }
            return p;
        }

        @Override
        public void union(int p, int q) {
            //寻找pq根节点
            int i = find(p);
            int j = find(q);

            //说明已经连接
            if(i == j){
                return;
            }

            //节点数目大的作为根
            if(sz[i] < sz[j]){
                id[i] = j;
                sz[j] += sz[i];
            } else{
                id[j] = i;
                sz[i] += sz[j];
            }
        }
    }
}
