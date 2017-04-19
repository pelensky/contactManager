package com.pelensky.contactmanager;

public interface Option {
    void execute();
    boolean canRespondTo(String text);
}