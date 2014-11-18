
public class BestTimeToBuySellStock {

	//*********Simpler version*************//
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length == 0) return 0;
        
        int lowest = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < length; i++){
        	if(prices[i]<lowest){
        		lowest = prices[i];
        	}else{
        		int newProfit = prices[i]-lowest;
                if(newProfit > maxProfit) maxProfit = newProfit;
        	}         
        }
        return maxProfit;
    }
	
  //**********************//
	public int maxProfit2(int[] prices) {
        if(prices.length==0) return 0;
        
        int maxProfit = 0;
        int minIndex=0, maxIndex=0;
        for(int i=1; i <prices.length; i++){
            if(prices[i]<prices[minIndex]){
                int newProfit = prices[maxIndex]-prices[minIndex];
                if(maxProfit<newProfit){
                    maxProfit=newProfit;
                }
                minIndex=i;
                maxIndex=i;
            }else if(prices[i]>prices[maxIndex]){
                maxIndex=i;                
            }
        }
        
        int newProfit = prices[maxIndex]-prices[minIndex];
        if(maxProfit<newProfit){
            maxProfit=newProfit;
        }
        return maxProfit;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
