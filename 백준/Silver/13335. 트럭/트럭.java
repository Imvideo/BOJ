import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, w, l, idx = 1, sum = 0, cnt = 0;
    static int[] truck = new int[1002];
    static int[] bridge = new int[102];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }
        while (true) {
            if (bridge[w] != 0){
                sum -= truck[bridge[w]];
                if(bridge[w] == n) {
                    cnt++;
                    break;
                }
            }
            for (int i = w; i > 1; i--) {
                bridge[i] = bridge[i - 1];
            }
            if (sum + truck[idx] <= l && idx <= n) {
                bridge[1] = idx;
                sum += truck[idx++];
            }
            else{
                bridge[1] = 0;
            }
            cnt++;
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
}