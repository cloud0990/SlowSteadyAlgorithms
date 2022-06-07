package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2110_공유기설치 {
	static int house[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		//집의 개수
		house = new int[N];
		
		for(int i=0; i< N; i++) {
			house[i] = Integer.parseInt(br.readLine()); //집의 좌표
		}
		
		Arrays.sort(house);
		
		//탐색해야 하는 범위는 두 집 사이의 거리이다. 두 집 사이의 거리로 가질 수 있는 최대최소값을 구한다.
		//인접한 두 집 사이의 거리로 가질 수 있는 최솟값
		int min=1;
		int max = house[N-1]-house[0]+1; //가장 멀리 있는 집부터 가장 앞에 있는 집 사이의 거리, 상한 값은 찾는 값보다 1크기 때문에 시작 범위도 1크게 잡아준다.
		
		while(min < max) {
		
			
			int mid = min+(max-min)/2; //오버플로우 방지
			
			if(install(mid)<C) {
				//중간에 있는 거리로 기준을 잡았을 때 설치할 수 있는 공유기의 수가 
				//문제에서 제시한 값보다 작다면. -> 거리를 줄여서 공유기를 더 설치 해야 한다. 
				//내가 찾는 거리는 중간 값보다 작다는 뜻이다.
				
				max = mid;
			}else {
				//중간에 있는 거리로 기준을 잡았을 때 설치할 수 있는 공유기의 수가
				//문제에서 제시한 값보다 크거나 같다면 -> 거리를 늘려서 공유기를 덜 설치해야 한다. 
				//내가 찾는 거리는 중간 값보다 크거나 같다는 뜻이다. 
				//이때 위의 조건 과는 달리 '같다'는 조건이 추가로 붙어있기 때문에 mid + 1로 이동해야 한다.
				min = mid + 1;
			}
			
			//상한 값은 탐색값을 초과하는 첫 번째 값을 가리키므로, -1을 해준다. 
			 
		}
		System.out.println(min - 1);
		
	}

	private static int install(int mid) {
		// TODO Auto-generated method stub
		//mid값을 기준으로 설치할 수 있는 공유기의 수를 리턴한다. 
		//시작지점은 이미 공유기를 설치했다는 가정하에 카운트하고 시작 
		
		int count = 1; 
		
		//가장 마지막으로 설치한 위치  ->  시작 지점
		int last = house[0];
		
		for(int i=1; i<house.length; i++) {
			int current = house[i];
			
			if(current - last >= mid) {
				count++;
				last = current;
			}
		}
		
		
		return count;
	}

}

