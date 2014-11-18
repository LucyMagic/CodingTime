
public class BestTimeToBuyAndSellStockII {
	
	//**************Solution 1******************//
    public int maxProfit1(int[] prices) {
        if(prices==null || prices.length==0) return 0;        
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            int diff = prices[i]-prices[i-1];
            if(diff>0) profit += diff;
        }
        return profit;
    }
	
    //**************Solution 2******************//
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        boolean hasStock = false;
        int price = -1;
        int maxProfit = 0;
                
        for(int i = 0; i < length-1; i++){
            if(!hasStock && prices[i] < prices[i+1]){
                hasStock = true;
                price = prices[i];
            }else if(hasStock && prices[i] > prices[i+1]){
                hasStock = false;
                maxProfit += prices[i] - price;
                price = -1;
            }
        }        
        if(hasStock) maxProfit += prices[length-1] - price;
        return maxProfit;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
