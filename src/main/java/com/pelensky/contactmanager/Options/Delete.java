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
    return "5) Delete a contact";
  }

  @Override
  public void execute() {
    if (displayContacts.isContactListEmpty()) {
      io.displayText("No contacts to delete");
    } else {
      io.displayText("Delete a contact");
      DeleteContact deleteContact = new DeleteContact(contactList);
      int selectedContact = selectContactTo("delete");
      if (displayContacts.isNotAValidNumber(selectedContact)) {
        io.displayText("Contact does not exist\nTry again");
      } else {
        delete(deleteContact, selectedContact);
        io.displayText("Deleted");
      }
    }
  }


  @Override
  public boolean canRespondTo(String text)
  {
    return text.equals("5");
  }

  private void delete(DeleteContact deleteContact, int selectedContact) {
    deleteContact.delete(selectedContact);
  }
}
