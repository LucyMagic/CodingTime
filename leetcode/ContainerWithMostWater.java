import java.util.*;
public class ContainerWithMostWater {
	//******************Solution 1***************//
	
	
	//******************Solution 2***************//
	public int maxArea2(int[] height) {
        int length = height.length;
        if(length == 0) return 0;
        
        Set<Integer> seen = new HashSet<Integer>();
        int maxArea = 0;
        for(int i = 0; i < length; i++){
            if(seen.contains(i)) continue;
            seen.add(i);
            for(int j = length -1; j>i; j--){
                int area = Math.min(height[i], height[j]) * (j-i);
                if(area > maxArea) maxArea = area;
                if(height[j]>=height[i]) break;
            }
        }
        return maxArea;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
