int maxProfit(int* prices, int pricesSize) {
    int max = 0;
    int min = prices[0];
    for(int i = 1; i < pricesSize; i += 1){
            if(prices[i] - min > max){
                max = prices[i] - min;
            }
            else if(prices[i] < min){
                min = prices[i];
            }
    }
    return max;
}
