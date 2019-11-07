package lk.ijse.dep.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @EmbeddedId
    private
    OrderDetailPK orderDetailPK;

    private int quantity;
    private double unitPrice;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "orderId",referencedColumnName = "id",insertable = false,updatable = false)
    private
    Order order;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "itemId",referencedColumnName = "itemId",insertable = false,updatable = false)
    private
    Items items;

    public OrderDetail(OrderDetailPK orderDetailPK, int quantity, double unitPrice) {
        this.orderDetailPK = orderDetailPK;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public OrderDetail(String item_code,String order_id, int quantity, double unitPrice) {
        this.setOrderDetailPK(new OrderDetailPK(item_code,order_id));
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public OrderDetail() {
    }

    public OrderDetailPK getOrderDetailPK() {
        return orderDetailPK;
    }

    public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
        this.orderDetailPK = orderDetailPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailPK=" + orderDetailPK +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", items=" + items +
                ", order=" + order +
                '}';
    }
}
