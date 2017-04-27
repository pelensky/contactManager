package com.pelensky.contactmanager.Edit;

public class DefaultEditOption implements EditOption{
    @Override
    public String execute(String text) {
        return "Invalid Selection";
    }

    @Override
    public boolean canRespondTo(int number) {
        return false;
    }
}
