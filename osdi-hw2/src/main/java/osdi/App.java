package osdi;

import osdi.primesolver.NumberRange;
import osdi.primesolver.PrimeNumberCounter;
import osdi.locks.Monitor;

/*
 * you may not use anything in java.util.concurrent.* you may only use locks from osdi.locks.*
 */
public class App 
{
    //you may not change the value of startValue or endValue
    private static final long startValue = 1000L;
    private static final long thousand = 1000L;
    private static final long million = thousand * thousand;
    private static final long endValue = 200L * million;

    private static final Monitor monitor = new Monitor();

    private final int counter = 0;

    /*
     * you may change this method. you must use NumberRange, PrimeNumberCounter, and reportNumberOfPrimes in here
     */
    public static void main( String[] args )
    {



            NumberRange range = new NumberRange(startValue, endValue);
            long numberOfPrimesInRange = new PrimeNumberCounter().countPrimeNumbers(range);
            reportNumberOfPrimes(numberOfPrimesInRange);

            // Monitor should be used
            // How to implement?  I'm at a loss
            // Monitor should be subscribed to by the counter variable object or w/e
            // Pulse every time there is an operation on the Bound Buffer (The buffer fills up and the
            // Sempahore makes the threads wait)
            // Pulse every time the buffer empties
            // That way we can track in multiples of 50 (hard coded) how many numbers have been counted!
    }

    /*
     * you may not change this method
     */
    private static void reportNumberOfPrimes(long count) {
        System.out.println("There are " + count + " primes in the range");
        System.out.flush();
    }
}
