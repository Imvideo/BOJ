import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> ans = new ArrayList<String>();
        int n = Integer.parseInt(br.readLine());
        int idx=1;
        boolean flag = false;

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            
            if(idx <= num){
                int t = num - idx;
                for(int j=0; j<=t;j++){
                    stack.push(idx++);
                    ans.add("+");
                }
                stack.pop();
                ans.add("-");
            }
            else{
                if(!stack.isEmpty() && num == stack.peek()){
                    stack.pop();
                    ans.add("-");
                }
                else{
                    flag = true;
                    break;
                }
            }
            
        }
        if(flag) bw.write("NO");
        else{
            for(String str : ans){
                bw.write(str+"\n");
            }
        }
        bw.close();
    }
}