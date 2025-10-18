import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            Boolean flag = true;
            String line = br.readLine();
            Stack<Character> s = new Stack<>();
            for(int j=0; j<line.length(); j++){
                char c = line.charAt(j);
                if(c == '('){
                    s.push(c);
                }
                else if(c == ')'){
                    if(s.isEmpty() || s.peek() != '('){
                        flag = false;
                        break;
                    }
                    else{
                        s.pop();
                    }
                }
            }
            if(!s.isEmpty()) flag = false;
            if(flag){
                bw.write("YES\n");
            }
            else{
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
    }
}