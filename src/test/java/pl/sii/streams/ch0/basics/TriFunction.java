package pl.sii.streams.ch0.basics;

@FunctionalInterface
public interface TriFunction<PARAM1, PARAM2, PARAM3, RETURN_TYPE> {
    RETURN_TYPE apply(PARAM1 p1, PARAM2 p2, PARAM3 p3);
}
