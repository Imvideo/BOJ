import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, n, K, idx = 0, cnt = 0, num = 0;
    static int[] belt = new int[202];
    static int[] robot = new int[202];
    public static void main(String args[]) throws IOException {
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        n = 2 * N;
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }
        // 단계 진행
        while(true){
            if(num >= K) break;
            cnt++;
            // 로봇과 벨트 회전
            idx = (idx-1+n)%n;
            robot[(idx-1+N)%n] = 0;
            // 로봇 이동
            for(int i=N-2; i>=0; i--){
                int cur = (idx + i) % n;
                int next = (idx + i + 1) % n;
                if(robot[cur] == 1 && robot[next] == 0 && belt[next] > 0){
                    robot[cur] = 0; robot[next] = 1; belt[next]--;
                    if(belt[next] == 0) num++;
                }
            }
            robot[(idx-1+N)%n] = 0;
            // 로봇 올리기
            if(belt[idx] != 0) {
                robot[idx] = 1;
                belt[idx]--;
                if(belt[idx] == 0) num++;
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}