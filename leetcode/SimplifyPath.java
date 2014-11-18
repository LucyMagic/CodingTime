import java.util.*;
public class SimplifyPath {

	public String simplifyPath(String path) {
        ArrayList<String> dirs = new ArrayList<String>();
        int start = 0;
        while(start<path.length()){
            int end = findFirstSlash(path, start);
            if(start==end){
                start++;
            }else{
                String dir = path.substring(start, end);
                process(dirs, dir);
                start = end;
            }
        }
        return getPath(dirs);
    }
    
    private void process(ArrayList<String> dirs, String dir){
        if(dir.length()==0||dir.equals(".")){
            return;
        }else if(dir.equals("..")){
            if(!dirs.isEmpty()) 
                dirs.remove(dirs.size()-1);
        }else{
            dirs.add(dir);
        }
    }
    
    private String getPath(ArrayList<String> dirs){
        StringBuilder str = new StringBuilder();
        str.append("/");
        for(int i=0; i<dirs.size(); i++){
            str.append(dirs.get(i));
            if(i!=dirs.size()-1)
                str.append("/");
        }
        return new String(str);
    }
    
    private int findFirstSlash(String path, int start){
        assert start>=0;
        while(start<path.length()&&path.charAt(start)!='/'){
            start++;
        }
        return start;
    }
    
    
    
    //***************
    public String simplifyPath1(String path) {
        if(path==null||path.length()==0) return path;
        
        ArrayList<String> partsOfPath = new ArrayList<String>();
        int start = 0;
        while(true){
            while(start<path.length()&&path.charAt(start)=='/') start++;
            int end = start;
            while(end<path.length()&&path.charAt(end)!='/') end++;
            if(start>=path.length()) break;
            String part = path.substring(start, end);
            process(part, partsOfPath);
            start = end+1;
        }
        StringBuilder sb = new StringBuilder();
        for(String s: partsOfPath){
            sb.append('/');
            sb.append(s);
        }
        if(sb.length()==0) sb.append('/');
        return sb.toString();
    }
    private void process(String s, ArrayList<String> parts){
        if(s.equals("..")){
            if(parts.size()!=0) parts.remove(parts.size()-1);
        } 
        else if(s.equals(".")){
            
        }else{
            parts.add(s);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplifyPath sp = new SimplifyPath();
		String s = sp.simplifyPath1("/../");
		System.out.println(s);
	}

}
