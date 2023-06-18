import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
//		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			int[] s = fs.readArray(n);
			int freq[] = new int[101];
			Arrays.fill(freq, 0);
			for (int x : s) {
				freq[x]++;
			}
			int single = 0, fix = 0;
			for (int i = 1; i <= 100; i++) {
				if (freq[i] == 1) {
					single++;
				} else if (freq[i] >= 3) {
					fix++;
				}
			}
			if (single % 2 == 1 && fix == 0) {
				System.out.println("NO");
				continue;
			}
			int a = single / 2;
			int b = a;
			if (single % 2 == 1) {
				a++;
			}
			System.out.println("YES");
			for (int i = 0; i < n; i++) {
				if (freq[s[i]] == 1) {
					if (a > 0) {
						System.out.print("A");
						a--;
					} else {
						System.out.print("B");
						b--;
					}
				} else if (freq[s[i]] >= 3) {
					if (single % 2 == 1 && fix > 0) {
						System.out.print("B");
						fix = 0;
					} else {
						System.out.print("A");
					}
				} else {
					System.out.print("A");
				}
			}
			System.out.println();
		}
		out.close();
	}
	
	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
