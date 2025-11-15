import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static int n, m, shopNum, x, y, sum=0;
    static ArrayList<Point> shop = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        shopNum = Integer.parseInt(br.readLine());
        for(int i=0; i<shopNum; i++){
            int r,c;
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            shop.add(new Point(r, c));
        }
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        for(int i=0; i<shopNum; i++){
            int border = shop.get(i).x;
            int dis = 0;
            if(x == 1){
                if(border == 1){
                    if(y > shop.get(i).y) dis = y-shop.get(i).y;
                    else dis = shop.get(i).y - y;
                }
                else if(border == 2){
                    int tmp1 = n + y + shop.get(i).y;
                    int tmp2 = n + m-y + m - shop.get(i).y;
                    dis = Math.min(tmp1, tmp2);
                }
                else if(border == 3){
                    dis = y + shop.get(i).y;
                }
                else if(border == 4){
                    dis = m -y + shop.get(i).y;
                }
            }
            else if(x == 2){
                if(border == 1){
                    int tmp1 = n + y + shop.get(i).y;
                    int tmp2 = n + m-y + m - shop.get(i).y;
                    dis = Math.min(tmp1, tmp2);
                }
                else if(border == 2){
                    if(y > shop.get(i).y) dis = y-shop.get(i).y;
                    else dis = shop.get(i).y - y;
                }
                else if(border == 3){
                    dis = y + n -shop.get(i).y;
                }
                else if(border == 4){
                    dis = m - y + n - shop.get(i).y;
                }
            }
            else if(x == 3){
                if(border == 1){
                    dis = y + shop.get(i).y;
                }
                else if(border == 2){
                    dis = n-y + shop.get(i).y;
                }
                else if(border == 3){
                    if(y > shop.get(i).y) dis = y-shop.get(i).y;
                    else dis = shop.get(i).y - y;
                }
                else if(border == 4){
                    int tmp1 = m + y + shop.get(i).y;
                    int tmp2 = m + n-y + n - shop.get(i).y;
                    dis = Math.min(tmp1, tmp2);
                }
            }
            else if(x == 4){
                if(border == 1){
                    dis = y + m-shop.get(i).y;
                }
                else if(border == 2){
                    dis = n-y + m-shop.get(i).y;
                }
                else if(border == 3){
                    int tmp1 = m + y + shop.get(i).y;
                    int tmp2 = m + n-y + n - shop.get(i).y;
                    dis = Math.min(tmp1, tmp2);
                }
                else if(border == 4){
                    if(y > shop.get(i).y) dis = y-shop.get(i).y;
                    else dis = shop.get(i).y - y;
                }
            }
            sum+=dis;
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}