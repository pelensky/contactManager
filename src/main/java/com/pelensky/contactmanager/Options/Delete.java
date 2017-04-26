package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.*;

public class Delete extends Commands implements Option {

  private IO io;
  private ContactList contactList;
  private DisplayContacts displayContacts;
  private Find find;

  public Delete(IO io, ContactList contactList, DisplayContacts displayContacts, Find find) {
    super(io, displayContacts);
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
      delete(selectedContact);
      io.displayText("Deleted");
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
