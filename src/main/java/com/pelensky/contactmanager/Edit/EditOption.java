package com.pelensky.contactmanager.Edit;

public interface EditOption {
    String execute(String text);
    boolean canRespondTo(int number);
}
