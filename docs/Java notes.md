:laughing:  

## Content list
  
1. [Strings](#string-methods)

2. [Arrays](#arrays)  

<hr>

#### String methods
For all string methods explaination refer [GFG](https://www.geeksforgeeks.org/string-class-in-java/)
```java
"GeeksforGeeks".length();  // returns 13
"GeeksforGeeks".charAt(3); // returns  ‘k’
"GeeksforGeeks".substring(3); // returns “ksforGeeks”
"GeeksforGeeks".substring(2, 5); // returns “eks”  // begin index, end index and it is exclusive
```
- length of string ->  `s.length()`

#### Arrays
```java
// by default initializes array to 0 
int myarr[] = new int[30]; 

// To explicitely intialize with specific value use -
Arrays.fill(myarr, -1);
```
- For `Strings[]` the default value is `null`  
- Max or Min integer constants - `Integer.MAX_VALUE` and `Integer.MIN_VALUE`
- length ->   `myarr.length`
- deep copy of an array ->
    ```java
    int intArray[][] = {{1,2,3},{4,5}};   
    int cloneArray[][] = intArray.clone();
    ```
- print arrays `Arrays.toString(arr)`
- Set to array `arr = s.toArray(arr);` [Refer GFG](https://www.geeksforgeeks.org/set-to-array-in-java/?ref=rp) 