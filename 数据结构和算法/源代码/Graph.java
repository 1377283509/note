package graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList; // 存储顶点集合
    private int[][] edges; // 存储图对应的邻接矩阵
    private int numOfEdges; // 边的数目
    private boolean[] isVisited;

    // 构造方法，n为图顶点的个数
    public Graph(int n){
        edges = new int[n][n]; // n行n列的邻接矩阵
        vertexList = new ArrayList<String>(n); // n个顶点的集合
        numOfEdges = 0; // 边数初始为0
    }

    public static void main(String[] args){
        Graph graph = new Graph(8);
        // 循环添加顶点
        String[] vertexs = {"1","2","3","4","5","6","7","8"};
        for(String value:vertexs){
            graph.insertVertex(value);
        }

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
        graph.dfs();
        System.out.println();
        graph.bfs();
    }
    // 插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    // 添加边,v1，v2为顶点的下标，weight为权值，为1表示v1，v2直接连接
    public void insertEdge(int v1,int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
    // 返回节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    // 返回边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    // 返回节点i对应的数值
    public String getValueByIndex(int index){
        return vertexList.get(index);
    }
    // 返回v1,v2的权值
    public int getWeightByIndex(int v1,int v2){
        return edges[v1][v2];
    }
    // 输出邻接矩阵
    public void showGraph(){
        for(int[] link : edges){
            System.err.println(Arrays.toString(link));
        }
    }
    // 获取结点v的第一个邻接节点
    public int getFirstNeighbor(int v){
        for(int i=v+1;i<vertexList.size();i++){
            // 从v+1开始遍历，如果有邻接关系，返回i
            if(edges[v][i]>0){
                return i;
            }
        }
        // 没有返回-1
        return -1;
    }
    // 获取v的邻接节点w的下一个邻接节点
    public int getNextNeighbor(int v,int w){
        for(int i=w+1;i<vertexList.size();i++){
            if(edges[v][i]>0){
                return i;
            }
        }
        return -1;
    }
    // 一层深度优先遍历
    private void dfs(int v){
    // 1.访问初始结点v，并标记结点v为已访问。
        System.out.print(vertexList.get(v)+"=>");
        isVisited[v] = true;
    // 2.查找结点v的第一个邻接结点w。
        int w = getFirstNeighbor(v);
    // 3.若w存在，则继续执行4，如果w不存在，则回到第1步，将从v的下一个结点继续。
        while (w!=-1){
    // 4.若w未被访问，对w进行深度优先遍历递归（即把w当做另一个v，然后进行步骤123）。
            if(!isVisited[w]){
                dfs(w);
            }
    // 5.查找结点v的w邻接结点的下一个邻接结点，转到步骤3。
            w = getNextNeighbor(v,w);
        }
    }
    // 深度优先遍历
    public void dfs(){
        isVisited = new boolean[vertexList.size()];
        for(int i=0;i<vertexList.size();i++){
            if(!isVisited[i]){
                dfs(i);
            }
        }
    }
    // 第一层遍历
    private void bfs(int v){
        int u;
        int w;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // 1.访问初始结点v并标记结点v为已访问。
        System.out.print(vertexList.get(v) + "=>");
        isVisited[v] = true;
        // 2.结点v入队列
        queue.addLast(v);
        // 3.当队列非空时，继续执行，否则算法结束。
        while (!queue.isEmpty()){
            // 4.出队列，取得队头结点u。
            u = queue.removeFirst();
            // 5.查找结点u的第一个邻接结点w。
            w = getFirstNeighbor(u);
            // 6.若结点u的邻接结点w不存在，则转到步骤3；
            // 结点u的邻接节点存在，循环执行以下三个步骤：
            while(w!=-1){
                if(!isVisited[w]){
                    // 1.若结点w尚未被访问，则访问结点w并标记为已访问。
                    System.out.print(vertexList.get(w)+"=>");
                    isVisited[w] = true;
                    // 2.结点w入队列
                    queue.addLast(w);
                }
                // 3.查找结点u的继w邻接结点后的下一个邻接结点w，转到步骤6。
                w = getNextNeighbor(u,w);
            }
        }
    }
   // 循环遍历
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                bfs(i);
            }
        }
    }
}
