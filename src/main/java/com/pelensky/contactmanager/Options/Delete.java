package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.DomainModels.Contact;
import com.pelensky.contactmanager.DomainModels.ContactList;
import com.pelensky.contactmanager.DomainServices.DisplayContacts;

public class Delete implements Option {

  private IO io;
  private ContactList contactList;
  private DisplayContacts displayContacts;
  private Find find;

  public Delete(IO io, ContactList contactList, DisplayContacts displayContacts, Find find) {
    this.io = io;
    this.contactList = contactList;
    this.displayContacts = displayContacts;
    this.find = find;
  }

  public String instruction() {
    return "4) Delete a contact";
  }

  @Override
  public void execute() {
    if (displayContacts.isContactListEmpty()) {
      io.displayText("No contacts to delete");
    } else {
      io.displayText("Delete a contact");
      int selection = find.getChoiceForSearch();
      Contact selectedContact = find.findForManipulation(selection);
      if (selectedContact != null) {
        delete(selectedContact);
        io.displayText("Deleted");
      } else {
        io.displayText("Try again");
      }
    }
    }


  @Override
  public boolean canRespondTo(String text)
  {
    return text.equals("4");
  }

  private void delete(Contact selectedContact) {
    contactList.deleteContact(selectedContact);
  }
}
