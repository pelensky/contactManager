package com.pelensky.contactmanager.Options;

public interface Option {
    void execute();
    boolean canRespondTo(String text);
    String instruction();
}