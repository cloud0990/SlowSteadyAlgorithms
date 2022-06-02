package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1654 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");
		int N = Integer.valueOf(nm[0]);
		int M = Integer.valueOf(nm[1]);

		int[] A = new int[N];

		long start = 0; // ���۰���
		long end = 0; // �� �ε����� ���� �� �߿� ���� ū ��
		long mid = 0;
		long count = 0;

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
			if (end < A[i]) {
				end = A[i];
			}
		}

		end++;

		while (start < end) {
			mid = (start + end) / 2;
			count = 0;
			for (int i = 0; i < N; i++) {
				count += (A[i] / mid);
			}

			if (count < M) {
				end = mid;
			} else {
				start = mid + 1;
			}

		}
		System.out.println(start - 1);

	}
}
