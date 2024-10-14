package Arrays_And_BigO_Notations;

public class Arrays {
    public static void main(String[] args) {
        //System.out.println("Hello Pritam");
        int [] intArray = new int [7];

        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 55;
        intArray[5] = 1;
        intArray[6] = -22;

        int index =-1;
//  The error you are encountering, java.lang.ArrayIndexOutOfBoundsException: 20, is due to the line if(intArray[i] == 7).
// In your for-each loop, i takes the value of the elements in the array (e.g., 20, 35, -15, etc.), not the index.

//        20
//        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 20
//        at Arrays_And_BigO_Notations.Arrays.main(Arrays.java:20)

// For Loop Correction: Replaced the for-each loop with a traditional for loop to access the index directly.
//Accessing Array Elements: Now, i is the index, and you can use intArray[i] to get the element at that index.
//Finding the Index: When the element equals 7, the code sets the index variable to i and breaks out of the loop.


//        for (int i:intArray) {
        for(int i=0;i<intArray.length;i++){
            System.out.println(i);
            // Retrieve the elements from the array and print the index
            //As we are searching the element without knowing the index so its time Complexity will be O(n)
            if(intArray[i] == 7){
                index =i;
                break;
            }
        }
        System.out.println("Index = "+index);
    }
}
