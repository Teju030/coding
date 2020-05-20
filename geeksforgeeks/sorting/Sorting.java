import java.util.Arrays;
import java.util.Collections;
public class Sorting
{
    public static void main(String[] args) {
        int arr[] = { 5,2,7,1,8,9};
        Arrays.sort(arr);
        System.out.println("Array 1: " + Arrays.toString(arr));

        Integer[] newarr = Arrays.stream( arr ).boxed().toArray( Integer[]::new );
        Arrays.sort(newarr, Collections.reverseOrder());
        System.out.println("Array 2 " +  Arrays.toString(arr));

        int a[] = { 6 , 5, 1, 8, 2, 0};
        Arrays.sort(a, 2, 4);
        System.out.println("Array 3 : " + a.toString());
    }
}