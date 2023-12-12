import java.util.*;
import java.io.*;

public class boj4179 {
	static int R, C;
	static char[][] map;
	static boolean[][] isVisited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
    static Deque<Pos> que;
	static Pos jihoon; // 지훈이 위치, 타입, 횟수
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
		
        que = new ArrayDeque<>();
		map = new char[R][C];
		isVisited = new boolean[R][C];
	
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'J') {
					// 첫 위치부터 탈출이 가능하면
					if(i == 0 || j == 0 || i == R-1 || j == C-1) {
						System.out.println(1);
						return;
					}
					
					map[i][j] = '.'; // 지훈이의 첫 위치를 '.'으로 바꿈
					jihoon = new Pos(i, j, 0, 0);
				} else if(map[i][j] == 'F') {
					que.add(new Pos(i, j, 1, 0));
				}
			}
		}
		
		bfs();
		
	}
	
	static void bfs() {
		
		que.add(jihoon);
		isVisited[jihoon.x][jihoon.y] = true;
		
		while(!que.isEmpty()) {
			Pos p = que.poll();
			
			int curX = p.x;
			int curY = p.y;
			int cnt = p.cnt;
			
			// 가장자리 && 지훈(type == 0)
			if((curX == 0 || curY == 0 || curX == R-1 || curY == C-1) && p.type == 0) {
				System.out.println(cnt + 1);
				return;
			}
			
			for(int t=0; t<4; t++) {
				int nx = curX + dx[t];
				int ny = curY + dy[t];
				
				// 큐에 안 넣어도 되는 조건
				if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == '#' || map[nx][ny] == 'F') continue;
				
				if(p.type == 0 && !isVisited[nx][ny]) { // 지훈이
					que.add(new Pos(nx, ny, 0, cnt + 1));
					isVisited[nx][ny] = true;
				} else { // 불
					que.add(new Pos(nx, ny, 1, cnt + 1));
					map[nx][ny] = 'F';
				}
			}

		}	
		
		System.out.println("IMPOSSIBLE");
	}

	static class Pos{
		int x, y;
		int type; //0: 지훈, 1: 불
		int cnt;
		
		Pos(int x, int y, int type, int cnt){
			this.x = x;
			this.y = y;
			this.type = type;
			this.cnt = cnt;
		}
	}	
}