import java.io.*;
import java.util.*;

class Solution
{
    static int answer, n;
    
//     public static void backtracking(int a[], int b[], Set indexA, Set indexB, int sum){
//         if(sum >= answer){
//             return;
//         }
        
//         if(indexA.size() == n && indexB.size() == n){
//             answer = Integer.min(answer, sum);
//         }
        
//         for(int i = 0; i < a.length; i++) {
//             if(indexA.contains(i)){
//                 continue;
//             }
            
//             for(int j = 0; j < b.length; j++) {
//                 if(indexB.contains(j)){
//                     continue;
//                 }
                
//                 indexA.add(i);
//                 indexB.add(j);
//                 backtracking(a, b,indexA, indexB, sum + (a[i] * b[j]));
//                 indexA.remove(i);
//                 indexB.remove(j);
//             }
//         }
//     }
    
    public int solution(int []A, int []B)
    {
//         answer = Integer.MAX_VALUE;
//         n = A.length;
        
//         backtracking(A, B, new HashSet<Integer>(), new HashSet<Integer>(), 0);
        
        int arr1[] = A;
        int arr2[] = B;
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        n = A.length;
        
        answer = 0;
        
        for(int i = 0; i < n; i++){
            answer += (arr1[i] * arr2[n - 1 - i]);
        }
        
        return answer;
    }
}