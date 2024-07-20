package chapter_08.functional_interfaces;

import java.util.function.Function;

/**
 * This class represents a use case/usage of Consumer built-in functional interface, using method reference and lambda
 * A function is responsible for turning one parameter into a value of a potentially different type and returning it.
 */
public class FunctionFunctionalInterfaceUseCase {
    public static void main(String[] args) {

        Function<String, Integer> stringToIntMethodRef = String::length;
        Function<String, Integer> stringToIntLambda = x -> x.length();

        System.out.println("The length for given word is: " + stringToIntMethodRef.apply("obaid"));
        System.out.println("The length for given word is: " +stringToIntLambda.apply("obaid"));


    }


}
