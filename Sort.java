import java.lang.*;

public class Sort {
    public int[] vals = null;
    public int[] inds = null;
    public void flush()
    {
        // for restarting the class variables
        this.vals = null;
        this.inds = null;
    }
    private void swap(int[] arr, int i, int j)
    {
        /// You should implement a swap function between the 2 indices
    }

    public int[] getIndices(int size){
            /*Returns array of indices of the
            unsorted array input
            */
        int [] inds = null;
        ///  Generate indices
        return inds;
    }
    private void quicksort(int[] array,int[] inds, boolean largest) {
        /*
        Implement quicksort, you should can use Java heap or additional funtions
         */
        this.vals = array; // you can change this
        this.inds = null; // change this
    }

    private void insertionSort (int[] array,int[] inds,boolean largest) {
        /*
        Implement insertion sort
         */
        this.vals = array; // you can change this
        this.inds = null; // change this
    }
    public void sort(int[] array,boolean largest, String alg) throws Exception{
        /*
        You do not need to change this method
        but you are free to do so.
         */

        int[] inds;
        if (this.inds == null) {
            inds = getIndices(array.length);
        }
        else {
            inds = this.inds;
        }
        if (alg.equals("quicksort")) {
            quicksort(array, inds, largest,0, array.length - 1);
        }
        else if(alg.equals("insertionsort")) {
            insertionSort(array,inds,largest);
        }
        this.vals = array;
        this.inds = inds;
    }

    public void topk(int[] array,int k,boolean largest, String alg){

        /*
        implement topk method
         */
        this.vals = array; // you can change this
        this.inds = null; // change this
    }

    public void fast_topk(int[] array,int k, boolean largest,String alg){
        /*
        Assume that, k <= array.length / 50
        for every fast_topk operation
        */

        this.vals = array; // you can change this
        this.inds = null; // change this
    }

}

