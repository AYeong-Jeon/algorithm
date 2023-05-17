package Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/77484

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int a=0, b=0;
        for(int i=0; i<lottos.length; i++){
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    a +=1;
                }
            };
            if(lottos[i]==0){
                b +=1;
            };
        };
        b = a+b;
        //a가 최저, b가 최고 순위
        System.out.println("a : "+a+" b : "+b);

        if(b == lottos.length){
            answer[0] = 1;
        }else if(b == lottos.length-1){
            answer[0] = 2;
        }else if(b == lottos.length-2){
            answer[0] = 3;
        }else if(b == lottos.length-3){
            answer[0] = 4;
        }else if(b == lottos.length-4){
            answer[0] = 5;
        }else if(b == lottos.length-5){
            answer[0] = 6;
        }else{
            answer[0] = 6;
        };
        
        if(a == lottos.length){
            answer[1] = 1;
        }else if(a == lottos.length-1){
            answer[1] = 2;
        }else if(a == lottos.length-2){
            answer[1] = 3;
        }else if(a == lottos.length-3){
            answer[1] = 4;
        }else if(a == lottos.length-4){
            answer[1] = 5;
        }else if(a == lottos.length-5){
            answer[1] = 6;
        }else{
            answer[1] = 6;
        };
        return answer;
    };
};