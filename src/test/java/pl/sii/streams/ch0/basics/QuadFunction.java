package pl.sii.streams.ch0.basics;

@FunctionalInterface
public interface QuadFunction<RETURN_TYPE, PARAM1, PARAM2, PARAM3, PARAM4> {
    RETURN_TYPE apply(PARAM1 p1, PARAM2 p2, PARAM3 p3, PARAM4 p4);
}
