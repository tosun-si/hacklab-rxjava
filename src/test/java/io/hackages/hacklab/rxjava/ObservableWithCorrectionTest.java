package io.hackages.hacklab.rxjava;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * Allows to test the operations of {@link ObservableWithCorrection} class.
 *
 * @author Mazlum Tosun
 */
public class ObservableWithCorrectionTest<T> {

    @Test
    public void givenPeriodAndObserver_whenBuildObservableWithInterval_then_expectedResult() {

        // Given.
        final long period = 10;

        // When.
        final Observer<Long> observer = new Observer<Long>() {
            @Override
            public void onCompleted() {
                System.out.println("Operation is complete");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Error is occured in operation : " + e);
            }

            @Override
            public void onNext(Long value) {
                System.out.println(value);
            }
        };

        ObservableWithCorrection.interval(period).subscribe(observer);
    }

    @Test
    public void givenPeriodAndOnNext_whenBuildObservableWithInterval_then_expectedResult() {

        // Given.
        final long period = 10;

        // When.
        final Consumer<Long> onNext = System.out::println;

        ObservableWithCorrection.interval(period).subscribe(onNext);
    }
}
