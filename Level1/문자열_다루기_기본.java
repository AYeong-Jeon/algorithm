package Level1;

public class 문자열_다루기_기본 {
    public boolean solution(String s) {
        int cnt = 0;
        for(int i=0 ; i<s.length() ; i++) {
            if(s.charAt(i)>=48 && s.charAt(i)<=57) cnt++;
        }

        return (cnt == s.length()) && lengthCheck(s);
    }

    public boolean lengthCheck(String s) {
        return (s.length()==4 || s.length()==6);
    }

    // try catch 문을 활용한 풀이
    public boolean solution2(String s) {
      if(s.length()==4 || s.length()==6) {
          try{
              int x = Integer.parseInt(s);
              return true;
          } catch (NumberFormatException e) {
              return false;
          }
      }

        return false;
    }

}
