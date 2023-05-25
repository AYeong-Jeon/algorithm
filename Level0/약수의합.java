package Level0;
//https://school.programmers.co.kr/learn/courses/30/lessons/12928

public class 약수의합 {
	public int solution1(int n) {
		int sum = 0;
        int a = n;
        while(0 < a && a <= n) {
        	if(n%a == 0) {
        		sum += a;
        	}
        	--a;
        }
        
        return sum;
    }
	
	/*
	 ==============고친 부분=============
	 */
	public int solution2(int num) {
	    int answer = 0;
	    for(int i =1 ; i<=num/2 ; i++){
	      if(num%i == 0){
	        answer+=i;
	        }
	    }
	    
	    return answer+num;
	}
}
