package lk.ijse.dep.entity;

import java.sql.Date;

public class CustomEntity {

    private System order_id;
    private Date order_date;
    private String customer_id;
    private String customer_name;
    private double total;

    public CustomEntity(System order_id, Date order_date, String customer_id, String customer_name, double total) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.total = total;
    }

    public CustomEntity() {
    }

    public System getOrder_id() {
        return order_id;
    }

    public void setOrder_id(System order_id) {
        this.order_id = order_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CustomEntity{" +
                "order_id=" + order_id +
                ", order_date=" + order_date +
                ", customer_id='" + customer_id + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
