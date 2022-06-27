package 백준_백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _15649_N과M_1 {

	//전역변수
	static int[] arr;
	static boolean[] visited;
	static int N;
	static int M;
	//IO객체
	static StringBuilder  sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		//IO객체 생성
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//예제 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//각 배열 초기화
		arr     = new int[M];
		visited = new boolean[N];
	
		//함수 호출
		dfs(0);
	
		//사용한 IO객체 종료
		bw.close();
		br.close();
	}//main() end
	
	
	public static void dfs(int depth) throws IOException {
		
		//탈출조건 : 깊이(depth)가 M과 같아지면 탐색과정 배열 출력 후 탈출
		if(depth==M) {
			
			for(int i : arr) {
				
				if(i==0) continue; //0은 건너뛴다.
				//결과 sb에 추가
				sb.append(i).append(" ");
			}
			sb.append("\n");         //줄바꾸기
			bw.write(sb.toString()); //출력버퍼에 저장
			bw.flush(); //출력
			sb.setLength(0);
			return;
		}

		for(int i=0; i<N; i++) {
			
			//방문하지 않은 곳만 방문한다.
			if(!visited[i]) {
				
				//방문체크
				visited[i] = true;
				//arr에 값 추가
				arr[depth] = i+1;
				//깊이 1 증가해서 dfs 함수 호출
				dfs(depth+1);
				//탐색한 곳 다시 원상복구
				visited[i] = false;
			}
		}
	}//dfs() end

}