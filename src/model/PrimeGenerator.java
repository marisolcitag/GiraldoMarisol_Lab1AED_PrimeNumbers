package model;

public class PrimeGenerator {
	
	
	/**
	 * The natural number which defines the primes number since 2 to "top"
	 */
	private int top;
	
	
	/**
	 * An array with 
	 */
	private boolean[] primes; 
	
	/**
	 * Description: This algorithm uses the concept of divisibility in each number of an array 
	 * Return: An array which contains numbers primes and not.
	 * Input: An array with natural numbers to "n" number.
	 */
	
	private int columns;
	
	private int rows;
	
	
	
	public void firstAlgorithm() {
		primes = new boolean[top];
		for (int i = 1; i < primes.length; i++) {
			primes[i] = true;
		}
		for (int i = 1; i < primes.length; i++) {
			int isPrime = 0;
			for(int j= i+1; j>=1 && isPrime<=2; j--) {
				if((i+1) % j == 0) {
					isPrime++;
				}
			}
			if(isPrime>2) {
				primes[i] = false;
			}
		}
		
		for (int i = 1; i < primes.length; i++) {
			System.out.println((i+1)+":"+ primes[i]);
		}
	}
	
	/**
	 * Description: This algorithm uses the concept of sieve of Erastostenes
	 * Return: An array which contains numbers primes and not.
	 * Input: An array with natural numbers to "n" number.
	 */
	public void secondAlgorithm() {
		primes = new boolean[top];
		for (int i = 1; i < primes.length; i++) {
			primes[i] = true;
		}
		
		for (int i = 1; i <= (int)Math.sqrt(top); i++) {
			if(primes[i]) {
				for(int j=(i+1); j <= (int)((top)/(i+1));j++) {
					primes[((i+1)*(j))-1] = false;
				}
			}
		}
		for (int i = 1; i < primes.length; i++) {
			System.out.println((i+1)+":"+ primes[i]);
		}
	}
	/**
	 * 
	 * 
	 * Rights Reserved: https://www.geeksforgeeks.org/sieve-of-atkin/
	 */
	public void thirdAlgorithm() {
		
		primes = new boolean[top+1];
		
		if(top==2) {
			primes[1] = true;
		}else if(top==3) {
			primes[1] = true;
			primes[2] = true;
		}else {
			
			primes[1] = true;
			primes[2] = true;
			
			for(int x=1; x*x < top; x++ ) {
				for(int y=1; y*y < top; y++ ) {
					
					int n = (4 * x * x) + (y * y);
					if(n <= top && ( n% 12 == 1 || n% 12 == 5)) {
						primes[n] ^= true;
					}
					
					n = (3 * x * x) + (y * y);
					if(n <= top && n % 12 == 7) {
						primes[n] ^= true;
					}
					
					n = (3 * x * x) - (y * y);
					if(n <= top && n % 12 == 11 && x > y) {
						primes[n] ^= true;
					}
				}
			}
			
			
			for(int z=5; z*z < top; z++) {
				if(primes[z]) {
					for(int m= z*z; m < top; m+= z*z) {
						primes[m] = false;
					}
				}
			}
			
			
		}
	}
	
	

	public int getTop() {
		return top;
	}
	
	public void setTop(int top) {
		this.top = top;
		
		int x=0;
		int y=0;
		int difference = top;
		for (int i = 1; i <= top-1; i++) {
			for (int j = 1; j <= top-1; j++) {		
				if(i*j==(top-1)) {
					if((i-j)<difference) {
						x=i;
						y=j;
						difference = Math.abs(i-j);
					}
				}
			}
		}
		columns = y;
		rows = x;
	}


	public boolean[] getPrimes() {
		return primes;
	}


	public void setPrimes(boolean[] primes) {
		this.primes = primes;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
}
