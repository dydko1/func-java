package pl.sii.streams.ch0.basics.sch2;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class Try<T, R> {
    private Optional<R> result;
    private Optional<Exception> e;

    public static <T, R> Try<T, R> with(T inputType, Function<T, R> func) {
        return new Try<>(inputType, func);
    }

    private Try(T inputType, Function<T, R> transformFunc) {
        try {
            this.result = Optional.of(transformFunc.apply(inputType));
            this.e = Optional.empty();
        } catch (Exception e) {
            this.result = Optional.empty();
            this.e = Optional.of(e);
        }
    }

    public Try<T, R> onSuccess(Consumer<R> consume) {
        result.ifPresent(consume::accept);
        return this;
    }

    public Try<T, R> onException(Consumer<Exception> consumeException) {
        e.ifPresent(consumeException::accept);
        return this;
    }
}
