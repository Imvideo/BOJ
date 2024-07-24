import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<String> deque = new ArrayDeque<String>();
        boolean tag = true;
        boolean errtag = true;
        int t = Integer.parseInt(br.readLine());
        int num;
        String command;
        String input;
        String inputNum;

        for(int i=0;i<t;i++){
            tag = true;
            errtag = true;
            command = br.readLine();
            num = Integer.parseInt(br.readLine());
            input = br.readLine();
            input = input.substring(1,input.length()-1);
            StringTokenizer st = new StringTokenizer(input,",");
            deque = new ArrayDeque<String>();

            for(int j=0;j<num;j++){
                if(st.hasMoreTokens()){
                    inputNum = st.nextToken();
                    deque.add(inputNum);
                }
            }

            for(String str : command.split("")){
                if(str.equals("R")){
                    tag = !tag;
                }
                else if(str.equals("D")){
                    if(deque.isEmpty()){
                        bw.write("error\n");
                        errtag = false;
                        break;
                    }
                    if(tag) deque.removeFirst();
                    else deque.removeLast();
                }
            }
            if(errtag){
                bw.write("[");
                int size = deque.size();
                for(int k=0;k<size;k++){
                    if(tag){
                        if(k == size-1) bw.write(deque.removeFirst());
                        else bw.write(deque.removeFirst()+",");
                    }
                    else{
                        if(k == size-1) bw.write(deque.removeLast());
                        else bw.write(deque.removeLast()+",");
                    }
                    
                }
                bw.write("]\n");
            }
        }
        bw.flush();
        bw.close();
    }
}