import java.util.*;
public class UnboundedKnapsack {
    static int tabulation(int[] val,int[] wt,int w){
        int n = val.length;
        int[][] dp = new int[n+1][w+1];
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<w+1;j++){
                int curVal = val[i-1];
                int curWt = wt[i-1];
                if(curWt <= j){
                    dp[i][j] = Math.max(curVal+dp[i][j-curWt],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,2};
        int w = 7;
        System.out.println(tabulation(val,wt,w));
    }
}
