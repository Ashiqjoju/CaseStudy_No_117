package com.models;

public class Sales {
	private int saleId;
    private int albumId;
    private String saleDate;
    private int quantitySold;
    private double totalPrice;
	public Sales(int saleId, int albumId, String saleDate, int quantitySold, double totalPrice) {
		super();
		this.saleId = saleId;
		this.albumId = albumId;
		this.saleDate = saleDate;
		this.quantitySold = quantitySold;
		this.totalPrice = totalPrice;
	}
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Sales [saleId=" + saleId + ", albumId=" + albumId + ", saleDate=" + saleDate + ", quantitySold="
				+ quantitySold + ", totalPrice=" + totalPrice + "]";
	}
    
}
