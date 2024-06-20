package com.burgertracker.burgertracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Burger")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Burger name must not be blank")
    private String name;

    @NotNull
    @Size(min = 1, max = 100, message = "Restaurant name must not be blank")
    private String restaurant;
    
    @NotNull
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be no more than 5")
    private int rating;

    @NotNull
    @Size(min=1, max=255, message = "Notes must not be blank")
    private String notes;
    
    public Burger() {
    	
    }

	public Burger(String name, String restaurant, int rating, String notes) {
		super();
		this.name = name;
		this.restaurant = restaurant;
		this.rating = rating;
		this.notes = notes;
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

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Burger [id=" + id + ", name=" + name + ", restaurant=" + restaurant + ", rating=" + rating + ", notes="
				+ notes + "]";
	}
    
    
}
