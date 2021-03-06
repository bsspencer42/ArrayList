import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 3;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayList.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // Check for null data
        if (data == null){
            throw new IllegalArgumentException();
        }

        // Resize and add if necessary
        if (size == backingArray.length){
            T[] resizeArray = (T[]) new Object[backingArray.length*2];  // Create new container for values
            resizeArray[0] = data;                                      // Add new value to front
            for (int i = 0; i < backingArray.length; i++){              // Dump original values
                resizeArray[i+1] = backingArray[i];
            }
            backingArray = resizeArray;                                 // Set backingArray to new array
        }

        // No resize needed
        else {
            T curVal;
            for (int i = 0; i < backingArray.length; i++){
                curVal = backingArray[i];
                backingArray[i] = data;
                data = curVal;
            }
        }

        // Increment size
        size++;

        //TODO - REMOVE - Debug print
        for (T myVals : backingArray){
            System.out.print(myVals + "  ");
        }
        System.out.println("");
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        // Check for null data
        if (data == null){
            throw new IllegalArgumentException();
        }

        // Resize array condition
        if (size == backingArray.length){
            T[] resizeArray = (T[]) new Object[backingArray.length*2];  // Create new container for values
            for (int i = 0; i < backingArray.length; i++){
                resizeArray[i] = backingArray[i];
            }
            backingArray = resizeArray;
        }

        // Add to back
        backingArray[size] = data;
        size++;

        //TODO - REMOVE - Debug print
        for (T myVals : backingArray){
            System.out.print(myVals + "  ");
        }
        System.out.println("");
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        if (size == 0){
            throw new NoSuchElementException();
        }

        // Shift values forward
        T returnVal = backingArray[0]; // Return value
        T curVal = backingArray[1];     // Initial pointer
        for (int i = 0; i < size - 1; i++){
            backingArray[i] = curVal;
            curVal = backingArray[i+2];
        }
        // Clear last value
        backingArray[size-1] = null;
        // Decrement size
        size--;

        //TODO - REMOVE - Debug print
        for (T myVals : backingArray){
            System.out.print(myVals + "  ");
        }
        System.out.println("");

        // Return removed value
        return returnVal;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        // Check if list if empty
        if (size == 0){
            throw new NoSuchElementException();
        }

        // Clear last value
        T returnVal = backingArray[size-1];
        backingArray[size-1] = null;

        // Decrement size
        size--;

        //TODO - REMOVE - Debug print
        for (T myVals : backingArray){
            System.out.print(myVals + "  ");
        }
        System.out.println("");

        // Return
        return returnVal;
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public static void main(String[] args) {
        ArrayList<Integer> myData = new ArrayList<Integer>();
        //myData.removeFromFront();
        myData.addToFront(1);
        myData.addToFront(3);
        myData.addToFront(7);
        myData.addToFront(4);
        myData.addToBack(10);
        myData.addToBack(11);
        myData.addToBack(12);
        myData.removeFromFront();
        myData.removeFromBack();
    }
}