import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<String> queue = new ArrayList<String>();
        int n = Integer.parseInt(br.readLine());
        String command;
        int head = 0;
        int tail = 0;

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            if(command.equals("push")){
                queue.add(st.nextToken());
                tail++;
            }
            else if(command.equals("pop")){
                if(tail - head == 0){
                    bw.write(-1+"\n");
                }
                else{
                    bw.write(queue.get(head)+"\n");
                    head++;
                }
            }
            else if(command.equals("size")){
                bw.write(tail-head+"\n");
            }
            else if(command.equals("empty")){
                if(tail==head) bw.write(1+"\n");
                else bw.write(0+"\n");
            }
            else if(command.equals("front")) {
                if(head==tail) bw.write(-1+"\n");
                else bw.write(queue.get(head)+"\n");
            }
            else if(command.equals("back")) {
                if(head==tail) bw.write(-1+"\n");
                else bw.write(queue.get(tail-1)+"\n");
            }
            
        }
        bw.close();
    }
}