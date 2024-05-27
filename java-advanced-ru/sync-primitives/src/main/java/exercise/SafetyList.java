package exercise;

class SafetyList {
    // BEGIN
    private int size = 0;
    private int[] list;
    public synchronized void add(int value) {
        size = size + 1;
        int[] result = new int[size];
        result[size - 1] = value;
        list = result;
    }
    public int get(int index) {
        return list[index];
    }

    public int getSize() {
        return size;
    }
    // END
}
