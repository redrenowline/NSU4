package ru.nsu.ccfit.Prokhorov.lab2.core.interpreters;

import ru.nsu.ccfit.Prokhorov.lab2.core.context.Context;

public abstract class Expression {
    protected Context context;

    public Expression(Context context){
        this.context = context;
    }

    public abstract Object Interp();

}
