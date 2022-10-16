package pl.sii.streams.ch0.basics.sch1;

@FunctionalInterface
public interface QuadFunction<PARAM1, PARAM2, PARAM3, PARAM4, RETURN_TYPE> {
    RETURN_TYPE apply(PARAM1 p1, PARAM2 p2, PARAM3 p3, PARAM4 p4);
}
