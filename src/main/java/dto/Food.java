package dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Food{
	@Id
	private String id;
	private String name, ingredient;
	private Nutrients salt, protein, fiber, sugars, carbohydrates, saturedFat, fat, energyKcal, energy;
	private String unit, portionUnit;
	private double quantity, portionQuantity;
	
	public Nutrients getSalt() {
		return salt;
	}

	public void setSalt(Nutrients salt) {
		this.salt = salt;
	}

	public Nutrients getFiber() {
		return fiber;
	}

	public void setFiber(Nutrients fiber) {
		this.fiber = fiber;
	}

	public Nutrients getSugars() {
		return sugars;
	}

	public void setSugars(Nutrients sugars) {
		this.sugars = sugars;
	}

	public Nutrients getSaturedFat() {
		return saturedFat;
	}

	public void setSaturedFat(Nutrients saturedFat) {
		this.saturedFat = saturedFat;
	}

	public Nutrients getEnergyKcal() {
		return energyKcal;
	}

	public void setEnergyKcal(Nutrients energyKcal) {
		this.energyKcal = energyKcal;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public Nutrients getProtein() {
		return protein;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setProtein(Nutrients protein) {
		this.protein = protein;
	}
	public Nutrients getCarbohydrates() {
		return carbohydrates;
	}
	public void setCarbohydrates(Nutrients carbohydrates) {
		this.carbohydrates = carbohydrates;
	}
	public Nutrients getFat() {
		return fat;
	}
	public void setFat(Nutrients fat) {
		this.fat = fat;
	}
	public Nutrients getEnergy() {
		return energy;
	}
	public void setEnergy(Nutrients energy) {
		this.energy = energy;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPortionUnit() {
		return portionUnit;
	}
	public void setPortionUnit(String portionUnit) {
		this.portionUnit = portionUnit;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getPortionQuantity() {
		return portionQuantity;
	}
	public void setPortionQuantity(double portionQuantity) {
		this.portionQuantity = portionQuantity;
	}	
}