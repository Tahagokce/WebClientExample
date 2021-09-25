package com.web.client.models;

import lombok.Data;

@Data
public class Product {
	

		private int id;

		private String productName;
	    
		private double unitPrice;
	    
		private short unitsInStock;
	    
		private String quantityPerUnit;
	    
	    private Category category;

}
