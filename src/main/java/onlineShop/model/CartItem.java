package onlineShop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "cartitem")
public class CartItem implements Serializable{
	private static final long serialVersionUID = -3177259935948351753L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	private int quantity;
	private double price;
	
	@OneToOne
	private Product product;
	
	@ManyToOne
	@JsonIgnore
	private Cart cart;

	
	
}
