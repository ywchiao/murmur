package edu.fgu.dclab.murmur;

public interface MessageSource {
    String readMessage();

    void connectSink(MessageSink sink);
}
