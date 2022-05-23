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
        // you may delete this function if not needed
    }

    public int[] getIndices(int size){
            /*Returns array of indices of the
            unsorted array input
            */
        int [] inds = null;
        ///  Generate indices
        return inds;
    }
    private void hepsort(int[] array,int[] inds, boolean largest) {
        /*
        Implement heap sort, you should can use Java heap or additional funtions
        you may remove inds if you do not sort inds as well but it is recommended
         */
        this.vals = array; // you can change this
        this.inds = null; // change this if you sort indices as well
    }

    private void insertionSort (int[] array,int[] inds,boolean largest) {
        /*
        Implement insertion sort
        you may remove inds if you do not sort inds as well but it is recommended
         */
        this.vals = array; // you can change this
        this.inds = null; // change this if you sort indices as well
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
        if (alg.equals("heapsort")) {
            heapsort(array, inds, largest);
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

