package stored;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * enum Color
 */
public enum Color {
    GREEN,
    RED,
    BLACK,
    WHITE,
    BROWN;

    /**
     * asdf
     * @return res
     */
    @Override
    public String toString() {
        String res = "";
        for (Color i : Color.values())
            res += i.name() + " ";
        return res;
    }

}
