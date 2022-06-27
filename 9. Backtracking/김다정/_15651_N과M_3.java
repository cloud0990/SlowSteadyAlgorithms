package 백준_백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
결과 : 1부터 N까지 자연수 중에서 M개를 고른 수열

같은 수를 여러 번 골라도 됨

-> 중복되는 지점도 방문할 수 있기 때문에, 방문체크는 하지않는다.
*/

public class _15651_N과M_3 {

	//전역변수
	static int N;
	static int M;
	static int[] arr;
	//IO 전역객체
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder  sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		//1. 입출력 객체 생성
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//2. N,M입력받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//3. 탐색배열 초기화
		arr = new int[M];
		
		//4. dfs() 호출 -> 메소드 내에서 결과까지 출력 -> 하니까 시간초과남 : 밖에서 한 번만 해도 되는데 호출될 때마다 출력해서 그런 듯
		dfs(0);
		//메소드 내에서 저장한 결과를 메소드 종료 후, main()에서 1번만 출력한다.
		bw.write(sb.toString()); //출력버퍼 저장
		bw.flush(); 			 //출력
	}
	
	public static void dfs(int depth) throws IOException{
		
		//1. 탈출조건 설정
		if(depth==M) {
			
			for(int i : arr) {
				
				//i가 0이면 건너뛴다.
				//if(i==0) continue; -> i+1이니까 0이 저장되는 경우는 없음
				
				sb.append(i).append(" ");
			}//for end
			
			sb.append("\n"); 		 //줄바꾸기
			//재귀호출될 때마다 안에서 출력해서 시간초과 뜸
			//sb.setLength(0);         //StringBuilder 비우기(초기화)
			return; //여기서 return 안 하면 종료 못함 -> ArrayIndexOutOfBoundsException 발생 (arr는 M만큼 초기화해놨는데 M에서 종료못하고 배열 범위 초과)
		}//if end
		
		//2. 깊이가 M을 초과하지않는다면,
		for(int i=0; i<N; i++) { //i=0 1 2 3

			arr[depth] = i+1; //i가 0부터 증가하니까, i+1 -> 1부터 채움
			
			//여기서 depth+1해서 재귀호출해야 arr[1] 채워짐
			//전달인자 start는 반복문의 증감식을 그대로 따라간다. (원래값을 전달해야 중복값도 방문) -> 필요없음
			dfs(depth+1);
		}
		
	}//dfs() end
}