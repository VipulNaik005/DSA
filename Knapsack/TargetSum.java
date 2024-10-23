import java.util.*;
public class TargetSum {
    static boolean recursion(int[] nums,int targetSum,int i){
        if(targetSum == 0) return true;
        if(i == 0) return false;
        int current = nums[i-1];
        if(current <= targetSum){
            boolean pick = recursion(nums,targetSum-current,i-1);
            boolean left = recursion(nums,targetSum,i-1);
            return pick || left;
        }else {
            return recursion(nums,targetSum,i-1);
        }
    }
    static boolean tabulation(int[] nums,int targetSum){
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][targetSum+1];
        for(int i = 0;i<targetSum+1;i++){
            dp[0][i] = false;
        }
        for(int i = 0;i<n+1;i++){
            dp[i][0] = true;
        }
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<=targetSum;j++){
                int current = nums[i-1];
                if(current <= j){
                    dp[i][j] = dp[i-1][j-current] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][targetSum];
    }
    public static void main(String[] args) {
        int[] nums = {4,2,7,1,3};
        int targetSum = 20;
        System.out.println(recursion(nums,targetSum,nums.length));
        System.out.println(tabulation(nums,targetSum));
    }
}
