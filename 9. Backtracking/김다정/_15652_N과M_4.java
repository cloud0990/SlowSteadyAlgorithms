package 백준_백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

1부터 N까지 자연수 중에서 M개를 고른 수열

같은 수를 여러 번 골라도 된다.

- 결과 출력 조건 
출력은 비 내림차순(각각의 원소가 전 순서 원소에 비해 이전의 원소보다 작지 않은 순서)
사전순 오름차순

이미 방문한 곳도 방문해야하기 때문에 방문배열은 생성하지 않는다.(방문체크 없음)
*/
public class _15652_N과M_4 {

	//전역변수
	static int N;
	static int M;
	static int[] arr;	
	//입출력 전역객체
	static StringBuilder  sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{

		//0. 입출력 객체 생성
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//1. N, M 입력받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//2. 탐색배열 초기화 -> M
		arr = new int[M];
		
		//3. dfs 호출 : depth/start는 0으로 전달
		dfs(0,0);
		
		//3-1. 결과출력
		bw.write(sb.toString());
		bw.flush();
		//4. 자원 종료
		bw.close();
		br.close();
	}

	public static void dfs(int depth, int start) throws IOException{
		
		//1. 탈출조건 : 깊이가 M과 같아지면 arr 결과 저장 후 종료
		if(depth==M) {
			for(int i : arr) {
				//i가 0이면 출력하지 않는다. 전 문제에서는 arr[depth] = i+1을 했기 때문에 0이 들어갈 일이 없었기 때문에 생략했다.
				//if(i==0) continue;  여기서도 필요없는듯
				sb.append(i).append(" ");
			}
			sb.append("\n"); //줄바꾸기
			return;          //종료
		}
		
		//2. 탈출조건에 만족하지않는다면, N만큼 반복하면서 재귀호출
		for(int i=start; i<N; i++) {
			
			arr[depth] = i+1;
			//start+1을 하게되면, 현재 반복문인덱스값의 +1한 값 -> 첫번째 결과는 1,2 이렇게 나옴
			//후위증감연산자로, 모든 연산 종료 후에 start값 자체가 증가하도록 해야함
			//여기서 start를 인자값으로 넘겨주지않으면, 사전순증가 방문 못함
			dfs(depth+1, start++);
			
		}//for end
		
	}//dfs() end
	
}
