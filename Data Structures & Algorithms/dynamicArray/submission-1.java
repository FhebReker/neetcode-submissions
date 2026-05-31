class DynamicArray {
    private int[] array;
    private int length;
    private int capacity;

    public DynamicArray(int capacity) {
        this.array = new int[capacity];
        this.length = 0;
        this.capacity = capacity;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (length == capacity) this.resize();

        array[length] = n;
        length++;
    }

    public int popback() {
        int back = array[length - 1];
        length--;
        return back;
    }

    private void resize() {
        capacity *= 2;
        int[] resizedArr = new int[capacity];
        for (int i = 0; i < length; i++) {
            resizedArr[i] = array[i];
        }
        array = resizedArr;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
