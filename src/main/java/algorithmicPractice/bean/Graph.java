package algorithmicPractice.bean;

import java.util.LinkedList;

public class Graph<T> {

    /**
     * 邻接表
     */
    private LinkedList<T> adj[];
    /**
     * 顶点个数
     */
    private int v;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) {
        this.adj[s].add(null);
    }

    public void addEdge(int s, int t) {
        this.adj[s].add(null);
    }
}
