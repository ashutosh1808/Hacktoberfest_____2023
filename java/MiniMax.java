import java.io.*;
import java.util.*;

class MiniMax {
static int minimax(int depth, int nodeIndex, boolean isMax,int scores[], int h)
{
	if (depth == h)
		return scores[nodeIndex];
	if (isMax)
	return Math.max(minimax(depth+1, nodeIndex*2, false, scores, h),
			minimax(depth+1, nodeIndex*2 + 1, false, scores, h));
	else
		return Math.min(minimax(depth+1, nodeIndex*2, true, scores, h),
			minimax(depth+1, nodeIndex*2 + 1, true, scores, h));
}

static int log2(int n)
{
return (n==1)? 0 : 1 + log2(n/2);
}
	public static void main (String[] args) {
	Console c=System.console();
	int n=Integer.parseInt(c.readLine("enter n: "));	
	int[] scores=new int[n];
	for(int i=0;i<n;i++)
		scores[i]=Integer.parseInt(c.readLine("enter score "+(i+1)+": "));
	
	for(int i:scores)
		System.out.print(i+"\t");
	System.out.println();
	boolean maxOrMin=true;	//max
	String maxRes=c.readLine("press 0 for min, 1 for max: ");
	if(maxRes.equals("0"))
		maxOrMin=false;		//for min
	else if(maxRes.equals("1"))
		maxOrMin=true;
	int h=log2(n);	
	int res = minimax(0, 0,maxOrMin, scores, h);
	System.out.println( "The optimal value is : " +res);		
	}
}
