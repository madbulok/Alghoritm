package homework.lesson5;

import java.util.Arrays;

public class MainClass {
    private static final float[] bigArray = new float[10000000];

    public static void main(String[] args) {
        Arrays.fill(bigArray, 1);
        oneThreadMethod();
        twoThreadMethod();
    }

    private static void oneThreadMethod() {
        long start = System.currentTimeMillis();
        updateArray(bigArray);
        System.out.println("One thread time elapsed: " + (System.currentTimeMillis()-start));
    }

    private static void twoThreadMethod() {
        final float[] firstHalf = new float[bigArray.length/2];
        final float[] secondHalf = new float[bigArray.length/2];
        System.arraycopy(bigArray, 0, firstHalf, 0, bigArray.length/2);
        System.arraycopy(bigArray, bigArray.length/2, secondHalf, 0, bigArray.length/2);

        long start = System.currentTimeMillis();
        Thread firstThread = new Thread(new Runnable() {
            public void run() {
                updateArray(firstHalf);
            }
        });

        Thread secondThread = new Thread(new Runnable() {
            public void run() {
                updateArray(secondHalf);
            }
        });

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
            System.arraycopy(firstHalf, 0, bigArray, 0, firstHalf.length);
            System.arraycopy(secondHalf, 0, bigArray, firstHalf.length, firstHalf.length);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Two thread time elapsed: " + (System.currentTimeMillis() - start));

        // проверка в месте склейки
        System.out.println(Arrays.toString(Arrays.copyOfRange(bigArray, bigArray.length / 2 - 10, bigArray.length / 2 + 10)));
    }

    private static void updateArray(float[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5f) * Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i /2f));
        }
    }
}
