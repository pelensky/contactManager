package com.pelensky.contactmanager.Find;

public class DefaultFindOption implements FindOption{

    @Override
    public void execute() {}

    @Override
    public boolean canRespondTo(int number) {
        return false;
    }

}
