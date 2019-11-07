package lk.ijse.dep.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class OrderDetailPK implements Serializable {


    private String orderId;
    private String itemId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public OrderDetailPK(String orderId, String itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    public OrderDetailPK() {
    }

    @Override
    public String toString() {
        return "OrderDetailPK{" +
                "orderId='" + orderId + '\'' +
                ", itemId='" + itemId + '\'' +
                '}';
    }
}
