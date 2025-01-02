import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static Integer[] cranes;//크레인들
	static List<Integer> list;//박스들
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		cranes = new Integer[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			cranes[i] = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++)
			list.add(Integer.parseInt(st.nextToken()));
		
		//내림차순 정렬
		Arrays.sort(cranes, Collections.reverseOrder());
		Collections.sort(list, Collections.reverseOrder());
		
		//박스 다못옮김 -> -1 출력.
		if(cranes[0]<list.get(0)) {
			System.out.println(-1);
			System.exit(0);
		}
		
		int cnt=0;
		while(true) {
			int boxIdx = 0;
			//0~n번 크레인까지 탐색.
			for(int i=0; i<n;) {
				//탐색할수 있는 박스가 없으면 for문 종료.
				if(boxIdx==list.size()) break;
				
				int box = list.get(boxIdx);
				int crane = cranes[i];  
				if(crane>=box) {//박스 옮기기 가능
					list.remove(boxIdx);//옮긴 박스 제거
					i++;//다음 크레인
				}else {//불가능.
					boxIdx++;//한단계 낮은 무게의 박스로.
				}
			}
			cnt++;//for문 한번 종료 = 모든 크레인 한번 작업
			if(list.size()==0) break;//남은 박스 없으면 종료.
		}
		System.out.println(cnt);
	}
}