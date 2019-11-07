package lk.ijse.dep.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    private
    String id;
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "customer_order",joinColumns = @JoinColumn(name = "order_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "customer_id",referencedColumnName = "id"))
    private Customer customer;

    @OneToMany(mappedBy = "order",cascade = CascadeType.PERSIST)
    private
    List<OrderDetail> orderDetails = new ArrayList<>();

    public Order(String id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", customer=" + customer +
                '}';
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }
    public void addOrderDetail(OrderDetail orderDetail){
        orderDetail.setOrder(this);
        orderDetails.add(orderDetail);
    }
}
