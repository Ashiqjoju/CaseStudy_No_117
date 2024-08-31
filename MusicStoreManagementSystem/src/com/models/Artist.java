package com.models;

public class Artist {
	private int artistId;
    private String name;
    private String genre;
    private String country;
	public Artist(int artistId, String name, String genre, String country) {
		super();
		this.artistId = artistId;
		this.name = name;
		this.genre = genre;
		this.country = country;
	}
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", name=" + name + ", genre=" + genre + ", country=" + country + "]";
	}
    
}
