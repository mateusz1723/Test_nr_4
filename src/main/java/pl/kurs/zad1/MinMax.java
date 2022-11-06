package pl.kurs.zad1;

public class MinMax<T extends Comparable> {
    private T min;
    private T max;

    public MinMax(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public T getMin() {
        return min;
    }


    public T getMax() {
        return max;
    }


}
