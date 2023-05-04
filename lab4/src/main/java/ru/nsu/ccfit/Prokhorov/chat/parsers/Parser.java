package ru.nsu.ccfit.Prokhorov.chat.parsers;

import ru.nsu.ccfit.Prokhorov.chat.net.structures.MsgChunk;

public abstract class Parser {

    public abstract String parse(Object obj);
    public abstract String convertChunk(MsgChunk chunk);
    public abstract MsgChunk deconvertChunk(String strl);
    public abstract String deparse(String mass);
}
