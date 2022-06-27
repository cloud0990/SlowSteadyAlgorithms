package 백준_백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15650_N과M_2 {

	//전역변수
	static int[] arr;          //결과저장배열
	//static boolean[] visited;  //방문배열
	static int N;
	static int M;
	//전역 IO 객체 생성
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder  sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		//IO객체 생성
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//예제 입력받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//각 배열 초기화
		arr     = new int[M];
		//visited = new boolean[N];
		
		//dfs 함수 최초 호출
		//main에서 처음 dfs가 호출되면, 최초호출의 내부 for문이 종료될 때까지 반복(내부에서 +1씩 해서 재귀호출)
		//최초호출의 내부 for문이 종료되면 종료
		dfs(0,0);
		
	}//main() end
	
	
	public static void dfs(int depth, int start) throws IOException {
		
		//System.out.println(cnt++);
		
		//탈출조건 : depth == M 인 경우, 탐색배열에 저장된 결과 출력 후 종료
		if(depth==M) {
			
			for(int i : arr) {
				//오름차순 : 앞 뒤 상관 없이 같은 수라면 제외시킨다.
				if(i==0) continue;
				
				sb.append(i).append(" ");
			}
			sb.append("\n");         //줄바꾸기
			bw.write(sb.toString()); //출력버퍼 저장
			bw.flush();              //출력
			sb.setLength(0);         //StringBuilder 초기화
			return; //종료
		}
		
		//main()의 dfs()는 arr[0]의 값 : 반복문의 인덱스
		//-> 결론적으로 main/재귀함수의 for문이 모두 종료되어야 종료됨
		//dfs()내의 재귀dfs는 arr[1]의 값
		//위에서 탈출조건에 걸리지않는다면 아래 코드 수행
		//N만큼 반복
		for(int i=start; i<N; i++) {
			
			//방문하지 않은 곳만 방문
			//if(!visited[i]) {
				//방문체크
				//visited[i] = true;
				//탐색배열에 값 추가
				arr[depth] = i+1;
				
				//dfs()에 인자값으로 현재 depth + 1 전달
				//여기서 depth++을 해버리면, 변수 자체의 값이 증가해버리기 때문에 방문한 곳 초기화할 때 depth-- 해줘야함
				//i+1 : 현재 i보다 다음 재귀가 1커야 해서 +1해서 전달
				//지금 i가 1이라면, 다음 재귀에서 i=2로 시작
				dfs(depth+1, i+1); 
				
				//방문한 곳 다시 초기화하는 이유 : 이미 갔던 곳이라도 다시 방문 해야하니까
				//visited[i] = false;
			//}
		}
	}//dfs() ends

}