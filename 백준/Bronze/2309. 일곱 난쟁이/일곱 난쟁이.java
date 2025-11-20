import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean flag = false;
    static int sum = 0;
    static int[] dwarf = new int[9];
    static boolean[] used = new boolean[9];
    static ArrayList<Integer> ans = new ArrayList<>();
    
    public static void main(String args[]) throws IOException {
        // 입력
        for(int i=0; i<9; i++){
            dwarf[i] = Integer.parseInt(br.readLine());
            sum += dwarf[i];
        }
        Arrays.sort(dwarf);
        for(int i=0; i<9; i++){
            if(flag) break;
            for(int j=i+1; j<9; j++){
                if(sum - dwarf[i] - dwarf[j] == 100){
                    dwarf[i] = 0; dwarf[j] = 0;
                    flag = true;
                    break;
                }
            }
        }
        for(int i=0; i<9; i++){
            if(dwarf[i] != 0 ) bw.write(dwarf[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}