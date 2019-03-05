package ua.nure.matyash.practice5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Part4 {
    private static int[][] arr1;
    private ParallelSearcher[] searchers;
    private OrdinalSearcher ordinalSearcher;
    private static final int N_5 = 5;
    private static final int N_10 = 10;
    private static final int N_20 = 20;

    public Part4(){
        searchers = new ParallelSearcher[Part4.arr1.length];
        ordinalSearcher = new OrdinalSearcher(Part4.arr1);
    }


    public static void main(String[] args) throws FileNotFoundException {
        int[][] matrixTmp  = new int [N_5][N_20];
        Scanner scan1 = new Scanner(new File("part4.txt"),"cp1251");
        for (int i = 0; i < matrixTmp.length; i++) {
            for (int j = 0; j < matrixTmp[0].length; j++) {
                matrixTmp[i][j] = scan1.nextInt();
            }
        }
        scan1.close();

        Part4.setArr1(matrixTmp);
        Part4 part4 = new Part4();

        long timeParallelStart = System.currentTimeMillis();
        System.out.println(part4.findMaxValWithParallelSearch());
        System.out.println( (System.currentTimeMillis() - timeParallelStart));


        long timeOrdinalStart = System.currentTimeMillis();
        System.out.println(part4.findMaxValWithOrdinalSearch());
        System.out.println((System.currentTimeMillis() - timeOrdinalStart));


    }



    public static void setArr1(int[][] arr1){
        Part4.arr1 = arr1.clone();
    }

    public int findMaxValWithParallelSearch(){
        for (int i = 0; i < arr1.length; i++) {
            searchers[i] = new ParallelSearcher(arr1[i]);
            searchers[i].start();
        }

        try {
            waitAllThreads();
        } catch (InterruptedException e) {
            System.out.println(e);
            Thread.currentThread().interrupt();
        }

        int maxVal = searchers[0].getMaxVal();
        for (int i = 0; i < searchers.length; i++) {
            if (maxVal < searchers[i].getMaxVal()){
                maxVal = searchers[i].getMaxVal();
            }
        }
        return maxVal;
    }

    public void waitAllThreads() throws InterruptedException{
        for (int i = 0; i < searchers.length; i++) {
            while(searchers[i].isAlive()){
                Thread.sleep(N_10);
            }
        }
    }

    public int findMaxValWithOrdinalSearch(){
        return ordinalSearcher.getMaxVal();
    }
}
