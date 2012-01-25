package easywebflow.sample.model;
// Generated 2012-01-13 09:00:41 by Hibernate Tools 3.4.0.CR1


import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.AssertTrue;

/**
 * User generated by hbm2java
 * Modified by adding @Named
 * Modified by adding NamedQuery
 * Modified: added password2
 * Modified hash method added
 * Modified setPassword modified
 * Modified assert true
 */
@Entity
@Table(name="USERS"
    ,catalog="INZ_SKLEP"
    , uniqueConstraints = @UniqueConstraint(columnNames="login") 
)
@Named
@NamedQuery(name=User.FIND_BY_LOGIN, query="select u from User u where u.login = :login")
public class User implements java.io.Serializable {

	public static final String FIND_BY_LOGIN = "User.findUserByLogin";


     private Integer idUser;
     private String login;
     private String password;
     
     private String password2;
     private String name;
     private String address;
     private String name2;
     private Boolean sex;
     private String hobby;
     private Set<Order> orders = new HashSet<Order>(0);

     
    @Transient 
    @AssertTrue(message = "Hasła nie zgadzają się.")
 	public boolean isPasswordsEquals(){
 		return password.equals(password2);
 	}
     
    public User() {
    }

	
    public User(String login, String password, String name, String address) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.address = address;
    }
    public User(String login, String password, String name, String address, String name2, Boolean sex, String hobby, Set<Order> orders) {
       this.login = login;
       this.password = password;
       this.name = name;
       this.address = address;
       this.name2 = name2;
       this.sex = sex;
       this.hobby = hobby;
       this.orders = orders;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idUSER", unique=true, nullable=false)
    public Integer getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    
    @Column(name="login", unique=true, nullable=false, length=45)
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    
    @Column(name="password", nullable=false, length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
    	this.password = hashWithMD5(password);
    }

    @Transient
    public String getPassword2() {
		return password2;
	}
    
    public void setPassword2(String password2) {
		this.password2 = hashWithMD5(password2);
	}
    
    private String hashWithMD5(String password) {
		String result = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] passByte = password.getBytes(Charset.forName("UTF8"));
			byte[] resultByte = messageDigest.digest(passByte);

			BigInteger bigInt = new BigInteger(1,resultByte);
			result = bigInt.toString(16);
			// Now we need to zeros to the full 32 chars
			while(result.length() < 32 ){
				result = "0"+result;
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
    
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="address", nullable=false, length=45)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="name2", length=45)
    public String getName2() {
        return this.name2;
    }
    
    public void setName2(String name2) {
        this.name2 = name2;
    }

    
    @Column(name="sex")
    public Boolean getSex() {
        return this.sex;
    }
    
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    
    @Column(name="hobby", length=45)
    public String getHobby() {
        return this.hobby;
    }
    
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Order> getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }




}


