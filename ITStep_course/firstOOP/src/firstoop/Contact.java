/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstoop;

/**
 *
 * @author Student
 */
public class Contact {

    private String name, surname, phone, address;

    public Contact(String name, String surname, String phone, String address) throws Exception {

        setName(name);
        setSurname(surname);
        setPhone(phone);
        setAddress(address);
    }

    public void setSurname(String surname) throws Exception {
        if (!surname.matches("[a-zA-Z]+")) {
            throw new Exception("Chyba v zadani prijmeni!");
        }
        this.surname = surname;

    }

    public void setName(String name) throws Exception {

        if (!name.matches("[a-zA-Z]+")) {
            throw new Exception("Chyba v zadani krestniho jmena!");
        }
        this.name = name;
    }

    public void setPhone(String phone) throws Exception {

        if (!phone.matches("[0-9]+")) {
            throw new InvalidPhoneNumberException(1, phone);
        }
        this.phone = phone;

    }

    public void setAddress(String address) throws Exception {

        if (!address.matches("[A-Za-z0-9 ]+")) {
            throw new Exception("Chyba v zadani adresy!");

        }
        this.address = address;

    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }
    
    @Override
    public String toString() {
    return "Contact [" + "jmeno=" + name + ", prijmeni=" + surname + ", telefon=" + phone + ", adresa=" + address + "]";
    }

}
