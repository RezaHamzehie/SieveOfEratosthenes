package hamza;

import acm.program.ConsoleProgram;

import java.util.ArrayList;

/**
 * File:Sieve.java
 * -------------------
 * does the sieve of Eratosthenes to find the primes inside
 * an array of integers
 */
public class Sieve extends ConsoleProgram {

    /**
     * the main entry point into to program
     *
     * @param args the passed string arguments
     */
    public static void main(String[] args) {

        //initialization of the class for acm
        new Sieve().start(args);
    }

    /**
     * the main entry point for the acm package
     */
    public void run() {

        println("This program finds the primes inside a set of arrays!");
        int upperLimit = readInt("enter the upper limit for the array: ");
        ArrayList<Integer> theArray = createAnArray(upperLimit);
        ArrayList<Integer> primes = getPrimes(theArray);
        printArray(primes);
    }

    /**
     * picks up the prime numbers inside an array
     *
     * @param arrayOfNumbers the passed array
     * @return the array of chosen prime numbers
     */
    private ArrayList<Integer> getPrimes(ArrayList<Integer> arrayOfNumbers) {

        //all needed locals
        ArrayList<Integer> composites = new ArrayList<>();
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 0; i < arrayOfNumbers.size(); i++) {
            for (int j = 0; j < arrayOfNumbers.size(); j++) {
                if (i < j && arrayOfNumbers.get(j) % arrayOfNumbers.get(i) == 0) {
                    composites.add(arrayOfNumbers.get(j));
                }
            }
        }

        for (int element : arrayOfNumbers) {
            if (!composites.contains(element)) {
                if (!primes.contains(element)) {
                    primes.add(element);
                }
            }
        }

        return primes;
    }

    /**
     * creates an array starting from 2 and a defined upper limit
     *
     * @param upperLimit the defined upper limit
     * @return created array
     */
    private ArrayList<Integer> createAnArray(int upperLimit) {
        ArrayList<Integer> constructedArray = new ArrayList<>();
        for (int i = 2; i <= upperLimit; i++) {
            constructedArray.add(i);
        }
        return constructedArray;
    }

    /**
     * prints an array on the screen
     *
     * @param array the array tp print
     */
    private void printArray(ArrayList<Integer> array) {
        print("the primes are : ");
        for (int element : array) {
            print(element);
            if (array.indexOf(element) < array.size() - 1) {
                print(", ");
            }
        }
    }
}
