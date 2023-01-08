package Introduction;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {
    private int value;
    /** Возвращает уникальное значение. */
    public int getNext() {
        return value++;
    }
}