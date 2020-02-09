import java.util.*;
//https://www.algospot.com/judge/problem/read/PICNIC

public class Main {
        static int N;
         public static void main(String[] args) {
        //  Scanner sc = new Scanner(System.in);
        //  C = sc.nextInt();
        }

}

class Solution {
    int[] memo;
  public int solution(int n) {
        memo = new int[n+1];
        for(int i=0; i<=n; i++){
            memo[i] = -1;
        }
      
      return gogo(n);
  }
    
    int gogo(int n) {
        
            if(n == 0) return 1;
            if(n == 1) return 1;

            if(memo[n] != -1) return memo[n];
            return memo[n] = (gogo(n-1) + gogo(n-2))%1000000007;
    }
}