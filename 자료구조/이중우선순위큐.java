package 자료구조;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/49993

public class 이중우선순위큐 {
	public int[] solution1(String[] operations) {
		int[] answer = {};
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i=0 ; i<operations.length ; i++) {
			String oper = operations[i].split(" ")[1];
			if (oper.equals("1")) {
				if (maxHeap.size() < 0) {
					continue;
				}
				maxHeap.poll();
			} else if (oper.equals("-1")) {
				if (minHeap.size() < 0) {
					continue;
				}
				minHeap.poll();
			} else {
				int num = Integer.parseInt(oper);
				maxHeap.add(num);
				minHeap.add(num);
			}
		}

		if(maxHeap != null && minHeap != null) {
			int maxNum = maxHeap.poll();
			int minNum = minHeap.poll();
			answer = new int[]{maxNum, minNum};
		} else {
			answer = new int[]{0, 0};
		}

		return answer;
	}


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

		if(pq.size() >= 2) {
			answer[0] = reverse_pq.poll();
			answer[1] = pq.poll();
		}

		return answer;
	}
}
