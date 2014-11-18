import java.util.*;
public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> justified = new ArrayList<String>();
        if(words==null || words.length==0 || L<=0){
            justified.add("");
            return justified;
        }
                
        int curLen = words[0].length()+1, start = 0;
        for(int i = 1; i < words.length; i++){
            int wLen = words[i].length();
            if(curLen+wLen > L){
                justified.add(justifyOneLine(words, start, i-1, L));                
                start = i;
                curLen = words[i].length()+1;
            }else{
                curLen += wLen+1;
            }
        }
        //process last line        
        justified.add(justifyLastLine(words, start, L));        
        return justified;
	}
	    
    private String justifyOneLine(String[] words, int start, int end, int L){
        StringBuilder justified = new StringBuilder();
        //there is only one word
        if(start == end){
            justified.append(words[start]);
            for(int i = L-words[start].length(); i>0; i--){
                justified.append(" ");
            }
            return justified.toString();
        }
                
        int wordsLen = 0;
        for(int i = start; i <= end; i++){
            wordsLen += words[i].length();
        }        
        int numSpaces = L - wordsLen;
        int slots = end - start;
        int avgSpaceEachSlot = numSpaces/slots;
        int extraSpaceSlots = numSpaces%slots;
        String spaces = "";
        for(int i = 0; i < avgSpaceEachSlot; i++){
            spaces += " ";
        }        
        for(int i = start; i < end; i++){
            justified.append(words[i]).append(spaces);            
            if(extraSpaceSlots>0){
                justified.append(" ");
                extraSpaceSlots--;
            }
        }
        justified.append(words[end]);       
        return justified.toString();
    }
	    
    private String justifyLastLine(String[] words, int start, int L){
        String lastline = ""; int wordsLen = 0;
        for(int i = start; i < words.length; i++){
            wordsLen += words[i].length()+1;
            if(i==words.length-1)   lastline += words[i];
            else                    lastline += words[i] + " ";
        }
        wordsLen--;//take off the space off the last word
        for(int i = 0; i < L-wordsLen; i++){
        	lastline+=" ";
        }
        return lastline;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextJustification tj = new TextJustification();
		String[] words = {""};
		int l = 2;
		ArrayList<String> result = tj.fullJustify(words, l);
		for(String tmp : result){
			System.out.print(tmp);
			System.out.print("-----");
		}
		System.out.print("-----");
	}

}
