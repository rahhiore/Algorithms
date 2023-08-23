package pro.demo;
import pro.demo.services.IntegerListImpl;

import java.util.Arrays;
public class IntegerListTestConstants {
    public static final Integer FIRST = 1;
    public static final Integer SECOND = 2;
    public static final Integer THIRD = 3;
    public static final Integer FOURTH = 4;
    public static final Integer FIVE = 5;
    public static final IntegerListImpl OTHERLIST = new IntegerListImpl(Arrays.asList(FIRST, FOURTH, SECOND, THIRD));
    public static final IntegerListImpl OTHERLIST2 = new IntegerListImpl(Arrays.asList(FOURTH, THIRD));
    public static final IntegerListImpl OTHERLIST3 = new IntegerListImpl();

}
