import java.util.Arrays;

public class KLists {
    private double [] mergeLists(double[] a, double[] b) {
        int lenA = a.length;
        int lenB = b.length;
        double result[] = new double[lenA + lenB];

        int i=0, j=0, k=0;

        while(i<lenA && j<lenB) { // compare the length of both arrays
            if(a[i] < b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while(i<lenA) { //store remaining elements of first array
            result[k++] = a[i++];
        }

        while(j<lenB) { //store remaining elements of second array
            result[k++] = b[j++];
        }
        return result;
    }

    public double [] mergeKLists(double[][] outerArray) {
        double result[] = outerArray[0];
        for(int i=1; i<outerArray.length; i++) { //sort through outer array to return all inner arrays
            result = mergeLists(result, outerArray[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        KLists klists = new KLists();
        double [][] outerArray = {{1.1, 4.4, 5.5}, {1.1, 3.3, 4.4}, {2.2, 6.6}};
        double[] fin = klists.mergeKLists(outerArray);
        System.out.println(Arrays.toString(fin));
    }
}
