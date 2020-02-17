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
	public void firstAlgorithm() {
		setPrimes(new boolean[top]);
		for (int i = 0; i < primes.length; i++) {
			int isPrime = 0;
			for(int j= i+1; j>=1 && isPrime<=2; j--) {
				if((i+1) % j == 0) {
					isPrime++;
				}
			}
			if(isPrime>2) {
				primes[i] = true;
			}
		}
	}
	
	/**
	 * Description: This algorithm uses the concept of sieve of Erastostenes
	 * Return: An array which contains numbers primes and not.
	 * Input: An array with natural numbers to "n" number.
	 */
	public void secondAlgorithm() {
		setPrimes(new boolean[top+1]);
		for (int i = 2; i < primes.length; i++) {
			primes[i] = true;
		}		
		for (int i = 2; i <= (int)Math.sqrt(primes.length-1); i++) {
			if(primes[i]==true) {
				for(int j=i; j <= (int)((primes.length-1)/(i));j++) {
					primes[i*j] = false;
				}
			}
		}
	}
	/**
	 * 
	 * 
	 * Rights Reserved: https://www.geeksforgeeks.org/sieve-of-atkin/
	 */
	public void thirdAlgorithm() {
		setPrimes(new boolean[top]);
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

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}


	public boolean[] getPrimes() {
		return primes;
	}


	public void setPrimes(boolean[] primes) {
		this.primes = primes;
	}
}
