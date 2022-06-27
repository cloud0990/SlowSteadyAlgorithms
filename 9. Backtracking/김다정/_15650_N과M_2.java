package ����_��Ʈ��ŷ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15650_N��M_2 {

	//��������
	static int[] arr;          //�������迭
	//static boolean[] visited;  //�湮�迭
	static int N;
	static int M;
	//���� IO ��ü ����
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder  sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		//IO��ü ����
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//���� �Է¹ޱ�
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//�� �迭 �ʱ�ȭ
		arr     = new int[M];
		//visited = new boolean[N];
		
		//dfs �Լ� ���� ȣ��
		//main���� ó�� dfs�� ȣ��Ǹ�, ����ȣ���� ���� for���� ����� ������ �ݺ�(���ο��� +1�� �ؼ� ���ȣ��)
		//����ȣ���� ���� for���� ����Ǹ� ����
		dfs(0,0);
		
	}//main() end
	
	
	public static void dfs(int depth, int start) throws IOException {
		
		//System.out.println(cnt++);
		
		//Ż������ : depth == M �� ���, Ž���迭�� ����� ��� ��� �� ����
		if(depth==M) {
			
			for(int i : arr) {
				//�������� : �� �� ��� ���� ���� ����� ���ܽ�Ų��.
				if(i==0) continue;
				
				sb.append(i).append(" ");
			}
			sb.append("\n");         //�ٹٲٱ�
			bw.write(sb.toString()); //��¹��� ����
			bw.flush();              //���
			sb.setLength(0);         //StringBuilder �ʱ�ȭ
			return; //����
		}
		
		//main()�� dfs()�� arr[0]�� �� : �ݺ����� �ε���
		//-> ��������� main/����Լ��� for���� ��� ����Ǿ�� �����
		//dfs()���� ���dfs�� arr[1]�� ��
		//������ Ż�����ǿ� �ɸ����ʴ´ٸ� �Ʒ� �ڵ� ����
		//N��ŭ �ݺ�
		for(int i=start; i<N; i++) {
			
			//�湮���� ���� ���� �湮
			//if(!visited[i]) {
				//�湮üũ
				//visited[i] = true;
				//Ž���迭�� �� �߰�
				arr[depth] = i+1;
				
				//dfs()�� ���ڰ����� ���� depth + 1 ����
				//���⼭ depth++�� �ع�����, ���� ��ü�� ���� �����ع����� ������ �湮�� �� �ʱ�ȭ�� �� depth-- �������
				//i+1 : ���� i���� ���� ��Ͱ� 1Ŀ�� �ؼ� +1�ؼ� ����
				//���� i�� 1�̶��, ���� ��Ϳ��� i=2�� ����
				dfs(depth+1, i+1); 
				
				//�湮�� �� �ٽ� �ʱ�ȭ�ϴ� ���� : �̹� ���� ���̶� �ٽ� �湮 �ؾ��ϴϱ�
				//visited[i] = false;
			//}
		}
	}//dfs() ends

}