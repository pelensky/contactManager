package com.pelensky.contactmanager.Find;

public interface FindOption {
    void execute();
    boolean canRespondTo(int number);
}
