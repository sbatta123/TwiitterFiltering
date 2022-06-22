import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

// hashtags are the nodes
// weighted wedge between two nodes if they are contained in the same tweet
// weight between hashtag a and b is the number of tweets that contain both a and b
// for a hashtag, look for edges connecting it to another node with highest edge weight
// get first three or five hashtags and recommend it to the user

public class MainMethod {
	
	public static void main(String[] args) {
		// vertices are the hashtags in a linkedList 
        TweetSearch t = new TweetSearch();
        System.out.println("Getting hashtag map.");
        HashMap<String, LinkedList<Tweet>> map = t.getHashtagMap();
        System.out.println("Getting all Tweets");
        LinkedList<Tweet> tweeeets = t.allTweets;
        int vertices = map.size(); // length of the linkedList
        WeightedGraph graph = new WeightedGraph(vertices);

        System.out.println("Populating graph.");
        graph.populateHashtags();
//<<<<<<< HEAD
        LinkedList<String> sss = new LinkedList<String>();
        for (String s : map.keySet()) {
        	sss.add(s);
        }
        for (int i = 0; i < sss.size() - 1; i++) {
        	for (int j = i + 1; j < sss.size(); j++) {
        		graph.addEdge(sss.get(i), sss.get(j));
        	
        	}
//=======
        
        System.out.println("Adding edges.");
        for (Tweet tweet : tweeeets) {
        	graph.addEdge(tweet);
//>>>>>>> f1c9f6434a468cdddce4a16bc5828d01900d0ad8
        }
        
        System.out.println("Getting recommendations.");
        // this will get three hashtags that are most related to hashtag "covid19"
        LinkedList<String> recs = graph.getRecommendations("covid", 3);
        
        System.out.println("RECOMMENDATIONS FOR ");
        for (String rec : recs) {
        	System.out.println(rec);
        }
        System.out.println("Total tweets: " + tweeeets.size());
        
        try {
			graph.printGraph();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
}
