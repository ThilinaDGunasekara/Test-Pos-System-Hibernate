package lk.ijse.dep.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(name="query1",query = "SELECT c FROM Customer c")
@NamedQuery(name = "query2", query = "SELECT c FROM Customer c WHERE c.id =?1")

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private
    String id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private
    List<Order> orders = new ArrayList<>();

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }


    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order){
        order.setCustomer(this);
        getOrders().add(order);
    }

    public void removeOrder(Order order){
        if(order.getCustomer() != this){
            throw new RuntimeException("Invalid Order");
        }

        order.setCustomer(null);
        this.getOrders().remove(order);
    }
}
