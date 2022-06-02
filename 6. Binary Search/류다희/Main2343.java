package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2343 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int N = Integer.valueOf(nm[0]);
		int M = Integer.valueOf(nm[1]);
		int[] A = new int[N];
		int start = 0;
		int end = 0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			if (A[i] > start) {
				start = A[i]; // ���� �ε����� A �迭�� �ִ밪
			}
			end = end + A[i]; // �� �ε����� A�迭������ ��
		}
		//�Է³�---
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			int count = 0;

			for (int i = 0; i < N; i++) {
				if(sum + A[i]>mid) {
					count++;
					sum=0;
				}
				sum = sum + A[i];
			}
			
			if(sum!=0) {
				count++;
			}
			if(count>M) {
				start = mid+1;
			} else {
				end = mid-1;
			}

		}
		System.out.println(start);

	}

}
