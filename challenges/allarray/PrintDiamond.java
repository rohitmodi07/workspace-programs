package challenges.allarray;

public class PrintDiamond {

	public static void main(String[] args) {
		int n = 5;
		for(int i = 0; i < 2*n-1; i++) {
			int p = Math.abs((n-i-1))%n;
			for(int j=0; j < p; j++) {
				System.out.print(" ");
			}
			for(int k=0; k < n-p; k++) {
				System.out.print("* ");
			}
			System.out.print("\n");
		}

	}

}
