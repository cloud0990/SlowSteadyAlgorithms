package mergesort;

public class MergeSortPractice {

	// ������Ʈ�� �ӽ���������� �ʿ��ϴ�.
	private static void mergeSort(int[] arr) {
		int[] temp = new int[arr.length]; // �迭�� ũ�⸸ŭ ������������������
		mergeSort(arr, temp, 0, arr.length-1);
	}
	private static void mergeSort(int[] arr, int[] temp, int start, int end) {
		if(start < end) {
			int mid = (start+end)/2;
			mergeSort(arr,temp,start,mid); // �迭�� �պκп� START , END ����Ʈ ����
			mergeSort(arr,temp,mid+1,end); // �迭�� �޺κе� MID+1, END ����Ʈ ����
			merge(arr,temp,start,mid,end); // �ΰ��� ����Լ��� ���ƿ��� �ΰ��� �迭�� ������ �Ǿ������� ���������ش�.
		}
	}
	
	private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
		for(int i = start; i<=end; i++) {
			temp[i] = arr[i]; // �ӽ�����ҿ� �迭�� ���� �־�д�.
		}
		int part1 = start; // ù���� �迭���� ù��° �ε���
		int part2 = mid+1;  // �ι�° �迭���� ù��° �ε���
		int index = start; // ���� �ε������� �������� ������ ������ ������ ������ ���� ����
		
		while(part1<=mid && part2 <= end) { // ù���� �迭�� ������ ���ų� �ι�° �迭�� ������ ��������
			if(temp[part1] <= temp[part2]) {
				arr[index] = temp[part1]; // ���� ������ ���� ���� �ű�� ���� �����͸� �ű��
				part1++;
			} else {
				arr[index] = temp[part2]; // �ڰ� ������ ���� �迭�� ���� �����ϰ� ���� �����͸� �Ű��ش�.
				part2++;
			}
			index ++; // �ε����� � ��Ȳ���� �÷��ش�.
		}
		// �ι�° �迭�� ������ ���� �� ���ʿ� ���� ������ ���������� ������ �迭�� ���� ���� ä���ش�.
		for(int i =0; i<=mid -part1; i++) {  
			arr[index +i] = temp[part1 + i]; 
		}
	}

	
	public static void printArray(int[] arr) {
		for(int data : arr) {
			System.out.print(data + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		printArray(arr);
		mergeSort(arr);
		printArray(arr);
		
	}

}
