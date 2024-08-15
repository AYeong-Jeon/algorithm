package Level1;

import java.util.Arrays;
import java.util.Collections;

public class 문자열_내림차순으로_배치하기 {
    public String solution(String s) {
        String[] list = s.split("");
        Arrays.sort(list, Collections.reverseOrder());

        return String.join("",list);
    }
}
