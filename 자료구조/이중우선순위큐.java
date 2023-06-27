package 자료구조;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/49993

public class 이중우선순위큐 {
	public int[] solution1(String[] operations) {
		int[] answer = {};
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		List<Integer> list = new ArrayList<>();

		for (int i=0 ; i<operations.length ; i++) {
			String oper = operations[i].split(" ")[1];
			if (oper.equals("1")) {
				if (maxHeap.size() < 0) {
					continue;
				}
				int maxNum = maxHeap.poll();
				list.remove(Integer.valueOf(maxNum));
			} else if (oper.equals("-1")) {
				if (minHeap.size() < 0) {
					continue;
				}
				int minNum = minHeap.poll();
				list.remove(Integer.valueOf(minNum));
			} else {
				int num = Integer.parseInt(oper);
				list.add(num);
				maxHeap.add(num);
				minHeap.add(num);
			}
		}

		for (int i=0 ; i<list.size() ; i++){
			if(list != null) answer[i] = list.get(i);
		}

		return answer;
	}

	public int[] solution2(String[] operations) {
		int[] answer = {};
		return answer;
	}
}
