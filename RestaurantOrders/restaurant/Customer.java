package restaurant;

import java.util.Objects;

public class Customer {
    private static int newId = 1;
    private int id;
    private String name;
    private Address address;

    public Customer(String name, Address address) throws Exception {
        this.id = newId;
        newId++;
        this.setName(name);
        this.setAddress(address);
    }

    public int getCustomerNumber() {
        return this.id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) throws Exception {
        if (name == null || name.isEmpty())
            throw new Exception("name is Empty");
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) throws Exception{
        this.address = Objects.requireNonNull(address, "address must not be null");
    }
}
