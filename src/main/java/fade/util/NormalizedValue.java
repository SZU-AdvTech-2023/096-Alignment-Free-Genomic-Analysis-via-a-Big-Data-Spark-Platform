package fade.util;

public class NormalizedValue implements Value {
    public final double count;

    public NormalizedValue(double count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "" + count;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NormalizedValue)) return false;

        return ((NormalizedValue)obj).count == count;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(count);
    }
}
