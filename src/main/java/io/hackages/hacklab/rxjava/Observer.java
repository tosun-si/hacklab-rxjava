package io.hackages.hacklab.rxjava;

/**
 * Observer that can subscribe to an {@link Observable}.
 *
 * @author Mazlum Tosun
 */
public interface Observer<T> {

    void onCompleted();

    void onError(Throwable var1);

    void onNext(T var1);
}
