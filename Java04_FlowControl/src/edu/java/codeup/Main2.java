package edu.java.codeup;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		int[][] arr = new int[11][11]; // 배열 arr을 생성(인덱스틑 0부터 시작하기에 11까지 총 121개 가 생성)
		// i, j로 변수를 받아서 저장을 한뒤 
		// x, y를 사용해서 배열 안에 변수를 바꾸어 준다.
		int i, j, x, y; // 변수 선언

		Scanner sc = new Scanner(System.in);

		// 미로 정보 입력
		for (i = 1; i <= 10; i++) { // i는 1부터 10까지 루프
			for (j = 1; j <= 10; j++) { // j는 1부터 10까지 루프
				arr[i][j] = sc.nextInt(); // 2차원 배열 arr에 i와 j에 각각 입력받는 방법
			}
		}
		if (arr[2][2] == 2) { // 제자리에 있는 숫자가 2인 경우
			arr[2][2] = 2; // 숫자 2로 만들어 준다
		} else {
			arr[2][2] = 9; // 시작 위치 초기화
		}
		x = 2;
		y = 2;
		

		// 주의사항) 위에서 아래로 내려가는 방식이라 만약 처음 자리에 2가 있을 경우
		//         처음에 9로 멈추어 주어야 한다
		while (true) {
			if (arr[2][2] == 2) { // 제자리에 있는 숫자가 2인 경우
				arr[2][2] = 9;
				break;
			} else if (arr[x][y + 1] == 0) { // arr 배열에서 오른쪽에 0이 있을 경우
				arr[x][y + 1] = 9; // 오른쪽을 숫자 9로 바꾼다
				y++;
				continue;
			} else if (arr[x][y + 1] == 1 && arr[x + 1][y] == 0) { // 오른쪽에 1이있고 아래쪽에 0이 있을 경우
				arr[x + 1][y] = 9; // 아래쪽을 숫자 9로 바꾼다.
				x++;
				continue;
			} else if (arr[x][y + 1] == 1 && arr[x + 1][y] == 1) { // 오른쪽 아래쪽이 둘다 0일 경우
				break;
			} else if (arr[x][y + 1] == 2) { // 오른쪽에 2가 있을 경우
				arr[x][y + 1] = 9;
				break;
			} else if (arr[x + 1][y] == 2) { // 아래쪽에 2가 있을 경우
				arr[x + 1][y] = 9;
				break;
			}
		}

		// 미로 상태 출력
		for (i = 1; i <= 10; i++) { // i는 1부터 10까지 루프
			for (j = 1; j <= 10; j++) // j는 1부터 10까지 루프
				System.out.print(arr[i][j] + " "); // 2차원 배열 arr에 있는 배열 값을 꺼내서 보여주는 방법
			System.out.println();
		}

		sc.close();

	} // end main()
} // end Main2