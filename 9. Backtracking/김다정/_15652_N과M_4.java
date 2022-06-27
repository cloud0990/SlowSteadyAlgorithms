package ����_��Ʈ��ŷ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

1���� N���� �ڿ��� �߿��� M���� �� ����

���� ���� ���� �� ��� �ȴ�.

- ��� ��� ���� 
����� �� ��������(������ ���Ұ� �� ���� ���ҿ� ���� ������ ���Һ��� ���� ���� ����)
������ ��������

�̹� �湮�� ���� �湮�ؾ��ϱ� ������ �湮�迭�� �������� �ʴ´�.(�湮üũ ����)
*/
public class _15652_N��M_4 {

	//��������
	static int N;
	static int M;
	static int[] arr;	
	//����� ������ü
	static StringBuilder  sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{

		//0. ����� ��ü ����
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//1. N, M �Է¹ޱ�
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//2. Ž���迭 �ʱ�ȭ -> M
		arr = new int[M];
		
		//3. dfs ȣ�� : depth/start�� 0���� ����
		dfs(0,0);
		
		//3-1. ������
		bw.write(sb.toString());
		bw.flush();
		//4. �ڿ� ����
		bw.close();
		br.close();
	}

	public static void dfs(int depth, int start) throws IOException{
		
		//1. Ż������ : ���̰� M�� �������� arr ��� ���� �� ����
		if(depth==M) {
			for(int i : arr) {
				//i�� �̸� ������� �ʴ´�. �� ���������� arr[depth] = i+1�� �߱� ������ 0�� �� ���� ������ ������ �����ߴ�.
				if(i==0) continue; 
				sb.append(i).append(" ");
			}
			sb.append("\n"); //�ٹٲٱ�
			return;          //����
		}
		
		//2. Ż�����ǿ� ���������ʴ´ٸ�, N��ŭ �ݺ��ϸ鼭 ���ȣ��
		for(int i=start; i<N; i++) {
			
			arr[depth] = i+1;
			//start+1�� �ϰԵǸ�, ���� �ݺ����ε������� +1�� �� -> ù��° ����� 1,2 �̷��� ����
			//�������������ڷ�, ��� ���� ���� �Ŀ� start�� ��ü�� �����ϵ��� �ؾ���
			//���⼭ start�� ���ڰ����� �Ѱ�����������, ���������� �湮 ����
			dfs(depth+1, start++);
			
		}//for end
		
	}//dfs() end
	
}