package ua.nure.matyash.practice5;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MyThread2 extends Thread{
    private RandomAccessFile file;
    private int line;
    private static final int N_20 = 20;

    MyThread2(RandomAccessFile file, int line){
        this.line = line;
        this.file = file;

    }
    @Override
    public void run(){
        synchronized (file) {
            try {

                file.seek(line);
                for (int i = 0; i < N_20; i++) {
                    currentThread().getName();
                    Thread.sleep(1);
                    file.write((line / N_20 + "").getBytes("cp1251"));

                }
                file.write(System.lineSeparator().getBytes("cp1251"));


            } catch (IOException | InterruptedException e) {
                System.out.println(e);
            }
        }
    }

}