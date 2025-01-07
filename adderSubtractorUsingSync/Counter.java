package adderSubtractorUsingSync;

public class Counter {

    private int value;

    public Counter(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public synchronized void incrementValue(int value) {
        this.value += value;
    }

    public synchronized void decrementValue(int value) {
        this.value -= value;
    }
}
