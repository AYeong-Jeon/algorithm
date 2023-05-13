package Level1;
import java.util.*;


public class 달리기경주 {
	public String[] solution(String[] players, String[] callings) {
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < players.length; i++) {
			map.put(players[i], i);
		}
		for (String c : callings) {
			int num = map.get(c);
			map.put(players[num - 1], num);
			map.put(c, num - 1);
			players[num] = players[num - 1];
			players[num - 1] = c;
		}

		return players;
	}
}
