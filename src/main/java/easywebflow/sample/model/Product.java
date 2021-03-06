package easywebflow.sample.model;
// Generated 2012-01-13 09:00:41 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Product generated by hbm2java
 * Modified: new method to support Richfaces
 * Modified: EAGER for feature values
 */
@Entity
@Table(name="PRODUCTS"
    ,catalog="INZ_SKLEP"
)
public class Product  implements java.io.Serializable {


     private Integer idProduct;
     private Category category;
     private String name;
     private BigDecimal price;
     private int quantity;
     private byte[] picture;
     private Set<FeatureValue> featureValues = new HashSet<FeatureValue>(0);
     private Set<OrderItem> orderItems = new HashSet<OrderItem>(0);

    public Product() {
    }

	
    public Product(Category category, String name, BigDecimal price, int quantity) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public Product(Category category, String name, BigDecimal price, int quantity, byte[] picture, Set<FeatureValue> featureValues, Set<OrderItem> orderItems) {
       this.category = category;
       this.name = name;
       this.price = price;
       this.quantity = quantity;
       this.picture = picture;
       this.featureValues = featureValues;
       this.orderItems = orderItems;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idPRODUCT", unique=true, nullable=false)
    public Integer getIdProduct() {
        return this.idProduct;
    }
    
    public void setIdProduct(Integer idProduct) {
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

    
    @Column(name="price", nullable=false, precision=6)
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
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

@OneToMany(fetch=FetchType.EAGER, mappedBy="product")
    public Set<FeatureValue> getFeatureValues() {
        return this.featureValues;
    }
    
    public void setFeatureValues(Set<FeatureValue> featureValues) {
        this.featureValues = featureValues;
    }

    /* added to support RichFaces*/
    public List<FeatureValue> getFeatureValuesList(){
    	return new ArrayList<FeatureValue>(this.featureValues);
    }
    
@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    public Set<OrderItem> getOrderItems() {
        return this.orderItems;
    }
    
    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }




}


