package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList; // 存储顶点的集合
    private int[][] edges; // 存储对应的邻接矩阵
    private int numOfEdges; // 表示边的数目
    private boolean[] isVisited; // 记录某个节点是否被访问
    private int n;

    public Graph(int n) {
        this.n=n;
        this.vertexList = new ArrayList<>(n);
        this.edges = new int[n][n];
        this.numOfEdges = 0;
    }

    // 插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     表示点的下标
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        /*
            双向图
             A  B  C  D  E
         A  [0, 1, 1, 0, 0]
         B  [1, 0, 1, 1, 1]
         C  [1, 1, 0, 0, 0]
         D  [0, 1, 0, 0, 0]
         E  [0, 1, 0, 0, 0]
        */
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    // 图中常用方法
    // 返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    // 得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    // 返回节点i(下标对应的数据)
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    // 返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    /**
     * 得到第一个邻接节点的下标w
     * @param index
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

        /*
             双向图
             A  B  C  D  E
         A  [0, 1, 1, 0, 0]
         B  [1, 0, 1, 1, 1]
         C  [1, 1, 0, 0, 0]
         D  [0, 1, 0, 0, 0]
         E  [0, 1, 0, 0, 0]
        */

    /**
     * 根据前一个邻接节点的下标得到下一个邻接节点
     * @param v1 节点的下标
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2+1; i < vertexList.size(); i++) {
            if (edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历算法
     * @param isVisited
     * @param i         第一次是0
     */
    public void dfs(boolean[] isVisited,int i){
        // 首先访问该节点
        System.out.print(getValueByIndex(i)+"->");
        // 将节点设置为已经访问
        isVisited[i]=true;
        // 查找节点i的第一个邻接节点w
        int w = getFirstNeighbor(i);
        while (w!=-1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            // 如果w节点已经被访问过
            w = getNextNeighbor(i,w);
        }
    }

    // 对dfs()重载，遍历所有的节点
    public void dfs(){
        isVisited = new boolean[n];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
        System.out.println();
    }

    /**
     * 对一个节点进行广度优先遍历的方法
     * @param isVisited
     * @param i
     */
    public void bfs(boolean[] isVisited,int i){
        int u; // 表示队列的头节点对应的下标
        int w; // 邻接节点w
        // 队列，记录节点访问的顺序
        LinkedList<Integer> queue = new LinkedList<>();
        // 访问节点，输出节点信息
        System.out.print(getValueByIndex(i)+"=>");
        // 标记为以访问
        isVisited[i]=true;
        // 将节点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()){
            // 去出队列的头节点下标
            u = queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w!=-1){
                // 是否访问过
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"=>");
                    // 标记已经访问
                    isVisited[w]=true;
                    // 入队
                    queue.addLast(w);
                }
                // 以u为前驱，找到w后面的下一个邻接点
                w = getNextNeighbor(u,w);
            }
        }
    }
    // 遍历所有节点，进行广度优先遍历
    public void bfs(){
        isVisited = new boolean[n];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 测试
        int n = 8; // 点点个数
        // String[] vertexes = {"A", "B", "C", "D", "E"};
         String[] vertexes = {"1", "2", "3", "4", "5", "6", "7", "8"};
        // 创建图对象
        Graph graph = new Graph(n);
        // 循环添加顶点
        for (String vertex : vertexes) {
            graph.insertVertex(vertex);
        }
        // 添加边
//        graph.insertEdge(0, 1, 1);
//        graph.insertEdge(0, 2, 1);
//        graph.insertEdge(1, 2, 1);
//        graph.insertEdge(1, 3, 1);
//        graph.insertEdge(1, 4, 1);
//        graph.showGraph();

        // 添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        graph.showGraph();

        // 深度优先遍历算法
        System.out.println("深度优先遍历算法");
        graph.dfs();
        // 广度优先遍历算法
        System.out.println("广度优先遍历算法");
        graph.bfs();
    }
}
