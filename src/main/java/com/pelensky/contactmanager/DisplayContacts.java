package com.pelensky.contactmanager;

class DisplayContacts {

    ContactList contactList;

    DisplayContacts(ContactList contactList){
        this.contactList = contactList;
    }


    String listContacts() {
      StringBuilder formattedContact = new StringBuilder();
      for (int i = 0; i < contactList.countContacts(); i++) {
        formattedContact.append(formatContact(i)).append("\n");
      }
      return formattedContact.toString().trim();
    }

    private String formatContact(int number) {
      Contact contact = contactList.getContacts().get(number);
      return (Integer.toString(number + 1)
              + ") "
              + contact.getFirstName()
              + " "
              + contact.getLastName()
              + "\n"
              + contact.getAddress()
              + "\n"
              + contact.getCity()
              + " "
              + contact.getPostCode()
              + "\n"
              + contact.getPhoneNumber());
    }
}
