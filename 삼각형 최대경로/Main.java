import java.util.*;
//https://www.algospot.com/judge/problem/read/TRIANGLEPATH

public class Main {
    static int C;
    static int[][][] arr;
    static int[][][] memo;
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        C = sc.nextInt(); 
        arr = new int[C][][];
        memo = new int[C][][];

        for(int i=0; i<C ; i++){
            int size = sc.nextInt();
            arr[i] = new int[size][size];
            memo[i] = new int[size][size];
            for(int j=0; j<size; j++){
                for(int j2=0; j2 <=j ; j2++){
                    arr[i][j][j2] = sc.nextInt();
                    memo[i][j][j2] = -1;
                }
            }
        }
        for(int i=0;i<C;i++){
            System.out.println(max_sum(0,0,i));
        }

    }
    static int max_sum(int y, int x, int index){
        if(arr[index].length -1 == y) return arr[index][y][x];

        if(memo[index][y][x] != -1) return memo[index][y][x];

        int nowValue = arr[index][y][x];
        return  memo[index][y][x] = Math.max(nowValue+max_sum(y+1,x,index),nowValue+max_sum(y+1,x+1,index));

    }
}
