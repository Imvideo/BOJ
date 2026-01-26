import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, mx = 0;
    static int[][] board = new int[502][502];

    static ArrayList<int[][]> tetro = new ArrayList<>();
    static boolean nextPermutation(int[] brute){
        int i = brute.length - 2;
        while(i >= 0 && brute[i] >= brute[i+1]) i--;
        if(i < 0) return false;

        int j = brute.length - 1;
        while(brute[i] >= brute[j]) j--;

        int tmp = brute[j]; brute[j] = brute[i]; brute[i] = tmp;

        for(int l = i+1, r = brute.length-1; l < r; l++, r--){
            tmp = brute[l]; brute[l] = brute[r]; brute[r] = tmp;
        }
        return true;
    }

    static boolean isAdj(int ax, int ay, int bx, int by){
        if(ax == bx) return Math.abs(ay - by) == 1;
        if(ay == by) return Math.abs(ax - bx) == 1;
        return false;
    }
    static boolean isCon(int[][] shape){
        boolean flag = false;
        for(int i=0; i<4; i++){
            int cnt = 0;
            for(int j=0; j<4; j++){
                if(isAdj(shape[i][0], shape[i][1], shape[j][0], shape[j][1])) cnt++;
            }
            if(cnt == 0) return false;
            if(cnt >= 2) flag = true;
        }
        return flag;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] brute = new int[16];
        for(int i=12; i<16; i++) brute[i] = 1;

        do{
            int[][] shape = new int[4][2];
            int idx = 0;
            for(int i=0; i<16; i++){
                if(brute[i] == 1) {
                    shape[idx][0] = i / 4;
                    shape[idx][1] = i % 4;
                    idx++;
                }
            }
            if(isCon(shape)) tetro.add(shape);
        }while(nextPermutation(brute));

        for(int i=0; i<=n-4; i++){
            for(int j=0; j<=m-4; j++){
                for(int[][] shape : tetro){
                    int tot = 0;
                    for(int t=0; t<4; t++){
                        tot += board[i+shape[t][0]][j+shape[t][1]];
                    }
                    mx = Math.max(mx, tot);
                }
            }
        }
        bw.write(mx + "");
        bw.flush();
        bw.close();
    }
}
