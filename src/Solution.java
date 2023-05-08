import java.util.*;

class Solution {
    /**
     * This method generates Pascal's triangle up to a given number of rows.
     *
     * @param numRows the number of rows to generate
     * @return a list of lists representing the rows of Pascal's triangle
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(); // Create a new list to hold the triangle
        List<Integer> currList = null; // Initialize the current list
        List<Integer> prevList = null; // Initialize the previous list

        for (int i = 0; i < numRows; i++) { // Loop through each row
            currList = new ArrayList<>(); // Create a new list for the current row
            for (int j = 0; j < (i + 1); j++) { // Loop through each element in the current row
                if (j == 0 || j == i) currList.add(1); // The first and last elements are always 1
                else {
                    // Calculate the element as the sum of the two elements above it in the previous row
                    currList.add(prevList.get(j - 1) + prevList.get(j));
                }
            }
            prevList = currList; // Set the current row as the previous row for the next iteration
            result.add(currList); // Add the current row to the result list
        }

        return result; // Return the completed Pascal's triangle
    }


}
