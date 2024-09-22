import java.io.*;
import java.util.*;

public class Main{
    static int n,m;
    static int[] num;
    static int[] arr = new int[10];
    static boolean[] isused = new boolean[10];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static void func(int k) throws IOException{
        if(k == m){ //배열에 m개의 수가 쌓이면 출력
            for(int i=0; i<m; i++){
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(!isused[i]){ //사용하지 않은 수일 때 동작
                isused[i] = true;
                arr[k] = num[i]; //arr[i] 가 아닌 arr[k]로 해야 새로운 수가 0번 인덱스에 들어감
                func(k+1);
                isused[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        func(0);
        bw.flush();
        bw.close();
    }
}