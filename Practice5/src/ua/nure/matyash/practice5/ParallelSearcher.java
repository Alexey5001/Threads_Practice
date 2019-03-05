package ua.nure.matyash.practice5;

public class ParallelSearcher extends Thread{
    private int maxVal;
    private int [] arr;

    public ParallelSearcher(int[] getArr){
        this.arr = getArr.clone();
    }
    @Override
    public void run(){
        findMaxValue();
    }

    private void findMaxValue(){
        maxVal = arr[0];
        for (int i : this.arr){
            if (i > maxVal){
                maxVal = i;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
        	System.out.println(e);
                Thread.currentThread().interrupt();
            }
        }
    }

    public int getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(int maxval) {
        this.maxVal = maxval;
    }


}
