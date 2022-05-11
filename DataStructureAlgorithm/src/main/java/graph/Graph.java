package graph;

import java.util.ArrayList;

public class Graph {
    private ArrayList<String> vertexList; // 存储顶点的集合
    private int[][] edges; // 存储对应的邻接矩阵
    private int numOfEdges; // 表示边的数目

    public Graph(int n) {
        this.vertexList = new ArrayList<>(n);
        this.edges = new int[n][n];
        this.numOfEdges = 0;
    }
    // 插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     * 添加边
     * @param v1        表示点的下标
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public static void main(String[] args) {

    }
}
