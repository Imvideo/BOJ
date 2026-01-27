import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, mx = 0;
    static int[][] board = new int[502][502];
    static ArrayList<int[][]> shape = new ArrayList<>();
    static boolean nextPermutation(int[] a){
        int i = a.length-2;
        while(i>=0 && a[i] >= a[i+1]) i--;
        if(i < 0) return false;

        int j = a.length - 1;
        while(a[i] >= a[j]) j--;
        int tmp = a[i]; a[i] = a[j]; a[j] = tmp;

        for(int l = i+1, r = a.length-1; l < r; l++, r--){
            tmp = a[l]; a[l] = a[r]; a[r] = tmp;
        }
        return true;
    }

    static boolean isConn(int[][] comb){
        boolean flag = false;
        for(int i=0; i<4; i++){
            int cnt = 0;
            for(int j=0; j<4; j++){
                if(i==j) continue;
                if(isAdj(comb[i][0], comb[i][1], comb[j][0], comb[j][1])){
                    cnt++;
                }
            }
            if(cnt == 0) return false;
            if(cnt >= 2) flag = true;
        }
        return flag;
    }

    static boolean isAdj(int ax, int ay, int bx, int by) {
        if(ax == bx) return Math.abs(ay - by) == 1;
        if(ay == by) return Math.abs(ax - bx) == 1;
        return false;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] brute = new int[16];
        for(int i=12; i<16; i++){
            brute[i] = 1;
        }

        do {
            int idx = 0;
            int[][] comb = new int[4][2];
            for(int i=0; i<16; i++){
                if(brute[i] == 1){
                    comb[idx][0] = i / 4;
                    comb[idx][1] = i % 4;
                    idx++;
                }
            }
            if(isConn(comb)) shape.add(comb);
        } while(nextPermutation(brute));

        for(int i=0; i <= n-4; i++){
            for(int j=0; j<= m-4; j++){
                for(int[][] tetro : shape){
                    int tot = 0;
                    for(int t=0; t<4; t++){
                        tot += board[i + tetro[t][0]][j + tetro[t][1]];
                    }
                    if(mx < tot){
                        mx = tot;
                        // bw.write("mx = " + tot +"\n");
                        // for(int t=0; t<4; t++){
                        //     bw.write(tetro[t][0] + " " + tetro[t][1] +"\n");
                        // }
                        // bw.write("\n");
                    }
                }
            }
        }
        bw.write(mx+"");
        bw.flush();
        bw.close();
    }
}
