package Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12943

public class 콜라츠추측 {
	public int solution1(long num) {
		int answer = 0;

		if(num == 1) return 0;

		while(num != 1) {
			if(num%2 == 0) {
				num /= 2;
			} else {
				num = num*3+1;
			}
			++answer;
			if(answer == 500) {
				return -1;
			}
		}

		return answer;
	}

	/* 내가 푼 풀이의 문제점
		1. 'num은 1 이상 8,000,000 미만인 정수'라는 조건이 있었는데, num을 int로 받았음.
	*
	* ================================풀이 보고 고치기
	* */
	public int solution2(int num) {
		long n = (long)num;

		for(int i=0 ; i<500 ; i++) {
			if(n==1) return i;
			n = (n%2==0) ? n/2 : n*3+1;
		}

		return -1;
	}
}
