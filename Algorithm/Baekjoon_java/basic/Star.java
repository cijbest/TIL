package basic;

public class Star {

	public static void main(String[] args) {
		// º° Âï±â
		int n = 5;
		for (int i=0; i<n; i++) { 
            for (int j=n-i; j>1; j--) 
                System.out.print(" "); 
            for (int j=0; j<=i; j++ ) 
                System.out.print(" *"); 
            System.out.println(); 
        }
		for (int i=n-2; i>=0; i--) { 
            for (int j=n-i; j>1; j--) 
                System.out.print(" "); 
            for (int j=0; j<=i; j++ ) 
                System.out.print(" *"); 
            System.out.println(); 
        }
		
		System.out.println();
		for (int i=0; i<n; i++) {
		    for (int j=1; j<n-i; j++) {
		    	System.out.print(" ");
		    }
		    for (int j=0; j<i*2+1; j++) {
		    	System.out.print("*");
		    }
		    System.out.println();
		}
		for (int i=n-1; i>=0; i--) {
		    for (int j=1; j<n-i; j++) {
		    	System.out.print(" ");
		    }
		    for (int j=0; j<i*2+1; j++) {
		    	System.out.print("*");
		    }
		    System.out.println();
		}

	}

}
