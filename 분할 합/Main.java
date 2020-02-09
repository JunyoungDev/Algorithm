import java.util.*;


public class Main {
    static int C;
         public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
          C = sc.nextInt();

        System.out.println(fastSum(C));
        sc.close();

    }

    static int fastSum(int n){
        if(n==1) return 1;
        if(n%2==1) return fastSum(n-1) + n;
        return fastSum(n/2)*2 + (n/2)*(n/2); 
    }
}