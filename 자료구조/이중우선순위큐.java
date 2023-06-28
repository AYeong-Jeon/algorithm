package 자료구조;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/42628

public class 이중우선순위큐 {
	public int[] solution1(String[] operations) {
		int[] answer = {0,0};
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i=0 ; i<operations.length ; i++) {
			String oper1 = operations[i].split(" ")[0];
			String oper2 = operations[i].split(" ")[1];
			if (oper1.equals("I")) {
				int num = Integer.parseInt(oper2);
				maxHeap.add(num);
				minHeap.add(num);
			} else {
				if (oper2.equals("-1")) {
					if (minHeap.size() < 1) {
						continue;
					}
					int minNum = minHeap.poll();
					maxHeap.remove(minNum);
				} else {
					if (maxHeap.size() < 1) {
						continue;
					}
					int maxNum = maxHeap.poll();
					minHeap.remove(maxNum);
				}
			}
		}

		if(maxHeap.size() > 0 && minHeap.size() > 0) {
			int maxNum = maxHeap.poll();
			int minNum = minHeap.poll();
			answer = new int[]{maxNum, minNum};
		}

		return answer;
	}

	/* solution1 의 문제점
	* 1. maxHeap.size() < 0 을 조건으로 걸었는데 빈 큐에 연산이 주어지면 무시하라는 조건이었으므로, 1로 바꿔주었다.
	* 2. max나 min에서 최댓값, 최솟값을 삭제하고 다른 힙에는 그 데이터가 남아있으니까 계속 출력이 돼서 remove로 지워줌.
	* 3. 만약 I로 시작했는데 숫자 자리에 1이 오면 최댓값이 삭제되는 문제가 생겨서 operations[i].split(" ")[1]을 보면 안됨.
	* */


	public int[] solution2(String[] operations) {
		int[] answer = new int[2];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		PriorityQueue<Integer> reverse_pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		for(int i=0; i<operations.length; i++) {
			String temp[] = operations[i].split(" ");
			switch(temp[0]) {
				case "I" :
					pq.add(Integer.parseInt(temp[1]));
					reverse_pq.add(Integer.parseInt(temp[1]));
					break;
				case "D" :
					if(pq.size() > 0) {
						if(Integer.parseInt(temp[1]) == 1) {
							int max = reverse_pq.poll();
							pq.remove(max);
						} else {
							int min = pq.poll();
							reverse_pq.remove(min);
						}
					}
					break;
			}
		}

		if(pq.size() > 0) {
			answer[0] = reverse_pq.poll();
			answer[1] = pq.poll();
		}

		return answer;
	}
}
