package practice;

import java.util.Arrays;

public class Permutation1 {
	
	// �ߺ� ������ ����� ������ �ʴ� ���� ���ϱ�

	static int[] target = new int[] {1,2,3};
	// �湮�ߴ����� üũ�ϴ� �迭
	static boolean[] visited = new boolean[3];
	// ��� ���� ��� �迭
	static int [] result = new int [2];
	
	public static void main(String[] args) {
		permutation(0);
		
	}

	private static void permutation(int count) {
		// �� ���� ���� �����ϸ� ����ϰ� ������
		if(count ==2) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i =0 ;i <3; i++) {
			// �湮������ ������ ��ŵ
			if(visited[i]) {
				continue;
			}
			//�ƴ� �� �湮�� ������ ������ش�.
			visited[i] = true;
			// ��� �迭�� ���ڸ� ��´�.
			result[count] = target[i];
			// ��� ȣ��
			permutation(count +1);
			// ������ �����ϱ�
			visited[i] = false;
		}
	}
		

}
