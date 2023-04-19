package ru.nsu.ccfit.Prokhorov.chat.parsers;

public abstract class Parser {

    public abstract String parse(Object obj);
    public abstract String deparse(String mass);
}
