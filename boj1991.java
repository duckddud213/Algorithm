import java.io.*;
import java.util.*;

public class boj1991 {
    static int N;
    static Node[] tree;
    static StringBuilder sb;

    public static void preOrder(int index) { // 전위 순회

        sb.append(tree[index].num);

        if (tree[index].l != '.') {
            preOrder(tree[index].l - 'A' + 1);
        }
        if (tree[index].r != '.') {
            preOrder(tree[index].r - 'A' + 1);
        }
    }

    public static void inOrder(int index) { // 중위 순회
        if (tree[index].l != '.') {
            inOrder(tree[index].l - 'A' + 1);
        }

        sb.append(tree[index].num);

        if (tree[index].r != '.') {
            inOrder(tree[index].r - 'A' + 1);
        }
    }

    public static void postOrder(int index) { // 후위 순회
        if (tree[index].l != '.') {
            postOrder(tree[index].l - 'A' + 1);
        }

        if (tree[index].r != '.') {
            postOrder(tree[index].r - 'A' + 1);
        }

        sb.append(tree[index].num);
    }

    public static void pre() throws IOException {
        int i;
        char num, l, r;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        tree = new Node[27]; // 1 : A || 26 : Z

        for (i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = st.nextToken().charAt(0);
            l = st.nextToken().charAt(0);
            r = st.nextToken().charAt(0);

            tree[num - 'A' + 1] = new Node(num, l, r);
        }
    }

    static class Node {
        char num, l, r;

        public Node() {
        }

        public Node(char num, char l, char r) {
            this.num = num;
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        preOrder(1);
        sb.append('\n');
        inOrder(1);
        sb.append('\n');
        postOrder(1);
        System.out.println(sb);
    }
}
