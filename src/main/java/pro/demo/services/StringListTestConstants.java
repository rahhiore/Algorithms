package pro.demo.services;
import java.util.Arrays;
public class StringListTestConstants {
    public static final String FIRST = "first";
    public static final String SECOND = "second";
    public static final String THIRD = "third";
    public static final String FOURTH = "fourth";
    public static final String FIVE = "five";
    public static final StringListImpl OTHERLIST = new StringListImpl(Arrays.asList(FIRST, FOURTH, SECOND, THIRD));
    public static final StringListImpl OTHERLIST2 = new StringListImpl(Arrays.asList(FOURTH, THIRD));
    public static final StringListImpl OTHERLIST3 = new StringListImpl();
}
