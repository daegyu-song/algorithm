package silver;

import java.io.*;
import java.util.*;

public class B_2531_회전초밥 {
	
	static int N, d, k, c, max = Integer.MIN_VALUE;
	static List<Integer> list, arr;
	static Set<Integer> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		// 초기
		list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			list.add(arr.get(i));
		}
		set = new HashSet<>(list);
		set.add(c);
		max = Math.max(max, set.size());
		
		for (int i = 0; i < N; i++) {
			list.remove(arr.get(i));
			list.add(arr.get((i + k) % N));
			set = new HashSet<>(list);
			set.add(c);
			max = Math.max(max, set.size());
		}
		
		System.out.println(max);
	}
}
