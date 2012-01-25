package easywebflow.sample.model;
// Generated 2012-01-13 09:00:41 by Hibernate Tools 3.4.0.CR1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FeatureValueId generated by hbm2java
 */
@Embeddable
public class FeatureValueId  implements java.io.Serializable {


     private int prodIdProduct;
     private int catfeatIdCategory;
     private int catfeatIdFeature;

    public FeatureValueId() {
    }

    public FeatureValueId(int prodIdProduct, int catfeatIdCategory, int catfeatIdFeature) {
       this.prodIdProduct = prodIdProduct;
       this.catfeatIdCategory = catfeatIdCategory;
       this.catfeatIdFeature = catfeatIdFeature;
    }
   


    @Column(name="PROD_idPRODUCT", nullable=false)
    public int getProdIdProduct() {
        return this.prodIdProduct;
    }
    
    public void setProdIdProduct(int prodIdProduct) {
        this.prodIdProduct = prodIdProduct;
    }


    @Column(name="CATFEAT_idCategory", nullable=false)
    public int getCatfeatIdCategory() {
        return this.catfeatIdCategory;
    }
    
    public void setCatfeatIdCategory(int catfeatIdCategory) {
        this.catfeatIdCategory = catfeatIdCategory;
    }


    @Column(name="CATFEAT_idFeature", nullable=false)
    public int getCatfeatIdFeature() {
        return this.catfeatIdFeature;
    }
    
    public void setCatfeatIdFeature(int catfeatIdFeature) {
        this.catfeatIdFeature = catfeatIdFeature;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FeatureValueId) ) return false;
		 FeatureValueId castOther = ( FeatureValueId ) other; 
         
		 return (this.getProdIdProduct()==castOther.getProdIdProduct())
 && (this.getCatfeatIdCategory()==castOther.getCatfeatIdCategory())
 && (this.getCatfeatIdFeature()==castOther.getCatfeatIdFeature());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getProdIdProduct();
         result = 37 * result + this.getCatfeatIdCategory();
         result = 37 * result + this.getCatfeatIdFeature();
         return result;
   }   


}


