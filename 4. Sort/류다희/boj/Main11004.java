package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11004 {
	
	/*
	 StringBuffer 
	  N, K
	  A[] 
	  for(N��ŭ){
	  A[i] = sb.readline.split
	  }
	  ����Ʈ ����
	  K��° ������ ���
	  
	  ����Ʈ�Լ�(����, ����, K){
		�ǹ� ���ϱ� �Լ� (����, ����)
		if(�ǹ�==K) ����
		else if(K<�ǹ�) ����Ʈ �����ϱ�(����, �ǹ�-1, K)
	 	else ����Ʈ �����ϱ� (�ǹ�+1, ����, K)
	  }
	  
	  �ǹ����ϱ� �Լ�(����, ����)
	  {
	  �߾Ӱ��� �ǹ����� �����ϱ�
	  i(����), j(����)
	  while(i<j){
	  	�ǹ����� ū ���� ���ö����� i++
	  	�ǹ����� ���� ���� ���ö����� j--
	  	i�� j�� swap
	  }
	  �����͸� �� �׷��� ��� index�� �����ϱ�
	 */
	
	private static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	private static void quickSort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end);
		if(start < part2 -1) {
			// ���������� ��Ƽ���� ������������ �۴ٸ� ������ ��Ƽ���� ������ �ٷ� ������ ���
			quickSort(arr,start,part2-1);
		} if(part2<end) {
			// ��Ƽ���Լ����� ������ ������ ��Ƽ���� ���۰����� range�� ������ ���
			quickSort(arr, part2, end);
		}
	}
	
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start+end)/2]; // �Ǻ��� �߰���
		while(start<=end) {
			while(arr[start]<pivot) start++;
			while(arr[end]>pivot) end--;
			if(start <=end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return start;
	}

	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N  = Integer.parseInt(st.nextToken());
		int K  = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		
		String[] numStr = br.readLine().split(" ");		
		for(int i =0;i<N;i++) {
			A[i] = Integer.valueOf(numStr[i]);
		}
		
		quickSort(A);
		
		System.out.println(A[K-1]);
		
		
	}
	
}
