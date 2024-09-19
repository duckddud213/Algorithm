import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> keys = new HashSet<>();
        int sum = 0;
        for(int i = 0; i < 10; i++){
            int num = Integer.parseInt(br.readLine());
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
            keys.add(num);
        }
        sum /= 10;
        
        int cnt = 0;
        int result = 0;
        for(int key : keys){
            if(cnt < map.get(key)){
                cnt = map.get(key);
                result = key;
            }
        }
        System.out.println(sum);
        System.out.println(result);
    }
}