package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main1920 {
	static int[] nArr;
	static int[] mArr;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	private static void search(int start, int end, int target) {
		int mid = (start + end) / 2;
		if (!IntStream.of(nArr).anyMatch(x -> x == target)) {
			sb.append(0).append("\n");
			return;
		}
		if (nArr[mid] == target) {
			sb.append(1).append("\n");
			return;

		} else if (nArr[mid] > target) { // ���ϴ� ���� �߰����� ������
			search(start, mid, target);

		} else if (nArr[mid] < target) { // ���ϴ� ���� �߰����� ũ��
			search(mid+1, end, target);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N �迭���
		N = Integer.parseInt(br.readLine());
		String[] nStr = br.readLine().split(" ");
		nArr = Arrays.stream(nStr).mapToInt(Integer::parseInt).toArray();
		// M �迭���
		M = Integer.parseInt(br.readLine());
		nStr = br.readLine().split(" ");
		mArr = Arrays.stream(nStr).mapToInt(Integer::parseInt).toArray();
		
		Arrays.sort(nArr);

		for (int i = 0; i < M; i++) {
			search(0, N, mArr[i]);
		}
		System.out.println(sb);
		
	}

}
