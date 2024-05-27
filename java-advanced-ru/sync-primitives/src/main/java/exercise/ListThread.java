package exercise;

// BEGIN
public class ListThread extends Thread {
    private SafetyList list;
    public ListThread(SafetyList safetyList) {
        this.list = safetyList;
    }
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.add((int) (Math.random() % 1000));
        }
    }
}
// END
