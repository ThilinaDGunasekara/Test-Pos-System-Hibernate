package lk.ijse.dep.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NamedNativeQuery(name="query3",query = "SELECT * FROM item")

@NamedNativeQuery(name="query4",query = "SELECT * FROM item",resultClass = Items.class)
@Entity
@Table(name="item")
public class Items {
    @Id
    private
    String itemId;
    private String description;
    private int quantityOnHand;
    private double unitPrice;

    @OneToMany(mappedBy = "order",cascade = CascadeType.PERSIST)
    private
    List<OrderDetail> orderDetails = new ArrayList<>();

    public Items(String itemId, String description, int quantityOnHand, double unitPrice) {
        this.itemId = itemId;
        this.description = description;
        this.quantityOnHand = quantityOnHand;
        this.unitPrice = unitPrice;
    }

    public Items() {
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Items{" +
                "code='" + itemId + '\'' +
                ", description='" + description + '\'' +
                ", quantityOnHand=" + quantityOnHand +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }
    public void addOrderDetail(OrderDetail orderDetail){
        orderDetail.setItems(this);
        orderDetails.add(orderDetail);
    }
}
