package 자료구조.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

//https://school.programmers.co.kr/learn/courses/30/lessons/42626

public class 더맵게H {
	public int solution1(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> heap = new PriorityQueue<>();
		//scoville 배열 길이만큼 heap에 넣어준다.
		for (int i=0 ; i<scoville.length ; i++) {
			heap.add(scoville[i]);
		}

		//스코빌 지수가 K 이상이면 들어갈 필요가 없음.
		while(heap.peek() < K){
			//모든 음식을 k 이상으로 만들 수 없을 경우 -1 리턴
			if(heap.size() < 2) {
				return -1;
			}
			//새로운 음식을 만드니까 기존 값 삭제
			int f1 = heap.poll();
			int f2 = heap.poll();

			int newFood = f1 + (f2 * 2);
			heap.add(newFood);
			//더해진 횟수 리턴
			answer++;
		}

		return answer;
	}

	//다른 사람 풀이
	public int solution2(int[] scoville, int K) {
		PriorityQueue<Integer> q = new PriorityQueue<>();

		for(int i = 0; i < scoville.length; i++)
			q.add(scoville[i]);

		int count = 0;
		while(q.size() > 1 && q.peek() < K){
			int weakHot = q.poll();
			int secondWeakHot = q.poll();

			int mixHot = weakHot + (secondWeakHot * 2);
			q.add(mixHot);
			count++;
		}

		if(q.size() <= 1 && q.peek() < K)
			count = -1;

		return count;
	}

	//더 맵게라는 문제는 최소힙 문제인데 만약 최대힙을 구할 경우 어떻게 풀 수 있는지 scoville 지수가 K 이상인 수를 구해보았다.
	public int[] solution3(int[] scoville, int K) {
		int[] answer = null;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		//maxHeap에 scoville 배열을 넣어주기
		for (int i=0 ; i<scoville.length ; i++) {
			maxHeap.add(scoville[i]);
		}

		//maxHeap에서 스코빌 지수가 K 이상인 수 리턴, 아니면 -1
		for(int i=0 ; i<maxHeap.size() ; i++) {
			if(maxHeap.peek() > K) {
				answer[i] = maxHeap.poll();
			} else {
				answer[0] = -1;
				return answer;
			}
		}
		
		return answer;
	}
}
