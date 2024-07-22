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
        int max = 10000;
        String[] deque = new String[2*max+1];
        int n = Integer.parseInt(br.readLine());
        int head = max;
        int tail = max;
        String command;
        String num;

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            if(command.equals("push_front")){
                num = st.nextToken();
                deque[--head]=num;
            }
            else if(command.equals("push_back")){
                num = st.nextToken();
                deque[tail++] = num;
            }
            else if(command.equals("pop_front")){
                if(head==tail) bw.write(-1+"\n");
                else{
                    bw.write(deque[head++]+"\n");
                }
            }
            else if(command.equals("pop_back")){
                if(head==tail) bw.write(-1+"\n");
                else{
                    bw.write(deque[--tail]+"\n");
                }
            }
            else if(command.equals("size")){
                bw.write(tail-head+"\n");
            }
            else if(command.equals("empty")){
                if(tail==head) bw.write(1+"\n");
                else bw.write(0+"\n");
            }
            else if(command.equals("front")){
                if(tail==head) bw.write(-1+"\n");
                else bw.write(deque[head]+"\n");
            }
            else if(command.equals("back")){
                if(tail==head) bw.write(-1+"\n");
                else bw.write(deque[tail-1]+"\n");
            }
        }
        bw.close();
    }
}