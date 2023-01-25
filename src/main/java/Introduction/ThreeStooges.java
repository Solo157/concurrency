package Introduction;

import net.jcip.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

@Immutable
public class ThreeStooges {
    private final Set<String> stooges = new HashSet<String>();
}
