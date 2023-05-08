# 118. Pascal's Triangle Problem Solved: Uncover the Most Efficient Java Algorithm

Related code_study: https://www.notion.so/118-Pascal-s-Triangle-64e6f417200d498e933e531d27bf45d4
homepage: No
languange: Java
written language: English

# Problem

[Problem_Link](https://leetcode.com/problems/pascals-triangle/)

## **Problem Solving Approach**

1. Possible cases
    
    ```
    if startpos or endpos, add end
    else currpos = lastList[prevpos+currpost]
    ```
    
2. Requirements: Previous row list, Previous row list length or current row length
3. Be careful: In Java, **`add()`** method for list is a shallow copy by default.
4. That is, if you put 1 for the first and last elements in each list and add the sum of two elements above it in the previous row to the current list, Pascal's triangle will be generated.

# Time O(n), Space O(n)

```java
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
```

## **Explanation**

- If you want to use a pre-declared list, you need to perform deep copy as follows:

```
//            prevList.clear();
//            prevList.addAll(currList);
//            result.add(List.copyOf(currList));
//            currList.clear();
```