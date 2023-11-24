import java.io.*;
import java.util.*;

public class boj3020 {
    static int N, H,min,cnt;
    static int floor[], ceiling[]; // 석순, 종유석 따로 저장할 배열

    public static void divide(int left, int right) {
        if (left < right) {
            divide(left, (left + right) / 2);
            divide((left + right) / 2 + 1, right);
            combine(left, right);
        }
    }

    public static void combine(int left, int right) {
        int i, j, mid, idx;
        int sorted1[] = new int[right - left + 1];
        int sorted2[] = new int[right - left + 1];

        // 석순 정렬
        mid = (left + right) / 2;
        i = left;
        j = mid + 1;
        idx = 0;

        while (i <= mid && j <= right) {
            if (floor[i] < floor[j]) {
                sorted1[idx] = floor[i];
                idx++;
                i++;
            } 
            else {
                sorted1[idx] = floor[j];
                idx++;
                j++;
            }
        }

        if (i <= mid) {
            for (; i <= mid; i++) {
                sorted1[idx] = floor[i];
                idx++;
            }

        } else {
            for (; j <= right; j++) {
                sorted1[idx] = floor[j];
                idx++;
            }
        }

        System.arraycopy(sorted1, 0, floor, left, right - left + 1);

        // 종유석 정렬
        mid = (left + right) / 2;
        i = left;
        j = mid + 1;
        idx = 0;

        while (i <= mid && j <= right) {
            if (ceiling[i] < ceiling[j]) {
                sorted2[idx] = ceiling[i];
                idx++;
                i++;
            } else {
                sorted2[idx] = ceiling[j];
                idx++;
                j++;
            }
        }

        if (i <= (left + right) / 2) {
            for (; i <= (left + right) / 2; i++) {
                sorted2[idx] = ceiling[i];
                idx++;
            }

        } else {
            for (; j <= right; j++) {
                sorted2[idx] = ceiling[j];
                idx++;
            }
        }

        System.arraycopy(sorted2, 0, ceiling, left, right - left + 1);
    }

    public static int binarySearch(int left, int right, int height) {
        int l, r, m, h, sum;
        
        sum = 0;

        l = left;
        r = right;
        h=height;

        while (l < r) {
            m = (l + r) / 2;
            if (floor[m] >= h) {
                r = m;
            }
            else {
                l = m + 1;
            }
        }
        sum += floor.length - r;

        l = left;
        r = right;
        h=H-height+1;

        while (l < r) {
            m = (l + r) / 2;
            if (ceiling[m] >= h) {
                r = m;
            }
            else {
                l = m + 1;
            }
        }
        sum += ceiling.length - r;

        return sum;
    }
    
    public static void conflict() {
        int broke;
        for (int i = 1; i <= H; i++) {
            broke = binarySearch(0, N / 2, i);
            if (min == broke) {
                cnt++;
            }
            else if (min > broke) {
                min = broke;
                cnt = 1;
            }
        }
    }

    public static void pre() throws IOException {
        int i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        min = N; //초기값 N번 충돌
        cnt = 0;

        floor = new int[N / 2];
        ceiling = new int[N / 2];

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (i % 2 == 0) {
                floor[i / 2] = Integer.parseInt(st.nextToken());
            } else {
                ceiling[i / 2] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        divide(0, (N / 2) - 1);
        conflict();
        System.out.println(min+" "+cnt);
    }
}