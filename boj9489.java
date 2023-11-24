import java.io.*;
import java.util.*;

public class boj9489 {
    static StringBuilder sb;
    static int n, k, cousins, kIndex;
    static Node tree[];

    public static void findCousin() {
        int grandpaNum, i;

        if (tree[kIndex].pIdx == -1) { // 부모 노드가 없는 경우(루트 노트인 경우)
            return;
        } else if (tree[tree[kIndex].pIdx].pIdx == -1) { // 부모 노드가 루트 노드인 경우
            return;
        }

        grandpaNum = tree[tree[tree[kIndex].pIdx].pIdx].nodeNum; // 찾을 k의 조부모 노드 값 저장

        i = tree[tree[kIndex].pIdx].pIdx;
        i++;

        while (tree[i].pNum != grandpaNum) { // 조부모의 자식들이 나올 때까지
            i++;
        }
        while (tree[tree[i].pIdx].nodeNum == grandpaNum) {
            if (tree[i].nodeNum != tree[kIndex].pNum) { // k의 부모가 아닌 경우
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
                if (tree[i].nodeNum == k) { // 찾을 값(k)의 인덱스 저장
                    kIndex = i;
                }
                if (tree[i].nodeNum - 1 != prev) { // 연속이 아닌 경우 다른 집합
                    parentIdx++;
                }
                tree[parentIdx].cCnt++; // 부모의 자식 수+1
                tree[i].pNum = tree[parentIdx].nodeNum; // 부모의 노드 번호 저장
                tree[i].pIdx = parentIdx; // 부모 노드 인덱스 저장
                prev = tree[i].nodeNum; // 이전 값 저장
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
        int nodeNum, cCnt, pNum, pIdx; // nodeNum : 노드 번호, cCnt : 자식 수, pNum : 부모 번호, pIdx : 부모 인덱스

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
