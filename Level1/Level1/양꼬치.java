package Level1;

public class 양꼬치 {
	public int solution1(int n, int k) {
        int answer = 0;
        k -= n/10;
        answer = (n*12000) + (k*2000);
        
        return answer;
    }
	/*
	 * 
	 * 
	 * 
	 ==============고친 부분=============*/
	
	public int solution2(int n, int k) {
        return n*12000 + (k-n/10)*2000;
    }

}
