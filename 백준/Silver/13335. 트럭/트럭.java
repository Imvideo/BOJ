import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,w,L,ans=0;
    static Queue<Integer> trucks = new LinkedList<Integer>();
    static int[] bridge = new int[102];

    static boolean isBridgeEmpty(){
        for(int i=0; i<w; i++){
            if(bridge[i] != 0) return false;
        }
        return true;
    }

    static void go(){
        for(int i=w-1; i>0; i--){
            bridge[i] = bridge[i-1];
        }
        bridge[0] = 0;
        return;
    }

    static int weightSum(){
        int sum=0;
        for(int i=0; i<w; i++){
            sum+= bridge[i];
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }
        
        do{
            int bridgeWeight = weightSum();
            if(bridgeWeight <= L) {
                bridgeWeight-=bridge[w-1];
                go();
                if(!trucks.isEmpty() && bridgeWeight+trucks.peek() <= L){
                    bridge[0] = trucks.poll();
                }
            }
            ans++;
        } while(!isBridgeEmpty());
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
    }
}