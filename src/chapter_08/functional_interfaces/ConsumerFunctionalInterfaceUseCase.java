package chapter_08.functional_interfaces;

import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * This class represents a use case/usage of Consumer built-in functional interface, using method reference and lambda
 */
public class ConsumerFunctionalInterfaceUseCase {
    static Consumer<String> consumerRef = System.out::println;
    static Consumer<String> consumerRefLambda = x -> System.out.println(x);


    public static void main(String[] args) {
        consumerRef.accept("Printing --> {Obaid} method reference");
        consumerRefLambda.accept("Printing --> {Obaid} Lambda");

        //BiConsumer
        var map = new HashMap<String, Integer>();
        BiConsumer<String, Integer> biConsumerMethodRef = map::put;
        BiConsumer<String, Integer> biConsumerLambda = (k, v) -> map.put(k, v);


        biConsumerMethodRef.accept("Java-17", 1);
        biConsumerLambda.accept("Oracle certification", 2);
        System.out.println("\nprinting map from BiConsumer");
        System.out.println(map);

    }


}
