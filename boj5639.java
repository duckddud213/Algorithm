import java.io.*;
import java.util.*;

public class boj5639 {
    static Node tree[];
    static int rootNum, treeSize, idx;
    static StringBuilder sb;

    public static void postOrder(int index) {
        if (tree[index].lidx != -1) {
            postOrder(tree[index].lidx);
        }
        if (tree[index].ridx != -1) {
            postOrder(tree[index].ridx);
        }
        sb.append(tree[index].num).append('\n');
    }

    public static void makeTree(int num) {
        int nodeIdx;

        nodeIdx = 0;
        while (true) {
            if (tree[nodeIdx].num < tree[idx].num) {
                if (tree[nodeIdx].ridx == -1) {
                    tree[nodeIdx].ridx = idx;
                    break;
                } else {
                    nodeIdx = tree[nodeIdx].ridx;
                }
            } else {
                if (tree[nodeIdx].lidx == -1) {
                    tree[nodeIdx].lidx = idx;
                    break;
                } else {
                    nodeIdx = tree[nodeIdx].lidx;
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tree = new Node[10001];
        sb = new StringBuilder();

        rootNum = Integer.parseInt(br.readLine());
        tree[0] = new Node(rootNum, -1, -1);
        idx = 1;

        while (true) {
            //vscode 환경에서는 EOF 입력 확인 위해 마지막 값 넣고 엔터 -> ctrl z입력 -> 엔터 해야함 이번에 처음 알았음
            String input = br.readLine();
            if (input == null) {
                break;
            }
            tree[idx] = new Node(Integer.parseInt(input), -1, -1);
            makeTree(tree[idx].num);
            idx++;
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        postOrder(0);
        System.out.print(sb);
    }

    static class Node {
        int num, lidx, ridx;

        public Node() {
        }

        public Node(int num, int lidx, int ridx) {
            this.num = num;
            this.lidx = lidx;
            this.ridx = ridx;
        }
    }
}