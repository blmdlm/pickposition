import java.util.Arrays;
import java.util.List;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-6-5 下午11:39:42
 * 工具类：实现找邮局算法
 */
public class Tool {
	public static  int findThePoint(List<Integer> arr){
		
		int n=arr.size();
		int a[]=new int[n];
		for (int i = 0; i < arr.size(); i++) {
			a[i]=arr.get(i);
		}
		Arrays.sort(a);
		if (n%2==0) {//偶数，中间两点的随机点
			int x=n/2-1;
			int y=x+1;
			return  (int)((a[y]-a[x])*Math.random())+a[x];     
			
		}else{//奇数选中间的点
			return a[n/2];
		}
}
}