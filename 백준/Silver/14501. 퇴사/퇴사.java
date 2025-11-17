import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n, mx = 0, sum = 0;
    static int dp[] = new int[17];
    static ArrayList<Point> arr = new ArrayList<>();

    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int day, cost;
            StringTokenizer st = new StringTokenizer(br.readLine());
            day = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            arr.add(new Point(day, cost));
            
        }
        for(int i=n-1; i>-1; i--){
            if(i + arr.get(i).x <= n){
                dp[i] = Math.max(dp[i+1], dp[i+arr.get(i).x] + arr.get(i).y);
            }
            else{
                dp[i] = dp[i+1];
            }
        }
        bw.write(dp[0]+"");
        bw.flush();
        bw.close();
    }
}