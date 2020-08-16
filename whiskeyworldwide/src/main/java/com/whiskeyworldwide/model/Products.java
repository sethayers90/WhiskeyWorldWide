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
	private int bbqness;
	private int fruityness;
	private int spicyness;
	private int sweetness;
    private String description;
    private String url;
	
	public int getBbqness() {
		return bbqness;
	}
	public void setBbqness(int bbqness) {
		this.bbqness = bbqness;
	}
	public int getFruityness() {
		return fruityness;
	}
	public void setFruityness(int fruityness) {
		this.fruityness = fruityness;
	}
	public int getSpicyness() {
		return spicyness;
	}
	public void setSpicyness(int spicyness) {
		this.spicyness = spicyness;
	}
	public int getSweetness() {
		return sweetness;
	}
	public void setSweetness(int sweetness) {
		this.sweetness = sweetness;
	}

    
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

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	@Override
	public String toString() {
		return "Products [id=" + id + ", manufacturer=" + manufacturer + ", name=" + name + ", price=" + price
				+ ", description=" + description + ", url=" + url + ", files=" + Arrays.toString(files) + "]";
	}


	
	
    
    
    
}