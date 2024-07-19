package chapter_08.functional_interfaces;

import java.time.LocalDate;
import java.util.function.Supplier;

public class SupplierImpl {
    static Supplier<LocalDate> supplierRef = LocalDate::now;
    static Supplier<LocalDate> supplierLambda = () -> LocalDate.now();

    static LocalDate dateFromRef = supplierRef.get();
    static LocalDate dateFromLambda = supplierLambda.get();

    public static void main(String[] args) {
        System.out.println(dateFromRef);
        System.out.println(dateFromLambda);
    }


}
