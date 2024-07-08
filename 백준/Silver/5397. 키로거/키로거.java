import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main{
    static int case_num;
    static String word;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        case_num = Integer.parseInt(br.readLine());
        for(int i = 0; i < case_num; i++){
            LinkedList<Character> list = new LinkedList<Character>();
            ListIterator<Character> iterator = list.listIterator();
            String[] words;
            word = br.readLine();
            words = word.split("");
            
            for(int j = 0; j < word.length(); j++){
                char c = word.charAt(j);
                if(words[j].equals("<")) {
                    if(iterator.hasPrevious()) {
                        iterator.previous();       
                    }
                }
                else if(words[j].equals("-") ){
                    if(iterator.hasPrevious()){
                        iterator.previous();
                        iterator.remove();
                    }

                }
                else if (words[j].equals(">") ){
                    if(iterator.hasNext()) iterator.next();
                    } 
                else {
                    iterator.add(c);
                }
            }
            for(Character c : list){
                bw.write(c);
            }
            bw.write("\n");
        }
        bw.close();
    }
}