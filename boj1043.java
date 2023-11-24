import java.io.*;
import java.util.*;

public class boj1043 {
    static int N, M, num, result;
    static int parent[]; // �� ����� ��Ʈ ��� ��ȣ ����
    static int partyList[][]; // �� ��Ƽ�� ��Ʈ ��� ��ȣ ����
    static HashMap<Integer, Integer> trueman; // ������ �ƴ� ��� ��ȣ ����

    public static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx == ry) {
            return;
        }

        if (rx < ry) {
            parent[y] = rx;
            if (y != ry) { // �ٸ� ��Ʈ ��带 ���� �ִ� ���
                union(ry, rx);
            }
        }
        else {
            parent[x] = ry;
            if (x != rx) {
                union(ry, rx);
            }
        }
    }

    public static int find(int num) {
        if (num != parent[num]) {
            parent[num] = find(parent[num]);
        }
        return parent[num];
    }

    public static void searchParty() {
        int i, j;
        Boolean check;

        for (i = 1; i <= N; i++) {
            if (trueman.containsKey(i)) {
                trueman.put(find(i), 0);
            }
        }

        for (i = 1; i <= M; i++) {
            check = true;
            for (j = 0; j < partyList[i].length; j++) {
                if (trueman.containsKey(find(partyList[i][j]))) {
                    check = false;
                    break;
                }
            }

            if (check) {
                result++;
            }
        }
    }

    public static void pre() throws IOException {
        int i, j, pSize, root;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;

        trueman = new HashMap<>();
        parent = new int[N + 1];
        partyList = new int[M + 1][];
        for (i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        for (i = 0; i < num; i++) {
            trueman.put(Integer.parseInt(st.nextToken()), 0);
        }

        for (i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            pSize = Integer.parseInt(st.nextToken());
            root = Integer.parseInt(st.nextToken());
            partyList[i] = new int[pSize];
            partyList[i][0] = root;
            for (j = 1; j < pSize; j++) {
                partyList[i][j] = Integer.parseInt(st.nextToken());
                union(root, partyList[i][j]);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();

        if (num == 0) { // ������ �ƴ� ����� ���� 0�� ���
            result = M;
        }
        else {
            searchParty();
        }
        System.out.println(result);
    }
}