/*
	의사 코드 
	이분탐색을 사용해서 탐색을 하기 때문에 탐색시간에 있어서 시간초과 우려는 적음
	이분 탐색을 위해서는 정렬이 필요하다. n의 범위가 200,000이지만 내장 객체로 정렬하면 충분히 가능하다.
	
	1. 한 집에는 최대 하나의 공유기만 설치해야 한다. 0 or 1
	2. 모든 집에서 와이파이를 사용해야 하는 것이 아니다. -> 최대한 많은 곳에서 와이파이를 사용하려 한다고 했음
	3. 가장 인접한 두 공유기 사이의 거리를 최대로 하여 설치를 한다.
	4. 탐색의 대상은 "두 공유기 사이의 최대 거리"이다.
	
	위는 문제의 기본조건이다. 
	
	그렇다면 문제의 조건을 만족하면서 두 공유기 사이의 최대 거리를 어떻게 구할까? 
	최대의 거리를 구하기 위해서는 최댓값 중에서 최솟값을 찾거나 or 최솟값 중에서 최댓값을 찾아야 한다. 
	if 최대 거리 중에서 최솟값을 찾는다면, 두 공유기 사이의 거리가 최대 거리보다 크거나 같을 때만 공유기를 설치할 수 있다. 
	그런데 이렇게 하면, 설치되는 공유기의 수가 문제에서 제시하는 공유기의 수(C)보다 크다고 보장할 수 없다. 
	따라서 최솟값 중에서 최대를 찾도록 해보자. 
	말이 조금 어려울 수 있으니 집중해보자.
	
	내가 설정한 최소 거리에 따라 설치할 수 있는 공유기의 수가 달라진다. 이는 최대 거리에 따라 분류할때도 마찬가지
	두 공유기 사이의 거리가 최소 거리보다 크다면 공유기를 설치할 수 있다. 이때 설치 가능한
	공유기의 수가 문제에서 제시한 C와 같아진다면 그때의 최소 거리들 중에서 최댓값을 구한다. 
	ex) c=3일 때, 최소 기준 거리가 3일 때, 설치가능한 공유기 수가 3일 수도 있고, 최소 기준 거리가 5일 때, 설치 가능한 공유기의 수가 5일 수도 있으므로
	이때 최소 거리의 최대값은 5가 된다.  
	
	
	의사코드
	1. 공유기를 설치하는 거리가 최소 거리일 때 설치할 수 있는 공유기의 수가 C와 같다면, 그 때의 최소 거리의 최댓값을 찾는다. 
	2. 거리가 최소거리일 때, 설치할 수 있는 공유기의 수를 파악해야 한다. 
	
	
	
	
	집도 많은 새기가 그냥 모든집에 공유기 설치할 것이지 씨xxx;
	문제 접근 
	1. 한 집에는 최대 1개의 공유기를 설치할 수 있다. 0 or 1
	2. 문제를 주의깊게 읽었다면 헷갈릴 일은 없겠지만, 문제의 핵심은 모든 집에서 와이파이를 사용할 수 있어야 하는 것이 아니라, 최대한 많은 곳에서 사용하기 위함이다. 
	3. 설치해야 하는 공유기의 수가 C로 주어지는데 이때의 공유기를 설치한 집 사이 거리의 최대를 구해야 한다.
	
	이분 탐색을 적용하기 전에 어떤 값을 이분탐색의 기준으로 삼을 것인지를 생각해야 한다. 
	1. 기본적으로 설치해야 하는 공유기의 수를 문제에서 주어지기 때문에 설치할 수 있는 공유기의 수가 문제에서 주어진 C일때 탐색을 종료해야 한다. 
	2. 설치할 수 있는 공유기의 수를 좌우 하는 기준이 무엇일까?
	3. 공유기를 설치하는 기준을 먼저 잡아야 한다. 공유기를 설치하기 위해서 최소로 정의하는 거리를 L이라고 하자. 
	4. 인접한 두 집 사이의 거리가 L이상일 때는 두 집 모두 공유기를 설치할 수 있다. 이때 인접한 두 집은 바로 직전의 집이 아니라 가장 마지막에 공유기를 설치한 집과 비교를 해야 한다. 
			예)
			집의 좌표가 다음과 같다고 하자, 공유기를 설치하는 거리 L을 3으로 잡겠다. 
			1	2	3	4	5
		
			
			1) 바로 직전의 집과 거리를 비교한다고 할때, 
			모든 집 사이의 거리는 1이므로 시작점을 제외한 어느 집도 공유기를 설치할 수 없다.  
			
			1	2	3	4	5
			공
			
			2) 가장 마지막에 설치한 집과의 거리를 비교한다고 할 때,
			다음과 같이 하나의 공유기를 더 설치할 수 있다. 
			1	2	3	4	5
			공          공
	
	5. 그렇다면 이제 끝났다. L이 커질수록 설치할 수 있는 공유기는 줄어들 것이고 
	   L이 작아질 수록 설치할 수 있는 공유기는 증가할 것이다. 이것으로 이분탐색을 진행해서 C와 같아지는 순간의 두 공유기 사이의 최대 거리를 구하자 
		
		//집의 좌표를 저장할 배열
		house = new int[N];
		
		//정렬은 필수
		Arrays.sort(house);
		
		이분탐색에서 탐색할 양 끝단의 투포인터를 정의한다. 
		탐색의 대상은 두 집 사이의 거리 L이라고 했다.
		
		문제의 핵심은 여기서 갈린다. 설치한 공유기의 수가 C가 되게 하기 위한 
		L의 값이 1개 이상일 것이다. 조건을 만족하는 L의 구간이 존재할 텐데 이
		구간 중에서 가장 큰 값 -> 상한 값을 찾아야 최댓값을 구할 수 있다.
		min = ? 
		max = ?
		
		while(min과 max가 교차하기 전까지) {
		
			
			mid = ? (오버플로우 방지 문제의 입력 조건을 보면 오버플로우가 날거다. 이를 방지할 중간값을 찾는 법을 생각)
			
			if(메소드를 하나 정의하자. mid의 값으로 설치할 수 있는 공유기의 수가 C보다 작다면? ) {
				공유기를 더 설치해야 겠죠?  
				공유기를 더 설치하려면 어떻게 할 까요? 
				
			}else {
				위는 작다면 이었으니 이번엔 크거나 같다면 -> 어떻게 할까요?
			}
			
			 
		}
		
	}

	private static int install(int mid) {
		// TODO Auto-generated method stub
		//mid값을 기준으로 설치할 수 있는 공유기의 수를 리턴한다. 
		
		//시작점을 설치한다고 미리 카운트
		count = ?; 
		
		//가장 마지막으로 설치한 위치  ->  시작 지점
		int last = house[0];
		
		for(int i=1; i<house.length; i++) {
			
			if(현재 위치와 가장 마지막으로 설치한 집의 거리차가 mid보다 크다면) {
				공유기를 설치했다고 카운트 해주고 가장 마지막으로 설치한 집의 위치를 갱신해야죠?
			}
		}
		
		
		return count;
	}   
	   
*/
