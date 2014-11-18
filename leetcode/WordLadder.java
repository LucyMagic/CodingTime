import java.util.*;

public class WordLadder {

	//*******************Solution 1*****************//
	/* Store distance separately
	 * and use distance to check "visited" of the node
	 */
	public int ladderLength(String start, String end, HashSet<String> dict) {
    	if(start.equals(end))
			return 1;
		ArrayDeque<String> wordQueue = new ArrayDeque<String>();
        wordQueue.offer(start);
        
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        distance.put(start, 1);
        
        while(!wordQueue.isEmpty()){
        	String parent = wordQueue.poll();
        	int dist = distance.get(parent);
        	
        	ArrayList<String> words = getOneCharDiffWords(parent, dict);
        	for(String word : words){
        		if(word.equals(end)){ 
            		return dist+1;
        		}
        		if(!distance.containsKey(word)){ 
        			distance.put(word, dist+1);
        			wordQueue.offer(word);
        		}
        	}        	
        }		
		return 0;
	}	
    private ArrayList<String> getOneCharDiffWords(String parent, HashSet<String> dict){
    	ArrayList<String> words = new ArrayList<String>();
		char[] wordArray = parent.toCharArray();
		for(int i = 0; i < parent.length(); i++){
			char cur = wordArray[i];
    		for(char c = 'a'; c <= 'z'; c++){    			
    			if(c == cur) continue;
    			wordArray[i] = c;
    			String newWord = new String(wordArray);
                if(dict.contains(newWord))
    			    words.add(newWord);
    		}
    		wordArray[i] = cur;//clean up
    	}		
		return words;
	}
    
    //*********************Solution 2***********************//
    /* Using 2 queues to traverse the tree by level order */
    private Set<String> wordsOnPath;
    private Set<String> dictionary;
    public int ladderLengthBFSByLevel(String start, String end, HashSet<String> dict) {
        wordsOnPath = new HashSet<String>();
        dictionary = dict;
        int length = 1;

        ArrayDeque<String> parents = new ArrayDeque<String>();
        ArrayDeque<String> children = new ArrayDeque<String>();
        parents.offer(start);
        while(!parents.isEmpty()){
            String currentWord = parents.poll();
            if(currentWord.equals(end)) return length;
            processWord(currentWord, children);
            
            if(parents.isEmpty()){
                length++;
                parents = children;
                children = new ArrayDeque<String>();
            }
        }
        return 0;//transformation not found
    }    
    private void processWord(String word, ArrayDeque<String> queue){
        char[] wordArray = word.toCharArray();
        for(int i = 0; i < word.length(); i++){
			char cur = wordArray[i];
    		for(char c = 'a'; c <= 'z'; c++){    			
    			if(c == cur) continue;
    			wordArray[i] = c;
    			String newWord = new String(wordArray);
                if(dictionary.contains(newWord) && !wordsOnPath.contains(newWord)){
                    queue.offer(newWord);
                    wordsOnPath.add(newWord);
                }              
            }
            wordArray[i] = cur;
        }
    }

    
    //*********************Solution 3***********************//
    /* Using 2 counters and one queue to traverse the tree by level order */
    public int ladderLength1(String start, String end, HashSet<String> dict) {
        if(start.equals(end)) return 1;
        wordsOnPath = new HashSet<String>();
        dictionary = dict;
        int length = 1;

        ArrayDeque<String> queue = new ArrayDeque<String>();
        queue.offer(start);
        int currentCnt = 1, nextCnt = 0;
        while(currentCnt != 0){
            String currentWord = queue.poll();
            currentCnt--;
            ArrayList<String> words = processWord(currentWord);
            for(String word: words){
                if(word.equals(end)) return length+1;
                queue.offer(word);
                nextCnt++;
            }
            
            if(currentCnt == 0){
                length++;
                currentCnt = nextCnt;
                nextCnt = 0;
            }
        }

        return 0;
    }    
    private ArrayList<String> processWord(String word){
        ArrayList<String> result = new ArrayList<String>();
        char[] wordArray = word.toCharArray();
    	for(int i = 0; i < word.length(); i++){
			char cur = wordArray[i];
    		for(char c = 'a'; c <= 'z'; c++){    			
    			if(c == cur) continue;
    			wordArray[i] = c;
    			String newWord = new String(wordArray);
                if(dictionary.contains(newWord) && !wordsOnPath.contains(newWord)){
                    result.add(newWord);
                    wordsOnPath.add(newWord);
                }              
            }
            wordArray[i] = cur;
        }
        return result;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("c"); //"hot","dot","dog","lot","log"
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		WordLadder wl = new WordLadder();
		int dist = wl.ladderLength1("hit", "cog", dict);
		System.out.println(dist);
	}

}
