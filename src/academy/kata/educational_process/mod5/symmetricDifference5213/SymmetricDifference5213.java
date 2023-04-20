package academy.kata.educational_process.mod5.symmetricDifference5213;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference5213 {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        //твой код здесь
        Set<T> symmetricDiff = new HashSet<>(set1);
        symmetricDiff.addAll(set2);
        Set<T> tmp = new HashSet<>(set1);
        tmp.retainAll(set2);
        symmetricDiff.removeAll(tmp);
        return symmetricDiff;
    }
}
