package com.pelensky.contactmanager;

public class Delete extends Commands implements Option {

  private IO io;
  private ContactList contactList;

  Delete(IO io, ContactList contactList) {
    super(io, contactList);
    this.io = io;
    this.contactList = contactList;
  }

  @Override
  public void execute() {
    if (isContactListEmpty()) {
      io.displayText("No contacts to delete");
    } else {
      io.displayText("Delete a contact");
      DeleteContact deleteContact = new DeleteContact(contactList);
      int selectedContact = selectContactTo("delete");
      if (isNotAValidNumber(selectedContact)) {
        io.displayText("Contact does not exist\nTry again");
      } else {
        delete(deleteContact, selectedContact);
        io.displayText("Deleted");
      }
    }
  }

  @Override
  public boolean canRespondTo(String text) {
    return text.equals("delete");
  }

  private void delete(DeleteContact deleteContact, int selectedContact) {
    deleteContact.delete(selectedContact);
  }
}
