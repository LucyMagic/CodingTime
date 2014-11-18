import java.util.*;
public class ZigZagConversion {

	//***************Solution 1 Good*******************//
    public String convert(String s, int nRows) {
        if(s==null || s.length()==0 || nRows<=1) return s;
        
        StringBuilder sb = new StringBuilder();
        int distance = nRows + nRows - 2;
        for(int row = 0; row < nRows; row++){
            int startIndex = row;
            while(startIndex<s.length()){
                sb.append(s.charAt(startIndex));
                startIndex += distance;
                if(row!=0 && row!=nRows-1 && (startIndex-row-row)<s.length()){
                    sb.append(s.charAt(startIndex-row-row));
                }
            }
        }
        return sb.toString();
    }
	
    //***************Solution 1 not as Good*******************//
	public String convert2(String s, int nRows) {
        int length = s.length();
        if(nRows < 2 || length<=nRows) return s;
        
        ArrayList<StringBuilder> strs = new ArrayList<StringBuilder>();
        for(int i = 0; i < nRows; i++){
            strs.add(new StringBuilder());
        }        
        int row = 0;
        boolean forward = true;
        for(int i = 0; i < length; i++){
            char ch = s.charAt(i);
            strs.get(row).append(ch);
            if(forward){
                if(row==nRows-1){
                    forward = !forward;
                    row--;
                }else{
                    row++;
                }
            }else{
                if(row==0){
                    forward = !forward;
                    row++;
                }else{
                    row--;
                }
            }
        }                
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < nRows; i++){
            result.append(strs.get(i));
        }
        return new String(result);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
