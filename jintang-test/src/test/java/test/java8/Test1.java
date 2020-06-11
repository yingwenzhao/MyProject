package test.java8;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Stream;

public class Test1 {

    @Test
    public void lambdaTest() {
        Runnable run = () -> System.out.println("12122");
        new Thread(run).start();

        Comparator<Integer> comparator = (a, b) -> Integer.compare(a, b);


    }

    @Test
    public void streamTest(){
        TreeSet<String> treeSet = new TreeSet<>();
        Stream<String> stream = treeSet.stream();
        System.out.println(stream);
    }

}
