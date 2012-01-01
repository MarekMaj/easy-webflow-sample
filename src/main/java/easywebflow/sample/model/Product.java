package easywebflow.sample.model;
// Generated 2012-01-01 22:49:53 by Hibernate Tools 3.4.0.CR1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name="PRODUCTS"
    ,catalog="INZ_SKLEP"
)
public class Product  implements java.io.Serializable {


     private int idProduct;
     private Category category;
     private String name;
     private double price;
     private int quantity;
     private byte[] picture;
     private Set<FeatureValue> featureValues = new HashSet<FeatureValue>(0);
     private Set<OrderItem> orderItems = new HashSet<OrderItem>(0);

    public Product() {
    }

	
    public Product(int idProduct, Category category, String name, double price, int quantity) {
        this.idProduct = idProduct;
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public Product(int idProduct, Category category, String name, double price, int quantity, byte[] picture, Set<FeatureValue> featureValues, Set<OrderItem> orderItems) {
       this.idProduct = idProduct;
       this.category = category;
       this.name = name;
       this.price = price;
       this.quantity = quantity;
       this.picture = picture;
       this.featureValues = featureValues;
       this.orderItems = orderItems;
    }
   
     @Id 

    
    @Column(name="idPRODUCT", unique=true, nullable=false)
    public int getIdProduct() {
        return this.idProduct;
    }
    
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CAT_idCategory", nullable=false)
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

    
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="price", nullable=false, precision=22, scale=0)
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    
    @Column(name="quantity", nullable=false)
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    @Column(name="picture")
    public byte[] getPicture() {
        return this.picture;
    }
    
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    public Set<FeatureValue> getFeatureValues() {
        return this.featureValues;
    }
    
    public void setFeatureValues(Set<FeatureValue> featureValues) {
        this.featureValues = featureValues;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    public Set<OrderItem> getOrderItems() {
        return this.orderItems;
    }
    
    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }




}


