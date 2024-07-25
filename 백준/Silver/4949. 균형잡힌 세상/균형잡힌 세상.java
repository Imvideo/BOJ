import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        String word;
        Stack<String> stack = new Stack<String>();
        boolean tag = true;
        while(!(input = br.readLine()).equals(".")){
            stack = new Stack<String>();
            StringTokenizer st = new StringTokenizer(input,"()[]",true);
            while(st.hasMoreTokens()){
                word = st.nextToken();
                tag = true;
                if(word.equals(".")) break;
                if(word.equals("(") || word.equals("[")){
                    stack.add(word);
                }
                else if(word.equals(")")){
                    if(stack.isEmpty()){
                        bw.write("no\n");
                        tag = false;
                        break;
                    }
                    else if(stack.peek().equals("(")){
                        stack.pop();
                    } else{
                        bw.write("no\n");
                        tag = false;
                        break;
                    }
                }
                else if(word.equals("]")){
                    if(stack.isEmpty()){
                        bw.write("no\n");
                        tag = false;
                        break;
                    }
                    else if(stack.peek().equals("[")){
                        stack.pop();
                    } else{
                        bw.write("no\n");
                        tag = false;
                        break;
                    }
                }
            }
            if(!tag) continue;
            if(stack.isEmpty()) bw.write("yes\n");
            else bw.write("no\n");
        }

        bw.flush();
        bw.close();
    }
}