import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static int n, m, chk = 0, mn = Integer.MAX_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static ArrayList<Point> houses = new ArrayList<>();
    static ArrayList<Point> chickens = new ArrayList<>();

    // BFS로 특정 집에서 가장 가까운 치킨집까지의 거리를 계산
    static int getDistance(ArrayList<Point> selectedChickens) {
        int totalDist = 0;
        for (Point house : houses) {
            int minDist = Integer.MAX_VALUE;
            for (Point chicken : selectedChickens) {
                int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                minDist = Math.min(minDist, dist);
            }
            totalDist += minDist;
        }
        return totalDist;
    }

    // 치킨집 선택 조합을 생성
    static void comb(int start, ArrayList<Point> selected) {
        if (selected.size() == m) {
            mn = Math.min(mn, getDistance(selected));
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            comb(i + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        // 입력받기 및 집, 치킨집 위치 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) houses.add(new Point(i, j));  // 집
                if (board[i][j] == 2) chickens.add(new Point(i, j)); // 치킨집
            }
        }

        // 치킨집 조합을 선택하여 최소 거리 계산
        comb(0, new ArrayList<>());

        bw.write(mn + "\n");
        bw.flush();
        bw.close();
    }
}
