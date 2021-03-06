package easywebflow.sample.model;
// Generated 2012-01-13 09:00:41 by Hibernate Tools 3.4.0.CR1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CategoryFeatureId generated by hbm2java
 */
@Embeddable
public class CategoryFeatureId  implements java.io.Serializable {


     private int catIdCategory;
     private int featIdFeature;

    public CategoryFeatureId() {
    }

    public CategoryFeatureId(int catIdCategory, int featIdFeature) {
       this.catIdCategory = catIdCategory;
       this.featIdFeature = featIdFeature;
    }
   


    @Column(name="CAT_idCategory", nullable=false)
    public int getCatIdCategory() {
        return this.catIdCategory;
    }
    
    public void setCatIdCategory(int catIdCategory) {
        this.catIdCategory = catIdCategory;
    }


    @Column(name="FEAT_idFeature", nullable=false)
    public int getFeatIdFeature() {
        return this.featIdFeature;
    }
    
    public void setFeatIdFeature(int featIdFeature) {
        this.featIdFeature = featIdFeature;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CategoryFeatureId) ) return false;
		 CategoryFeatureId castOther = ( CategoryFeatureId ) other; 
         
		 return (this.getCatIdCategory()==castOther.getCatIdCategory())
 && (this.getFeatIdFeature()==castOther.getFeatIdFeature());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getCatIdCategory();
         result = 37 * result + this.getFeatIdFeature();
         return result;
   }   


}


