import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int subin,sis; // 수빈과 동생 위치
        int[] map = new int[200002];
        int[] dx = {1,-1};
        Queue<Integer> queue = new LinkedList<Integer>();
        Arrays.fill(map,-1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        sis = Integer.parseInt(st.nextToken());

        if(subin == sis){
            bw.write(0+"");
            bw.flush();
            bw.close();
            System.exit(0);
        }

        map[subin] = 0;
        queue.add(subin);
        map[sis] = -2;

        while(!queue.isEmpty()){
            int pos = queue.poll();
            int num = map[pos] + 1;
            for(int i = 0; i < 3; i++){
                int nx;
                if(i==2) {
                    nx = 2*pos;
                }
                else{
                    nx = dx[i] + pos;
                }
                if(nx < 0 || nx > 200000) continue;
                if(map[nx] > -1) continue;
                if(map[nx] == -2) {
                    bw.write(num+"");
                    bw.flush();
                    bw.close();
                    System.exit(0);
                }
                queue.add(nx);
                map[nx] = num;

            }
        }
    }
}
