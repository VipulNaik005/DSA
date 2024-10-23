import java.util.*;
public class Knapsack01 {
    static int recursion(int[] val,int[] wt,int totalW,int i){
        if(totalW <= 0 || i == -1){
            return 0;
        }
        if(wt[i] <= totalW){
            int pick = val[i] + recursion(val,wt,totalW-wt[i],i-1);
            int left = recursion(val,wt,totalW,i-1);
            return Math.max(pick,left);
        }
        else{
            return recursion(val,wt,totalW,i-1);
        }
    }
    static int memoization(int[] val,int[] wt,int totalW,int i,int[][] dp){
        if(i == 0 || totalW == 0) return 0;
        if(dp[i][totalW] != -1) return dp[i][totalW];
        if(wt[i-1] <= totalW){
            int pick = val[i-1] + memoization(val,wt,totalW-wt[i-1],i-1,dp);
            int left = memoization(val,wt,totalW-wt[i-1],i-1,dp);
            dp[i][totalW] = Math.max(left,pick);
        }else{
            dp[i][totalW] = memoization(val,wt,totalW-wt[i-1],i-1,dp);
        }
        return dp[i][totalW];
    }
    static int tabulation(int[] val,int[] wt,int totalW,int[][] dp){
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(wt[i-1] <= j){
                    int pick = val[i-1] + dp[i-1][j-wt[i-1]];
                    int left = dp[i-1][j];
                    dp[i][j] = Math.max(pick,left);
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[val.length][totalW];
    }
    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};
        int w = 7;
        int[][] dp = new int[val.length+1][w+1];
        for(int i = 0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i = 0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int i = 0;i<dp[0].length;i++){
            dp[0][i] = 0;
        }
        System.out.println(tabulation(val,wt,w,dp));
    }
}