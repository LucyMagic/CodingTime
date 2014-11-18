
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length < 2) return 0;
        
        int[] oneTranProfit = new int[length];
        int lowest = prices[0];
        for(int i = 1; i < length; i++){
            oneTranProfit[i] = Math.max(oneTranProfit[i-1],(prices[i] - lowest));
            lowest = Math.min(lowest, prices[i]);
        }
        
        //move backwards to find the max
        int maxProfit = 0;
        int highest = prices[length-1];        
        for(int i = length-1; i>0; i--){
            int profit = highest - prices[i];
            int curMax = profit + oneTranProfit[i-1];
            if(curMax > maxProfit) maxProfit = curMax;
            highest = Math.max(highest, prices[i]);
        }
        //i=0
        int profit = highest - prices[0];
        if(profit > maxProfit) maxProfit = profit;
        return maxProfit;
    }
	
	//*****************Brute Force Approach**********************//
	private int maxProfit;
    public int maxProfitSlow(int[] prices) {
        int length = prices.length;
        if(length == 0) return 0;
        maxProfit = 0;
        computeMaxProfit(prices, 0, false, 0, 0, 0);
        return maxProfit;
    }
    
    private void computeMaxProfit(int[] prices, int index, boolean hasStock, int tradeCount, int stockPrice, int profit){
        if(tradeCount==2 || index>=prices.length){
            if(profit > maxProfit) maxProfit = profit;
            return;
        }        
        if(hasStock){
            //can sell or keep stock
            if(index==prices.length-1 || (index<prices.length-1&&prices[index+1]<prices[index]))
                computeMaxProfit(prices, index+1, !hasStock, tradeCount+1, 0, profit+prices[index]-stockPrice);
            computeMaxProfit(prices, index+1, hasStock, tradeCount, stockPrice, profit);        
        }else{
            //can buy or remain no stock
            if(index<prices.length-1&&prices[index+1]>prices[index])
                computeMaxProfit(prices, index+1, !hasStock, tradeCount, prices[index], profit);
            computeMaxProfit(prices, index+1, hasStock, tradeCount, stockPrice, profit);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimeToBuyAndSellStockIII stock = new BestTimeToBuyAndSellStockIII();
		int[] prices = new int[]{4,1,2};
		stock.maxProfit(prices);
	}

}
