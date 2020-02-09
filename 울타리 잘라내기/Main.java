import java.util.*;
//https://www.algospot.com/judge/problem/read/FENCE

public class Main {
    static int C;
    static int[][] fences;
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        C = sc.nextInt(); //케이스수 입력
        fences = new int[C][];
         for(int i=0; i<C; i++){
             int n = sc.nextInt(); //케이스별 울타리 수
             fences[i] = new int[n];
             for(int j=0; j<n; j++){
                 fences[i][j] = sc.nextInt(); 
             }
         }

         for(int i=0; i<C ; i++){ //케이스 수만큼 함수호출하여 출력
             System.out.println(solution(i,0,fences[i].length-1));
         }
    }

    static int solution(int index, int left, int right){ //울타리 출력함수
        if(left == right) return fences[index][left]; //기저사례
        int mid = (left + right) / 2;

        int r = Math.max(solution(index,left,mid), solution(index,mid+1,right)); // 분할정복

        int low = mid;
        int high = mid+1;

        int height = Math.min(fences[index][low],fences[index][high]);

        r = Math.max(r, height*2); //중간값 두개만 포함하는 2사각형 고려

        while(left < low || high < right){
            if((left == low || fences[index][low] < fences[index][height]) && high < right){ //높이가 높은쪽으로 확상
                high++;
                height = Math.min(height,fences[index][high]);
            }
            else {
                low--;
                height = Math.min(height, fences[index][low]);
            }
            r = Math.max(r, height*(high-low+1)); //작업 후 넓이
        }
        return r;
    }
}
