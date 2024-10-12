import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void bfs(int[][] arr, int x, int y, int d1, int d2){
        boolean[][] visit = new boolean[n][n];
        for(int i = 0; i <= d1; i++){
            visit[x + i][y - i] = true;
            visit[x + d2 + i][y + d2 - i] = true;
        }
        for(int i = 0; i <= d2; i++){
            visit[x + i][y + i] = true;
            visit[x + d1 + i][y - d1 + i] = true;
        }
        int[] count = new int[5];

        //1구역
        for(int i = 0; i < x + d1; i++){
            for(int j = 0; j <= y; j++){
                if(visit[i][j])
                    break;
                count[0] += arr[i][j];
            }
        }
        //2구역
        for(int i = 0; i <= x + d2; i++){
            for(int j = n - 1; j > y; j--){
                if(visit[i][j])
                    break;
                count[1] += arr[i][j];
            }
        }
        //3구역
        for(int i = x + d1; i < n; i++){
            for(int j = 0; j < y - d1 + d2; j++){
                if(visit[i][j])
                    break;
                count[2] += arr[i][j];
            }
        }
        //4구역
        for(int i = x + d2 + 1; i < n; i++){
            for(int j = n - 1; j >= y - d1 + d2; j--){
                if(visit[i][j])
                    break;
                count[3] += arr[i][j];
            }
        }
        //5구역
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                count[4] += arr[i][j];
        for(int i = 0; i < 4; i++)
            count[4] -= count[i];
        Arrays.sort(count);
        min = Math.min(min, count[4] - count[0]);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = scan.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int d1 = 1; d1 < n; d1++){
                    for(int d2 = 1; d2 < n; d2++){
                        if(i + d1 + d2 < n){
                            if(0 <= j - d1 && j + d2 < n){
                                bfs(arr, i, j, d1, d2);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }
}