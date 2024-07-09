import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<Integer>();
        ListIterator<Integer> it = list.listIterator();

        bw.write("<");
        for(int i=1;i<=n;i++) it.add(i);
        while(!list.isEmpty()){
            for(int i=0;i<k;i++){
                if(it.hasNext()){
                    it.next();
                }
                else{
                    it = list.listIterator();
                    it.next();
                }
            }
            it.previous();
            bw.write(it.next().toString());
            it.remove();
            if(!list.isEmpty()){
                bw.write(", ");
            }
        }
        bw.write(">");
        bw.close();
    }
}