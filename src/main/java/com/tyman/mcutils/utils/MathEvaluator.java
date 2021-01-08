package com.tyman.mcutils.utils;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Function;
import com.fathzer.soft.javaluator.Parameters;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MathEvaluator extends DoubleEvaluator {
    private static final Function SQRT = new Function("sqrt", 1);
    private static final Parameters PARAMS;

    private static final Map<Function, java.util.function.Function<Iterator<Double>, Double>> funcs = new HashMap<>();

    static {
        // Gets the default DoubleEvaluator's parameters
        PARAMS = DoubleEvaluator.getDefaultParameters();
        // add the new sqrt function to these parameters
        PARAMS.add(SQRT);
    }

    public static void setFuncs() {
        funcs.put(SQRT, (Iterator<Double> arguments) -> Math.sqrt(arguments.next()));
    }

    public MathEvaluator() {
        super(PARAMS);
        setFuncs();
    }

    @Override
    protected Double evaluate(Function function, Iterator<Double> arguments, Object evaluationContext) {
        if (funcs.containsKey(function)) {
            // Custom function
            java.util.function.Function<Iterator<Double>, Double> func = funcs.get(function);
            return func.apply(arguments);
        } else {
            // Not a custom function
            return super.evaluate(function, arguments, evaluationContext);
        }
    }
}
