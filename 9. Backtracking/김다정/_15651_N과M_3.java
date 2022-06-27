package ����_��Ʈ��ŷ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
��� : 1���� N���� �ڿ��� �߿��� M���� �� ����

���� ���� ���� �� ��� ��

-> �ߺ��Ǵ� ������ �湮�� �� �ֱ� ������, �湮üũ�� �����ʴ´�.
*/

public class _15651_N��M_3 {

	//��������
	static int N;
	static int M;
	static int[] arr;
	//IO ������ü
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder  sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		//1. ����� ��ü ����
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//2. N,M�Է¹ޱ�
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//3. Ž���迭 �ʱ�ȭ
		arr = new int[M];
		
		//4. dfs() ȣ�� -> �޼ҵ� ������ ������� ��� -> �ϴϱ� �ð��ʰ��� : �ۿ��� �� ���� �ص� �Ǵµ� ȣ��� ������ ����ؼ� �׷� ��
		dfs(0);
		//�޼ҵ� ������ ������ ����� �޼ҵ� ���� ��, main()���� 1���� ����Ѵ�.
		bw.write(sb.toString()); //��¹��� ����
		bw.flush(); 			 //���
	}
	
	public static void dfs(int depth) throws IOException{
		
		//1. Ż������ ����
		if(depth==M) {
			
			for(int i : arr) {
				
				//i�� 0�̸� �ǳʶڴ�.
				//if(i==0) continue; -> i+1�̴ϱ� 0�� ����Ǵ� ���� ����
				
				sb.append(i).append(" ");
			}//for end
			
			sb.append("\n"); 		 //�ٹٲٱ�
			//���ȣ��� ������ �ȿ��� ����ؼ� �ð��ʰ� ��
			//sb.setLength(0);         //StringBuilder ����(�ʱ�ȭ)
			return; //���⼭ return �� �ϸ� ���� ���� -> ArrayIndexOutOfBoundsException �߻� (arr�� M��ŭ �ʱ�ȭ�س��µ� M���� ������ϰ� �迭 ���� �ʰ�)
		}//if end
		
		//2. ���̰� M�� �ʰ������ʴ´ٸ�,
		for(int i=0; i<N; i++) { //i=0 1 2 3

			arr[depth] = i+1; //i�� 0���� �����ϴϱ�, i+1 -> 1���� ä��
			
			//���⼭ depth+1�ؼ� ���ȣ���ؾ� arr[1] ä����
			//�������� start�� �ݺ����� �������� �״�� ���󰣴�. (�������� �����ؾ� �ߺ����� �湮) -> �ʿ����
			dfs(depth+1);
		}
		
	}//dfs() end
}