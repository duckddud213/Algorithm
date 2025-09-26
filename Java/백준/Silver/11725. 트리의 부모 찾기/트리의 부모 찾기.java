import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int rootNode[];
    static boolean isVisited[];
    static ArrayList<Integer>[] graph;
    static Deque<Integer> que;

    public static void bfs(){
        que.add(1);
        isVisited[1]=true;

        while(!que.isEmpty()){
            int q = que.poll();
            for(Integer i : graph[q]){
                if(!isVisited[i]){
                    isVisited[i]=true;
                    que.add(i);
                    rootNode[i]=q;
                }
            }
        }
    }

    public static void pre() throws IOException{
        int n1,n2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        que = new ArrayDeque<>();
        graph = new ArrayList[N+1];
        rootNode = new int[N+1];
        isVisited = new boolean[N+1];

        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2=Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
    }

    public static void main(String args[]) throws IOException{
        pre();
        bfs();
        for(int i=2;i<=N;i++){
            System.out.println(rootNode[i]);
        }
    }
}
