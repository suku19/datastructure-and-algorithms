package com.suku.array;

public class Solutions {

    public static int findCost(int[] cost, String input){
        int result = 0;
        if(cost.length == 0 && input.length() == 0)
            return result;

        for(int i = 0; i < input.length() - 1 ; i++) {
            if(input.charAt(i) == input.charAt(i+1)){
                if(cost[i] > cost[i+1]) {
                    result+=cost[i+1];
                    int temp = cost[i];
                    cost[i] = cost[i+1];
                    cost[i+1] = temp;
                } else {
                    result+=cost[i];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int cost [] = {1,2,1,2,1,2};
        String input = "abccbd";

        System.out.println(findCost(cost,input));
    }
}
