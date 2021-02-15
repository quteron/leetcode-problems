public int maxProfit(int[] prices, int fee) {
    int profit = 0;
    int balance = -prices[0];

    for (int i=1; i<prices.length; i++) {
        profit = Math.max(profit, prices[i] + balance - fee);
        balance = Math.max(balance, profit - prices[i]);
    }

    return profit;
}
