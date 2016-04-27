package arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * Udleveret klasse erklæring med main() metode til VOP re-eksamen 20. august 2014
 *
 * @author erso
 */
public class ArrayTester {
    
    //private vs public?
    private static Random generator = new Random();
    private static final int MAX = 100;
    private int[] intArray;
    
public ArrayTester(int size) {
    
    intArray = new int[size];
    
    for(int i = 0; i < intArray.length; i++) {
        
        intArray[i] = generator.nextInt(MAX);
        
    }
    
    }
    
  @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("\n");
        
        for(int i = 0; i < intArray.length; i++) {
            
            if(intArray[i] < 10) {
                sb.append("0" + intArray[i]);
            } else {
            sb.append(intArray[i]);
            }
            
            sb.append(", ");
            
            if((i+1) % 8 == 0) {
                sb.append("\n");
            }
            
            
        }
        
        sb.append("\n---------------------\n");
        
        return sb.toString();
    }
    
    public void sort() {
        
        Arrays.sort(intArray);
        
    }
    
    public void reverse() {
        
        int fromIndex = 0;
        int toIndex = intArray.length - 1;
        
        while(fromIndex < toIndex) {
            
            swap(fromIndex, toIndex);
                   
            fromIndex++;
            toIndex--;
        }
        
    }
    
    // Udleveret metode, som bytter om på 2 elementer i arrayet.
    // Bør benyttes ved løsning af opg 3d
    public void swap(int fromIndex, int toIndex) {
        int temp = intArray[fromIndex];
        intArray[fromIndex] = intArray[toIndex];
        intArray[toIndex] = temp;
    }

  

    


    // Udleveret main()-metode til test
    // Fjern ud-kommenteringerne efterhånden som opgaven løses.
    public static void main(String[] args) {
        int size = 30;
        ArrayTester arrayTester = new ArrayTester(size);
        System.out.println("constructor: " + arrayTester);

        arrayTester.sort();
        System.out.println("sorted: " + arrayTester);

        arrayTester.reverse();
        System.out.println("reverse: " + arrayTester);

    }

}
