import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> list;
    public static void pre() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new ArrayList<>();
        
        for(int i=0;i<5;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        for(int i = list.get(2); ;i++){
            int cnt = 0;

            for(int num : list){
                if(i%num == 0){
                    cnt++;
                }
            }

            if(cnt>=3){
                System.out.println(i);
                return;
            }
        }
    }

    public static void main(String args[]) throws IOException{
        pre();
    }
}