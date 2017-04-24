package com.pelensky.contactmanager;

public class Delete extends Commands implements Option {

  private IO io;
  private ContactList contactList;
  private ManipulateContacts manipulateContacts;

  Delete(IO io, ContactList contactList, ManipulateContacts manipulateContacts) {
    super(io, contactList, manipulateContacts);
    this.io = io;
    this.contactList = contactList;
    this.manipulateContacts = manipulateContacts;
  }

  public String instruction() {
    return "5) Delete a contact";
  }

  @Override
  public void execute() {
    if (manipulateContacts.isContactListEmpty()) {
      io.displayText("No contacts to delete");
    } else {
      io.displayText("Delete a contact");
      DeleteContact deleteContact = new DeleteContact(contactList);
      int selectedContact = selectContactTo("delete");
      if (manipulateContacts.isNotAValidNumber(selectedContact)) {
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
