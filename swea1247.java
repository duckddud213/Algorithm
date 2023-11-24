import java.io.*;
import java.util.*;

public class swea1247 {
    static int x, T, N, shortcut;
    static dot person[];
    static boolean isVisited[];
    static dot office, home;
    static int routeIdx[];
    static StringBuilder sb;

    public static void backTracking(int depth) {
        int distSum = 0;
        int i, currI, currJ, nextI, nextJ;
        if (depth == N) { // 모든 회사원 다 방문 후 집 돌아갈 차례일때

            distSum += calDist(office.i, office.j, person[routeIdx[0]].i, person[routeIdx[0]].j);
            distSum += calDist(home.i, home.j, person[routeIdx[N - 1]].i, person[routeIdx[N - 1]].j);

            for (i = 0; i < N - 1; i++) {
                currI = person[routeIdx[i]].i;
                currJ = person[routeIdx[i]].j;
                nextI = person[routeIdx[i + 1]].i;
                nextJ = person[routeIdx[i + 1]].j;

                distSum += calDist(currI, currJ, nextI, nextJ);
            }

            shortcut = Math.min(shortcut, distSum);

            return;
        }

        for (i = 0; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                routeIdx[depth] = i;
                backTracking(depth + 1);
                isVisited[i] = false;
            }
        }
    }

    public static int calDist(int srcI, int srcJ, int destI, int destJ) {
        return (int) (Math.abs(srcI - destI) + Math.abs(srcJ - destJ));
    }

    public static void pre() throws IOException {
        int i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (x = 1; x <= T; x++) {
            shortcut = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            person = new dot[N];
            routeIdx = new int[N];
            isVisited = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            office = new dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            home = new dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (i = 0; i < N; i++) {
                person[i] = new dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            backTracking(0);

            sb.append("#").append(x).append(" ").append(shortcut).append('\n');
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }

    static class dot {
        int i, j;

        public dot() {
        }

        public dot(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
