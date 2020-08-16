package com.whiskeyworldwide.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="products")
public class Products {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String manufacturer;   
    private String name;
    private double price;
	private int bbq;
	private int fruity;
	private int spicy;
	private int sweet;
    private String url;
	


    
    //@OneToMany(mappedBy = "products", cascade = CascadeType.REMOVE)	
	
    
    
    
    @Transient
	private MultipartFile[] files;
    
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public MultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getBbq() {
		return bbq;
	}
	public void setBbq(int bbq) {
		this.bbq = bbq;
	}
	public int getFruity() {
		return fruity;
	}
	public void setFruity(int fruity) {
		this.fruity = fruity;
	}
	public int getSpicy() {
		return spicy;
	}
	public void setSpicy(int spicy) {
		this.spicy = spicy;
	}
	public int getSweet() {
		return sweet;
	}
	public void setSweet(int sweet) {
		this.sweet = sweet;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", manufacturer=" + manufacturer + ", name=" + name + ", price=" + price
				+ ", bbq=" + bbq + ", fruity=" + fruity + ", spicy=" + spicy + ", sweet=" + sweet + ", url=" + url
				+ ", files=" + Arrays.toString(files) + "]";
	}



	
	
    
    
    
}