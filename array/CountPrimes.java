package array;

public class CountPrimes {

    /*Description: Count the number of prime numbers LESS THAN a non-negative number, n. */

    /*
    * Initial Approach: O(N sqrt (N))
    * Where N is the non-negative number
    *
    * Loop through numbers less than the given non-negative number: O(N)
    * check each number if it is prime: O(sqrt (N))
    *
    * Hint: if n is divisible by a number greater than its square root, then n is not prime.
    *
    * Space Complexity: O(1)
    * */

    /*
    * Optimal Solution: O(N log (log N)) - Sieve of Eratosthenes
    *
    * Loop through numbers less than the given non-negative number: O(N)
    * Mark each non prime numbers: O(log (log N))
    *
    * Space Complexity: O(N)
    * */

    public static void main(String[] args) {
        CountPrimes solution = new CountPrimes();
        int initialApproachCount = solution.initialApproach(10);
        int optimalApproachCount = solution.optimalApproach(10);
        System.out.println(initialApproachCount + " == " + optimalApproachCount);
    }

    private int initialApproach(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }

        return count;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private int optimalApproach(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) { // is prime
                notPrimes[i] = false;
                count++;

                for (int j = 2; j * i < n; j++) {
                    notPrimes[j * i] = true;
                }
            }
        }

        return count;
    }
}
