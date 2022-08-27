package io.vom.tests.core;

import com.google.common.primitives.Chars;
import io.vom.appium.AppiumDriverImpl;
import io.vom.core.Context;
import io.vom.views.LoginView;
import org.apache.commons.collections.ListUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ViewTest {


    @Test
    public void common_selector_test() {
        Integer[] arr = new Integer[]{5, 8, 6, 3, 4};

        Arrays.sort(arr, (a, b) -> {
            if (a > b) {
                return 1;
            }else if (a < b && b % 2 == 0){
                return -1;
            }else {
                return Integer.compare(a,b);
            }

        });

        System.out.println(Arrays.toString(arr));

    }

    public static char[] getGeorgianChars() {
        List<Character> a = IntStream.range(7312, 7353)
                .boxed()
                .map(integer -> (char) integer.intValue()).collect(Collectors.toList());

        List<Character> b = IntStream.range(4304, 4351)
                .boxed()
                .map(integer -> (char) integer.intValue()).collect(Collectors.toList());


        return Chars.toArray(ListUtils.union(a, b));
    }

    @Test
    public void context_builder() {
        Context context = Context.getBuilder()
                .setDriver(new AppiumDriverImpl())
                .build();

        context.loadView(LoginView.class)
                .login()
                .clickButton()
                .job((it) -> System.out.println(it.collect()))
                .scrollUpToStart();


    }
}
