package models;

import java.util.Arrays;

import play.api.libs.iteratee.internal;


public class Gem implements Comparable<Gem>{

	private long Id;
	private String description;
	private String color;
	private String name;
	private int shine;
	private double price;
	private int rarity;
	private int faces;
	private int quantity;


	public Gem(long id, String name, String description, String color, int shine, 
			double price, int quantity, int rarity, int faces) {

		Id = id;
		this.name=name;
		this.description = description;
		this.color = color;
		this.shine = shine;
		this.price = price;
		this.rarity = rarity;
		this.faces= faces;
		this.quantity=quantity;
	}

	public Gem(){

	}



	public long getId() {
		return Id;
	}

	public void setId(long id) {
		this.Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getShine() {
		return shine;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	public int getFaces() {
		return faces;
	}

	public void setFaces(int faces) {
		this.faces = faces;
	}

	public void setShine(int shine) {
		this.shine = shine;
	}
	//needs to be updated 
	@Override
	public String toString() {
		return "Gem [id=" + Id+ "name"+ name + ", description=" + description
				+ ", shine=" + shine + ", price=" + price + ", rarity="
				+ rarity + ", color=" + color + ", faces=" + faces + "]";
	}



	@Override
	public int compareTo(Gem arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
