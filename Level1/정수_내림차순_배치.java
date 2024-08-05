package Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12933


public class 정수_내림차순_배치 {
    public static void main(String[] args) {

        long result = solution(118372);  //873211
    }

    public static long solution(long n) {
        String s = "";

        int[] numArr = new StringBuilder().append(n).chars().map(Character::getNumericValue).sorted().toArray();
        for(int i=numArr.length-1 ; i>=0 ; i--) {
            s += numArr[i]+"";
        }

        return Long.parseLong(s);
    }

}
