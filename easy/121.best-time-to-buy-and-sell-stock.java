public int maxProfit(int[] prices) {
    int profit = 0;
    int buyAt = -1;

    for (int price : prices) {
        if (buyAt == -1) {
            buyAt = price;
        } else {
            profit = Math.max(profit, price - buyAt);
            buyAt = Math.min(buyAt, price);
        }
    }

    return profit;
}
