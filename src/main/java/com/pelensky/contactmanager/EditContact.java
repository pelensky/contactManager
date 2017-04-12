package com.pelensky.contactmanager;


class EditContact {

    private ContactList contactList;
    private Contact contact;

    EditContact(ContactList contactList){
        this.contactList = contactList;
    }

    private Contact getContact(int number) {
        return contact =  contactList.getContacts().get(number - 1);
    }

    private String formatDisplay() {
        return "1)" + contact.getFirstName() + "\n2)" + contact.getLastName() + "\n3)" + contact.getAddress() + "\n4)" + contact.getCity() + "\n5)" + contact.getPostCode() + "\n6)" + contact.getPhoneNumber();
    }

    String showSelectionNumbers(int number) {
        contact = getContact(number);
        return formatDisplay();
    }

    String selectField(int number) {
        switch (number) {
            case 1: return contact.getFirstName();
            case 2: return contact.getLastName();
            case 3: return contact.getAddress();
            case 4: return contact.getCity();
            case 5: return contact.getPostCode();
            case 6: return contact.getPhoneNumber();
            default: return "I didn't get that";
        }
    }

    void updateContact(int number, String updatedField) {
        switch (number) {
            case 1: contact.setFirstName(updatedField);
            break;
            case 2: contact.setLastName(updatedField);
            break;
            case 3: contact.setAddress(updatedField);
            break;
            case 4: contact.setCity(updatedField);
            break;
            case 5: contact.setPostCode(updatedField);
            break;
            case 6: contact.setPhoneNumber(updatedField);
            break;
        }
    }


}