package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN
        SafetyList safetyList = new SafetyList();
        ListThread lt = new ListThread(safetyList);
        ListThread lt2 = new ListThread(safetyList);
        lt.start();
        lt2.start();
        try {
            lt.join();
            lt2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(safetyList.getSize());
        // END
    }
}

