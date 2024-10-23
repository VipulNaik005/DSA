import java.util.*;
public class MinNumberJumps {
    static int recursion(int[] arr,int l,int h){
        if(l == h) return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 1;l+i<=h && i<=arr[l];i++){
            ans = Math.min(1+recursion(arr,l+i,h),ans);
        }
        return ans;
    }
    static int tabulation(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for(int i = 1;i<n;i++){
            for(int j = 0;j<i;j++){
                if(i <= j+arr[j])
                dp[i] = Math.min(dp[i],dp[j]+1);
            }
        }
        return dp[n-1];
    }
    static int greedy(int[] arr){
        int n = arr.length;
        int l=0;
        int r = 0;
        int farthest = 0;
        int jumps = 0;
        while(r < n-1){
            farthest = 0;
            for(int i = l;i<=r;i++) {
                int curr = i + arr[i];
                if(curr > farthest){
                    farthest = curr;
                }
            }
            l = r+1;
            r = farthest;
            jumps = jumps+1;
        }
        return jumps;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(recursion(arr,0,arr.length-1));
        System.out.println(tabulation(arr));
        System.out.println(greedy(arr));
    }
}
