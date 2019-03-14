package algorithmicPractice.bean;

import java.util.ArrayList;

public class BFSAndDFS {


    static class Map {


        private ArrayList<Node> adj[];

        private int v;

        public Map(int v) {
            this.v = v;
            this.adj = new ArrayList[v];
            for (int i = 0; i < v; ++i) {
                this.adj[i] = new ArrayList<>();
            }
        }

        public void addNode(Node node) {
            this.adj[node.getStart()].add(node);
        }
    }

    static class Node {
        private int value;//当前节点值
        private int start;//起点
        private int end;//终点

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }
}

