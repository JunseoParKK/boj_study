package may.boj_15486;

import java.util.*;
import java.io.*;

public class boj_15486{
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(bf.readLine());
		
		int[] day = new int[N];
		int[] cost = new int[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer stk=new StringTokenizer(bf.readLine());
			day[i]=Integer.parseInt(stk.nextToken());
			cost[i]=Integer.parseInt(stk.nextToken());
		}
		
		int[] dp = new int[N+1];
		
		for(int i=0;i<N;i++) {
			if(i+day[i]<=N) {
				dp[i+day[i]]=Math.max(dp[i+day[i]], dp[i]+cost[i]);
			}
			dp[i+1]=Math.max(dp[i+1], dp[i]);
		}
		System.out.print(dp[N]);
	}
}