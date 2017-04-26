package com.pelensky.contactmanager.Find;

import com.pelensky.contactmanager.ContactList;
import com.pelensky.contactmanager.IO;
import com.pelensky.contactmanager.DisplayContacts;

public class Show implements FindOption {

  private IO io;
  private DisplayContacts displayContacts;

  public Show(IO io, DisplayContacts displayContacts) {
    this.io = io;
    this.displayContacts = displayContacts;
  }

  @Override
  public void execute() {
    if (isContactListEmpty()) {
      io.displayText("No contacts to show");
    } else {
      io.displayText("Show all contacts");
      io.displayText(listContacts());
    }
  }

  @Override
  public boolean canRespondTo(int number) {
    return number == 2;
  }

  private boolean isContactListEmpty() {
    return displayContacts.isContactListEmpty();
  }

  private String listContacts(){
      return displayContacts.listContacts(displayContacts.getContacts());
  }
}
