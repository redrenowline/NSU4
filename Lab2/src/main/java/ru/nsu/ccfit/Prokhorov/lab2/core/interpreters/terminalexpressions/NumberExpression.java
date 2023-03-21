package ru.nsu.ccfit.Prokhorov.lab2.core.interpreters.terminalexpressions;

import ru.nsu.ccfit.Prokhorov.lab2.core.context.Context;
import ru.nsu.ccfit.Prokhorov.lab2.core.interpreters.Expression;

public class NumberExpression extends Expression {

    private double value;
    public NumberExpression(Context context, double value){
        super(context);
        this.value = value;
    }
    @Override
    public Object Interp() {
        return Double.valueOf(value);
    }
}
