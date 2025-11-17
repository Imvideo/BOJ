import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int N, B, C;
    static Long sum = 0L;
    static int[] room = new int[1000001];
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            room[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            Long num, cnt = 0L;
            num = Long.valueOf(room[i]);
            num -= B; cnt++;
            if(num > 0){
                cnt += num / C;
                if(num % C != 0) cnt++;
            }
            sum += cnt;  
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}