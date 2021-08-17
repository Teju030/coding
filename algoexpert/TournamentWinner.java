import java.util.*;

class Program {

  public String tournamentWinner(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    // Write your code here.
		Map <String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < results.size(); i++)
		{
			String team = competitions.get(i).get(0);
			if(results.get(i) == 0)
			{
				team = competitions.get(i).get(1);
			}
			
			if(map.containsKey(team))
			{
				map.put(team, map.get(team) + 1);
			}
			else
			{
				map.put(team, 1);
			}
		}
		
		// get the highest scored team
		String winner = "";
		int max_val = 0;
		for(Map.Entry<String, Integer> entry: map.entrySet()){
		//	System.out.println(entry.getKey() + ":" + entry.getValue());
			if(entry.getValue() > max_val)
			{
				winner = entry.getKey();
				max_val = entry.getValue();
				//System.out.println("Winner:" + winner);
			}
		}
		
    return winner;
  }
}
