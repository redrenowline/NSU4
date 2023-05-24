package ru.nsu.ccfit.Prokhorov.shared;
public abstract class Parser {

    public abstract byte[] convertChunk(Chunk chunk);
    public abstract Chunk deconvertChunk(byte[] bytes);
}
