package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main2667 {
	/*
	 * ī��Ʈ�Ѱ͵�[] ��ǥ Ž�� x[]{0,1,0,-1} y[]{1,0,-1,0} �����Է¹ޱ�[N][N] �湮üũ [N][N] 0�̸� true
	 * bfs(0,0)
	 * 
	 * ī��Ʈ�Ѱ͵� �����ϱ� �迭�������, ī��Ʈ�Ѱ͵� ���
	 * 
	 * ť ���� q.offer {0,0} ť�� �������� { int now = q.poll �湮üũ = true
	 * 
	 * ��ǥ üũ�ϰ� now ��ǥ�� x y ���ϱ�
	 * 
	 * ���� ������ ���� 0�� �ƴϰ� �湮üũ�� false��� �湮üũ = true ī��Ʈ++ q.add(new int[] {x,y}) } 0����
	 * ũ�� ī��Ʈ�Ѱ͵� �迭�� ����ֱ�
	 * 
	 * 
	 */
	static List<Integer> countArr = new ArrayList<>();
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] map;
	static boolean[][] visited;
	static int N, count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.valueOf(line.charAt(j) - '0');
				if (map[i][j] == 0) {
					visited[i][j] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false) {
					count = 0;
					bfs(i, j);
				}
			}
		}

		Collections.sort(countArr);
		System.out.println(countArr.size());
		for (int i = 0; i < countArr.size(); i++) {
			System.out.println(countArr.get(i));
		}

	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		while (!q.isEmpty()) {
			int now[] = q.poll();
			visited[x][y] = true;
			
			for (int i = 0; i < 4; i++) {
				int xx = now[0] + dx[i];
				int yy = now[1] + dy[i];

				if (xx >= 0 && yy >= 0 && xx < N && yy < N) {
					if (map[xx][yy] != 0 && !visited[xx][yy]) {
						visited[xx][yy] = true;
						count++;
						q.add(new int[] { xx, yy });
					}
				}
			}

		}
		countArr.add(count+1);

	}
}
