package com.pelensky.contactmanager;

public class Delete extends Commands implements Option {

  private IO io;
  private ContactList contactList;

  Delete(IO io, ContactList contactList) {
    super(io, contactList);
    this.io = io;
    this.contactList = contactList;
  }

  public String instruction() {
    return "4) Delete a contact";
  }

  @Override
  public void execute() {
    if (this.contactList.isContactListEmpty()) {
      io.displayText("No contacts to delete");
    } else {
      io.displayText("Delete a contact");
      DeleteContact deleteContact = new DeleteContact(contactList);
      int selectedContact = selectContactTo("delete");
      if (this.contactList.isNotAValidNumber(selectedContact)) {
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
    return text.equals("4");
  }

  private void delete(DeleteContact deleteContact, int selectedContact) {
    deleteContact.delete(selectedContact);
  }
}
