package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.*;

public class Delete extends Commands implements Option {

  private IO io;
  private ContactList contactList;
  private DisplayContacts displayContacts;

  public Delete(IO io, ContactList contactList, DisplayContacts displayContacts) {
    super(io, contactList, displayContacts);
    this.io = io;
    this.contactList = contactList;
    this.displayContacts = displayContacts;
  }

  public String instruction() {
    return "4) Delete a contact";
  }

  @Override
  public void execute() {
    if (displayContacts.isContactListEmpty()) {
      io.displayText("No contacts to deleteContact");
    } else {
      io.displayText("Delete a contact");
      int selectedContact = selectContactTo("deleteContact");
      if (displayContacts.isNotAValidNumber(selectedContact)) {
        io.displayText("Contact does not exist\nTry again");
      } else {
        delete(selectedContact);
        io.displayText("Deleted");
      }
    }
  }


  @Override
  public boolean canRespondTo(String text)
  {
    return text.equals("4");
  }

  private void delete(int selectedContact) {
    contactList.deleteContact(selectedContact);
  }
}
