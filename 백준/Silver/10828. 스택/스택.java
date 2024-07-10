import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int snum = 0;

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            if(com.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
                snum++;
            }
            else if (com.equals("pop")){
                if(!stack.empty()){
                    bw.write(stack.pop()+"\n");
                    snum--;
                }
                else bw.write(-1+"\n");
            }
            else if (com.equals("size")){
                bw.write(snum+"\n");
            }
            else if (com.equals("empty")){
                if(stack.empty()) bw.write(1+"\n");
                else bw.write(0+"\n");
            }
            else if (com.equals("top")){
                if(!stack.empty()){
                    bw.write(stack.peek()+"\n");
                }
                else bw.write(-1+"\n");
            }
            
        }
        bw.close();
        
    }
}