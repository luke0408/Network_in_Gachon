package calculator.utils;


import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    @Getter
    private final String symbol;

    @Getter
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    private static final Map<String, String> SYMBOL_MAP = Collections.unmodifiableMap(
                    Stream.of(values()).collect(Collectors.toMap(Operation::getSymbol, Operation::name)));

    public static Operation of(String symbol) {
        return Operation.valueOf(SYMBOL_MAP.get(symbol).toString());
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
