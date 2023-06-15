package ru.nsu.ccfit.Prokhorov.shared;
import java.io.*;
import java.util.Base64;

public class SerializeParser extends Parser{

    @Override
    public byte[] convertChunk(Chunk chunk) {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bao);
            oos.writeObject(chunk);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bao.toByteArray();
    }

    @Override
    public Chunk deconvertChunk(byte[] bytes) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Chunk res;
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            res = (Chunk) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

}
