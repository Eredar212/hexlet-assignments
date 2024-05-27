package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int max;
    private int[] digits;
    public MaxThread(int[] numbers) {
        digits = numbers;
    }
    public void run() {
        System.out.println("MaxThread.run");
        int temp = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            temp = digits[i];
            if (temp > max) {
                max = temp;
            }
        }
    }

    public int getMax() {
        return max;
    }
}
// END
