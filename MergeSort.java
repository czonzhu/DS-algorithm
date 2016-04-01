import java.util.*;

public class MergeSort
{
	public static void main(String[] args)
	{
		int[] a = {2, 6, 3, 5, 1};
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void mergeSort(int [ ] a)
	{
		mergeSort(a,  0,  a.length - 1);
	}


	private static void mergeSort(int [ ] a, int start, int end)
	{
		if(end - start < 1) return;
		int mid = start + (end - start) / 2;
		mergeSort(a, start, mid);
		mergeSort(a, mid + 1, end);
		int t = mid + 1;
		int[] cache = new int[end - start + 1];
		for(int i = start, r = 0; i <= mid; i++, r++){
			while(t <= end && a[t] < a[i]) cache[r++] = a[t++];
			cache[r] = a[i];
		}
		System.arraycopy(cache, 0, a, start, t - start);
	}



 }