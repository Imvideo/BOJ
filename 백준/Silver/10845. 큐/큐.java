import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> q = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            if(com.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
            }
            else if(com.equals("pop")){
                if(q.isEmpty()){
                    bw.write(-1+"\n");
                }
                else{
                    bw.write(q.poll()+"\n");
                }
            }
            else if(com.equals("size")){
                bw.write(q.size()+"\n");
            }
            else if(com.equals("empty")){
                if(q.isEmpty()){
                    bw.write(1+"\n");
                }
                else{
                    bw.write(0+"\n");
                }
            }
            else if(com.equals("front")){
                if(q.isEmpty()){
                    bw.write(-1+"\n");
                }
                else{
                    bw.write(q.peek()+"\n");
                }
            }
            else{
                if(q.isEmpty()){
                    bw.write(-1+"\n");
                }
                else{
                    bw.write(q.peekLast()+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}