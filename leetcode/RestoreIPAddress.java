import java.util.*;
public class RestoreIPAddress {
	//*******************Solution 1 I think this is better*************//
	ArrayList<String> result;
    int[] ip;
    public ArrayList<String> restoreIpAddresses(String s) {
         result = new ArrayList<String>();
         if(s.length() < 4 || s.length() > 12) return result;
         ip = new int[4];         
         getAllIP(s, 0, 0);
         return result;
    }
    
    private void getAllIP(String s, int strIndex, int arrayIndex){
        if(strIndex==s.length()){
            if(arrayIndex==ip.length) process(s);
            return;
        }
        if(strIndex>s.length() || arrayIndex>=ip.length) return;
        
        ip[arrayIndex] = strIndex;
        getAllIP(s, strIndex+1, arrayIndex+1);
        if(s.charAt(strIndex)!='0') 
        	getAllIP(s, strIndex+2, arrayIndex+1);
        if(isValidThreeDigit(s, strIndex)) 
        	getAllIP(s, strIndex+3, arrayIndex+1);
    }
    
    private boolean isValidThreeDigit(String s, int start){
        if(start+3>s.length()||s.charAt(start)=='0') return false;
        int num = Integer.parseInt(s.substring(start, start+3));
        if(num <= 255) return true;
        return false;
   }
    
    private void process(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ip.length-1; i++){
            sb.append(s.substring(ip[i], ip[i+1]));
            sb.append(".");
        }
        sb.append(s.substring(ip[3]));
        result.add(sb.toString());
    }
	
	
  //*******************Solution 1 may not be as good*************//
	String[] ips;
    public ArrayList<String> restoreIpAddresses2(String s) {
        ips = new String[4];
        result = new ArrayList<String>();
        enumerate(s, 0);
        return result;
    }
    
    private void enumerate(String rest, int count){
        int strLen = rest.length();
        if(count == 4 && strLen == 0){
            process();
            return;
        }        
        if(strLen > (4-count)*3 || strLen < (4-count)*1){
            return;
        }       
        for(int i = 1; i <= 3; i++){
            if(i > strLen) break;
            String partOfIp = rest.substring(0, i);
            if(isValid(partOfIp)){
                ips[count] = partOfIp;
                enumerate(rest.substring(i), count+1);
            }
        }
    }
    
    private boolean isValid(String partOfIp){
    	int len = partOfIp.length();
        if(len > 1 && partOfIp.charAt(0) == '0'){
            return false;
        }
        if(len == 3 && Integer.parseInt(partOfIp) > 255){
            return false;
        }
        return true;
    }
    
    private void process(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ips.length -1; i++){
            sb.append(ips[i] + ".");
        }
        sb.append(ips[ips.length -1]);
        result.add(new String(sb));
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
