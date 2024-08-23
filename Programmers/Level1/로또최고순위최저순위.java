package Programmers.Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/77484

public class 로또최고순위최저순위 {
	public int[] solution1(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		int a = 0, b = 0;
		for (int i = 0; i < lottos.length; i++) {
			for (int j = 0; j < win_nums.length; j++) {
				if (lottos[i] == win_nums[j]) {
					a += 1;
				}
			}
			if (lottos[i] == 0) {
				b += 1;
			}
		}
		b = a + b;

		//일치하는 번호가 a가 최저, b가 최고
		switch (b) {
			case 6 :
				answer[0] = 1;
				break;
			case 5 :
				answer[0] = 2;
				break;
			case 4 :
				answer[0] = 3;
				break;
			case 3 :
				answer[0] = 4;
				break;
			case 2 :
				answer[0] = 5;
				break;
			default:
				answer[0] = 6;
				break;
		}

		switch (a) {
			case 6 :
				answer[1] = 1;
				break;
			case 5 :
				answer[1] = 2;
				break;
			case 4 :
				answer[1] = 3;
				break;
			case 3 :
				answer[1] = 4;
				break;
			case 2 :
				answer[1] = 5;
				break;
			default:
				answer[1] = 6;
				break;
		}

		return answer;
	}


	/*-------------------다른 사람 코드 보고 고친 부분----------------------*/
	public int[] solution2(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		int a = 0, b = 0;
		for(int lotto : lottos) {
			if(lotto == 0){
				a++;
			}
			for(int win_num : win_nums) {
				if(lotto == win_num){
					b++;
				}
			}
		}

		answer[0] = getRanking(a+b);
		answer[1] = getRanking(b);

		return answer;
	}

	public int getRanking(int num) {
		switch (num) {
			case 6 :
				return 1;
			case 5 :
				return 2;
			case 4 :
				return 3;
			case 3 :
				return 4;
			case 2 :
				return 5;
			default:
				return 6;
		}
	}
};