package com.web.client.models;


import lombok.Data;

import java.util.List;

@Data
public class Category {
	private int categoryId;
	
	private String categoryName;
	
	private List<Product> products;


}
