package AdditionalLogicCode;

public class patternPrintingSecondLogic {

	public static void main(String[] args) {
		
//		print 	9 8 7 6       1 2 3 4     * * * *
//		      	5 4 3         1 2 3       * * *
//            	2 1           1 2         * *
//            	0             1           *
		
		
		int k =9;
		for(int i=0; i <=4 ; i++) {
			
			for(int j=1; j<= 4-i; j++) {
				
				System.out.print(k);
				k--;
				System.out.print("\t");
			}
			
			System.out.println();
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
