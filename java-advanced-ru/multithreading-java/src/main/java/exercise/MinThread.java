package exercise;

// BEGIN
public class MinThread extends Thread {
    private int min;
    private int[] digits;
    public MinThread(int[] numbers) {
        digits = numbers;
    }
    public void run() {
        min = digits[0];
        for(int i = 1; i < digits.length; i++) {
            if(digits[i] < min) {
                min = digits[i];
            }
        }
    }

    public int getMin() {
        return min;
    }
}
// END
