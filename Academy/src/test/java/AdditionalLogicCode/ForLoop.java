package AdditionalLogicCode;

public class ForLoop {

	public static void main(String[] args) {
		
//  print 1             similar code   1                     *
//	      1 2                          2 3                   * *
//	      1 2 3                        4 5 6                 * * *
//	      1 2 3 4                      7 8 9 10              * * * *
		
		int k=1;    //for incremental numbers
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=i; j++) {
				
				System.out.print(k);
				k++;
				System.out.print("\t");
			}
			
			System.out.println();
		}

	}

}
