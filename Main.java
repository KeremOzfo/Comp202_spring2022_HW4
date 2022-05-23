import java.io.IOException;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
public class Main {
    static int getRandomNumber(int min, int max) {
        // random generator
        Random rd = new Random();
        double rand = rd.nextDouble();
        return (int) (rand * (max - min) + min);
    }
    static int[] copyArray(int[] arr) { // Helper for array copying
        int[] array_cpy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array_cpy[i] = arr[i];
        }
        return array_cpy;
    }
    static int[] randArray(int size, int min,int max) { // Helper for generating rand Array
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            int rand = getRandomNumber(min, max);
            array[i] = rand;
        }
        return array;
    }
    static int[] test_array(String file) throws IOException {
        int[] arr = new int[100000];
        BufferedReader bf = new BufferedReader(new FileReader(file));
        // read entire line as string
        String line = bf.readLine();
        int c = 0;
        while (line != null) {
            int in = Integer.parseInt(line);
            arr[c] = in;
            line = bf.readLine();
            c++;
        }
        bf.close();
        return arr;
    }
    static void print_head(int[] array) {
        for (int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }
    }


    public static void main(String[] args) throws IOException {
        int [] input = test_array("input.txt");
        int LENGTH = (int) 1E5; // equivalent of 10^(Ex)
        int maximum = (int) 1E6; // maximum integer in your array
        int minimum = -maximum; // minimum integer in your array
        int k =(int) 1E3; // topK "K" value
        boolean test = true; // make it true for autograder else generates custom array

        int[] array = test ? input : randArray(LENGTH,minimum,maximum);
        Sort sort = new Sort();
        int[] top_vals,top_inds;


        long start = System.currentTimeMillis();
        sort.sort(copyArray(array),true,"insertionsort");
        long finish = System.currentTimeMillis();
        float time = (float) (finish-start);
        //System.out.println("insertion sort took "+time+" ms.");
        print_head(sort.top_vals);
        sort.flush();
        sort.sort(copyArray(array),false,"insertionsort");
        print_head(sort.top_vals);
        sort.flush();

        start = System.currentTimeMillis();
        sort.sort(copyArray(array),true,"heapsort");
        finish = System.currentTimeMillis();
        time = (float) (finish-start);
        //System.out.println("Quicksort took "+time+" ms.");
        print_head(sort.top_vals);
        sort.flush();
        sort.sort(copyArray(array),false,"heapsort");
        print_head(sort.top_vals);
        sort.flush();

        start = System.currentTimeMillis();
        sort.topk(copyArray(array),k,true,"heapsort");
        finish = System.currentTimeMillis();
        time = (float) (finish-start);
        //System.out.println("TopK took "+time+" ms.");
        System.out.println(sort.top_inds.length + sort.top_vals.length);
        print_head(sort.top_vals);
        print_head(sort.top_inds);
        sort.flush();
        sort.topk(copyArray(array),k,false,"heapsort");
        System.out.println(sort.top_inds.length + sort.top_vals.length);
        print_head(sort.top_vals);
        print_head(sort.top_inds);
        sort.flush();


        start = System.currentTimeMillis();
        sort.fast_topk(copyArray(array),k,true,"quicksort");
        finish = System.currentTimeMillis();
        time = (float) (finish-start);
        //System.out.println("Fast-TopK took "+time+" ms.");
        System.out.println(sort.top_inds.length + sort.top_vals.length);
        print_head(sort.top_vals);
        print_head(sort.top_inds);
        sort.flush();
        sort.fast_topk(copyArray(array),k,false,"quicksort");
        System.out.println(sort.top_inds.length + sort.top_vals.length);
        print_head(sort.top_vals);
        print_head(sort.top_inds);

    }

}