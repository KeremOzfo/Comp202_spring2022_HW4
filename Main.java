import com.sun.security.auth.NTDomainPrincipal;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
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
    public void test(int[] array) {
        int [] ary_cpy = copyArray(array);
        Sort sort = new Sort();
        sort.sort(ary_cpy,true,"insertionsort");
        for (int i = 0; i < 20; i++) {
            System.out.println(sort.top_vals[i]);
        }
        sort.flush();
        sort.sort(ary_cpy,false,"insertionsort");
        for (int i = 0; i < 20; i++) {
            System.out.println(sort.top_vals[i]);
        }
    }


    public static void main(String[] args) throws IOException {
        int [] input = test_array("input.txt");
        int LENGTH = (int) 1E5; // equivalent of 10^(Ex)
        int maximum = (int) 1E6; // maximum integer in your array
        int minimum = -maximum; // minimum integer in your array
        boolean largest = false; // for getting largest or smallest values.
        int k =(int) 1E3; // topK "K" value
        int[] array = randArray(LENGTH,minimum,maximum);
        int[] array_cpy = copyArray(array);
        int [] input_cpy = copyArray(input);
        Sort sort = new Sort();
        int[] top_vals,top_inds;

        long start = System.currentTimeMillis();
        sort.sort(array_cpy,largest,"insertionsort");
        top_vals = sort.top_vals;
        long finish = System.currentTimeMillis();
        float time = (float) (finish-start);
        sort.flush();
        //System.out.println("insertion sort values");
        //System.out.println(Arrays.toString(top_vals));
        System.out.println("insertion sort took "+time+" ms.");
        array_cpy = copyArray(array);
        input_cpy = copyArray(input);


        start = System.currentTimeMillis();
        sort.sort(array_cpy,largest,"quicksort");
        top_vals = sort.top_vals;
        finish = System.currentTimeMillis();
        time = (float) (finish-start);
        sort.flush();
        //System.out.println("Quicksort values");
        //System.out.println(Arrays.toString(top_vals));
        System.out.println("Quicksort took "+time+" ms.");
        array_cpy = copyArray(array);
        input_cpy = copyArray(input);


        start = System.currentTimeMillis();
        sort.topk(array_cpy,k,largest,"quicksort");
        top_vals = sort.top_vals;
        top_inds = sort.top_inds;
        finish = System.currentTimeMillis();
        time = (float) (finish-start);
        sort.flush();
        //System.out.println("TopK values");
        //System.out.println(Arrays.toString(top_vals));
        //System.out.println("TopK indices");
        //System.out.println(Arrays.toString(top_inds));
        System.out.println("TopK took "+time+" ms.");
        array_cpy = copyArray(array);
        input_cpy = copyArray(input);


        start = System.currentTimeMillis();
        sort.fast_topk(array_cpy,k,largest,"quicksort");
        top_vals = sort.top_vals;
        top_inds = sort.top_inds;
        finish = System.currentTimeMillis();
        time = (float) (finish-start);
        //System.out.println("Fast-TopK values");
        //System.out.println(Arrays.toString(top_vals));
        //System.out.println("Fast-TopK indices");
        //System.out.println(Arrays.toString(top_inds));
        System.out.println("Fast-TopK took "+time+" ms.");
        input_cpy = copyArray(input);


                /*
        try {
            FileWriter writer = new FileWriter("input.txt");
            for(int val: array_cpy) {
                writer.write(val + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */

    }

}