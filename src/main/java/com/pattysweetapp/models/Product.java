package com.pattysweetapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "products")
public class Product {

	@Id
    private String id;
	private String prodName;
	private String prodDesc;
	private Double prodPrice;
	private String prodImage;
	private String statusType;
	private Date createdDate;
	private Date updatedDate;



	public Product() {
		this.prodName="";
		this.prodDesc="";
		this.prodPrice=0.00;
		this.prodImage="";
		this.statusType="";
		this.createdDate=null;
		this.updatedDate=null;
	}

	public Product(String prodName, String prodDesc, Double prodPrice, String prodImage,String statusType) {
		super();
		this.prodName = prodName;
		this.prodDesc = prodDesc;
		this.prodPrice = prodPrice;
		this.prodImage = prodImage;
		this.statusType=statusType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public Double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdImage() {
		return prodImage;
	}

	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
