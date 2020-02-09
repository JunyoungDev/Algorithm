import java.util.*;
//https://www.algospot.com/judge/problem/read/PICNIC

public class Main {
    static int C;
    static int[] n,m;
    static int[][][] friends;
         public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         C = sc.nextInt();
        n = new int[C];
        m = new int[C];
        friends = new int[C][][];
         for(int i=0; i<C; i++){
             n[i] =sc.nextInt();
             m[i] =sc.nextInt();
             friends[i] = new int[n[i]][n[i]];
             for(int j=0; j<m[i] ; j++){
                 int a,b;
                 a = sc.nextInt();
                 b = sc.nextInt();
                 friends[i][a][b] = 1;
                 friends[i][b][a] = 1;
             }
         }

         for(int i=0; i<C; i++){
             boolean[] lengthA = new boolean[n[i]];
             System.out.println(countBaby(lengthA,i));
         }
    }

    static int countBaby(boolean couple[], int index){
        int first = -1;

        for(int i=0; i<n[index]; i++) {
            if(!couple[i]){
                first = i;
                break;
            }
        }
        if(first == -1) return 1;

        int r = 0;

        for(int i=first+1 ; i < n[index] ; i++){
            if(!couple[i] && friends[index][first][i] == 1){
                couple[first] = couple[i] = true;
                r += countBaby(couple, index);
                couple[first] = couple[i] = false;
            }
        }
        return r;
    }
}
