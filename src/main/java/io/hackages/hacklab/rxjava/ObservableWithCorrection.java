package io.hackages.hacklab.rxjava;

import io.vavr.CheckedRunnable;
import io.vavr.control.Try;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.LongStream;

/**
 * <ul>
 * <li>An observable is a function that accepts a producer in parameter and has a subscribe method </li>
 * <li>A producer is a function that throws/produce values and accepts an observer</li>
 * <li>An observer is just an object that has 3 functions: next, error, complete and listen to the value emitted  by the producer</li>
 * </ul>
 *
 * @author Mazlum Tosun
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ObservableWithCorrection<T> {

    private Consumer<Observer<T>> subscriber;

    /**
     * Constuctor with subscriber.
     *
     * @param subscriber subscriber
     */
    public ObservableWithCorrection(final Consumer<Observer<T>> subscriber) {
        this.subscriber = subscriber;
    }

    /**
     * Subscribes an {@link Observer} to the current observable.
     *
     * @param observer observer
     */
    public void subscribe(final Observer<T> observer) {
        this.subscriber.accept(observer);
    }

    /**
     * Static creation operators : interval.
     * Emit numbers in sequence based on provided timeframe.
     *
     * @param period period of the interval
     * @return Observable that contains the interval
     */
    public static ObservableWithCorrection<Long> interval(final long period) {
        final Consumer<Observer<Long>> subscriber = s -> ObservableWithCorrection.buildObserverWithInterval(period, s);
        return new ObservableWithCorrection<>(subscriber);
    }

    /**
     * Static creation operators : of
     * Emits the arguments you provide, then completes.
     *
     * @param values values
     * @return an {@link ObservableWithCorrection} that contains generic values
     */
    public static <T> ObservableWithCorrection<T> just(final T... values) {
        return null;
    }

    /**
     * Static creation operators : from with an array.
     * Converts an array to an Observable.
     *
     * @param array array to convert
     * @return an {@link ObservableWithCorrection} that contains same values of the given array
     */
    public static <T> ObservableWithCorrection<T> from(final T[] array) {
        return null;
    }

    /**
     * Static creation operators : from with an iterable.
     * Converts an iterable to an Observable.
     *
     * @param iterable iterable to convert
     * @return an {@link ObservableWithCorrection} that contains same values of the given array
     */
    public static <T> ObservableWithCorrection<T> from(final Iterable<? extends T> iterable) {
        return null;
    }

    /**
     * Static creation operators : from with a {@link Callable}.
     * Creates an {@link ObservableWithCorrection} from a {@link Callable}.
     *
     * @param callable callable
     * @return an {@link ObservableWithCorrection} that contains same values of the given array
     */
    public static <T> ObservableWithCorrection<T> fromCallable(final Callable<? extends T> callable) {
        return null;
    }

    /**
     * Transformation operators : map.
     * Apply a projection to each value and emits that projection in the returned observable.
     *
     * @param projection projection
     * @return an {@link ObservableWithCorrection} of the result type of projection
     */
    public <R> ObservableWithCorrection<R> map(final Function<? super T, ? extends R> projection) {
        return null;
    }

    /**
     * Transformation operators : mapTo
     * Maps every value to the same value every time.
     *
     * @param value value
     * @return an {@link ObservableWithCorrection} all elements of Observable are mapped to the given value
     */
    public <R> ObservableWithCorrection<R> mapTo(final R value) {
        return null;
    }

    /**
     * Filtering operators : filter.
     * only emits a value from the source if it passes a criterion function.
     *
     * @param predicate predicate
     * @return an Observable with elements that satisfy predicate
     */
    public ObservableWithCorrection<T> filter(final Predicate<? super T> predicate) {
        return null;
    }

    /**
     * Transformation operators : doOnNext.
     * Transparently perform actions or side-effects, such as logging..
     *
     * @param action action to perform
     * @return Observable
     */
    public ObservableWithCorrection<T> doOnNext(final Consumer<? super T> action) {
        return null;
    }

    /**
     * Combinations operators : startWith
     * Emit given value first.
     *
     * @param values values to put first
     * @return the current {@link ObservableWithCorrection} with the given values first
     */
    public ObservableWithCorrection<T> startWith(final T... values) {
        return null;
    }

    /**
     * Same operation to {@link #startWith(Object[])} but with an {@link Iterable}.
     */
    public ObservableWithCorrection<T> startWith(final Iterable<T> iterable) {
        return null;
    }

    /**
     * Same operation to {@link #startWith(Object[])} but with an {@link ObservableWithCorrection}.
     */
    public ObservableWithCorrection<T> startWith(final ObservableWithCorrection<T> observable) {
        return null;
    }

    /**
     * Combinations operators : concat Concatenates multiple Observables together by sequentially
     * emitting their values, one Observable after the other.
     *
     * @param observable1 observable 1
     * @param observable2 observable 2
     * @return Observable with concatenated values
     */
    public static <T> ObservableWithCorrection<T> concat(final ObservableWithCorrection<? extends T> observable1, final ObservableWithCorrection<? extends T> observable2) {
        return null;
    }

    /**
     * Same to {@link #concat(ObservableWithCorrection, ObservableWithCorrection)} but with the current instance of Observable
     */
    public ObservableWithCorrection<T> concat(final ObservableWithCorrection<? extends T> observable) {
        return null;
    }

    /**
     * Filtering operators : take
     * Takes the first count values from the source, then completes.
     *
     * @param count count
     * @return an {@link ObservableWithCorrection} that contains the first count value
     */
    public ObservableWithCorrection<T> take(final int count) {
        return null;
    }

    /**
     * Filtering operators : first.
     * Emits only the first value. Or emits only the first value that passes some test.
     *
     * @param predicate predicate
     * @return Observable with first value
     */
    public ObservableWithCorrection<T> first(final Predicate<? super T> predicate) {
        return null;
    }

    /**
     * Filtering operators : skip
     * Returns an Observable that skips n items emitted by an Observable.
     *
     * @param count count
     * @return Observable
     */
    public ObservableWithCorrection<T> skip(final int count) {
        return null;
    }

    /**
     * Build an {@link Observer} with an interval.
     *
     * @param period     period
     * @param subscriber subscriber
     */
    private static void buildObserverWithInterval(final long period, Observer<Long> subscriber) {

        final CheckedRunnable action = () -> LongStream.rangeClosed(1, period)
                .map(ObservableWithCorrection::toIndexWithInterval)
                .forEach(subscriber::onNext);

        Try.run(action).onFailure(subscriber::onError);
        subscriber.onCompleted();
    }

    /**
     * Adds an interval for each index.
     *
     * @param index index
     * @return the current index
     */
    private static long toIndexWithInterval(long index) {
        Try.run(() -> Thread.sleep(1000)).onFailure(e -> System.out.println("Error !!!"));
        return index;
    }
}
