import java.io.*;
import java.util.*;

public class boj9489 {
    static StringBuilder sb;
    static int n, k, cousins, kIndex;
    static Node tree[];

    public static void findCousin() {
        int grandpaNum, i;

        if (tree[kIndex].pIdx == -1) { // �θ� ��尡 ���� ���(��Ʈ ��Ʈ�� ���)
            return;
        } else if (tree[tree[kIndex].pIdx].pIdx == -1) { // �θ� ��尡 ��Ʈ ����� ���
            return;
        }

        grandpaNum = tree[tree[tree[kIndex].pIdx].pIdx].nodeNum; // ã�� k�� ���θ� ��� �� ����

        i = tree[tree[kIndex].pIdx].pIdx;
        i++;

        while (tree[i].pNum != grandpaNum) { // ���θ��� �ڽĵ��� ���� ������
            i++;
        }
        while (tree[tree[i].pIdx].nodeNum == grandpaNum) {
            if (tree[i].nodeNum != tree[kIndex].pNum) { // k�� �θ� �ƴ� ���
                cousins += tree[i].cCnt;
            }
            i++;
        }
    }

    public static void pre() throws IOException {
        int i, parentIdx, prev;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cousins = 0;
        parentIdx = 0;

        while (n != 0 && k != 0) {
            st = new StringTokenizer(br.readLine());
            tree = new Node[n];
            tree[0] = new Node(Integer.parseInt(st.nextToken()), 0, -1, -1);
            if (tree[0].nodeNum == k) {
                kIndex = 0;
            }
            prev = tree[0].nodeNum;
            parentIdx = -1;
            for (i = 1; i < n; i++) {
                tree[i] = new Node();
                tree[i].nodeNum = Integer.parseInt(st.nextToken());
                if (tree[i].nodeNum == k) { // ã�� ��(k)�� �ε��� ����
                    kIndex = i;
                }
                if (tree[i].nodeNum - 1 != prev) { // ������ �ƴ� ��� �ٸ� ����
                    parentIdx++;
                }
                tree[parentIdx].cCnt++; // �θ��� �ڽ� ��+1
                tree[i].pNum = tree[parentIdx].nodeNum; // �θ��� ��� ��ȣ ����
                tree[i].pIdx = parentIdx; // �θ� ��� �ε��� ����
                prev = tree[i].nodeNum; // ���� �� ����
            }

            findCousin();

            sb.append(cousins).append('\n');
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            cousins = 0;
            parentIdx = 0;
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }

    static class Node {
        int nodeNum, cCnt, pNum, pIdx; // nodeNum : ��� ��ȣ, cCnt : �ڽ� ��, pNum : �θ� ��ȣ, pIdx : �θ� �ε���

        public Node() {
        }

        public Node(int nodeNum, int cCnt, int pNum, int pIdx) {
            this.nodeNum = nodeNum;
            this.cCnt = cCnt;
            this.pNum = pNum;
            this.pIdx = pIdx;
        }
    }
}
