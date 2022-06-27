package ����_��Ʈ��ŷ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _15649_N��M_1 {

	//��������
	static int[] arr;
	static boolean[] visited;
	static int N;
	static int M;
	//IO��ü
	static StringBuilder  sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		//IO��ü ����
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//���� �Է�
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//�� �迭 �ʱ�ȭ
		arr     = new int[M];
		visited = new boolean[N];
	
		//�Լ� ȣ��
		dfs(0);
	
		//����� IO��ü ����
		bw.close();
		br.close();
	}//main() end
	
	
	public static void dfs(int depth) throws IOException {
		
		//Ż������ : ����(depth)�� M�� �������� Ž������ �迭 ��� �� Ż��
		if(depth==M) {
			
			for(int i : arr) {
				
				if(i==0) continue; //0�� �ǳʶڴ�.
				//��� sb�� �߰�
				sb.append(i).append(" ");
			}
			sb.append("\n");         //�ٹٲٱ�
			bw.write(sb.toString()); //��¹��ۿ� ����
			bw.flush(); //���
			sb.setLength(0);
			return;
		}

		for(int i=0; i<N; i++) {
			
			//�湮���� ���� ���� �湮�Ѵ�.
			if(!visited[i]) {
				
				//�湮üũ
				visited[i] = true;
				//arr�� �� �߰�
				arr[depth] = i+1;
				//���� 1 �����ؼ� dfs �Լ� ȣ��
				dfs(depth+1);
				//Ž���� �� �ٽ� ���󺹱�
				visited[i] = false;
			}
		}
	}//dfs() end

}