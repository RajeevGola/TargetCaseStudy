package com.rajeev.productservice.model;

public class ProductSpecification {
String name;
String id;
public ProductSpecification() {
}

public ProductSpecification( String id, String name) {
	super();
	this.name = name;
	this.id = id;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

}
