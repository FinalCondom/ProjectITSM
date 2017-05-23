package dto;

public class Nutrients {
	
	private String unit, name;
	private double perHundred, perPortion, perDay;

	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPerHundred() {
		return perHundred;
	}
	public void setPerHundred(double perHundred) {
		this.perHundred = perHundred;
	}
	public double getPerPortion() {
		return perPortion;
	}
	public void setPerPortion(double perPortion) {
		this.perPortion = perPortion;
	}
	public double getPerDay() {
		return perDay;
	}
	public void setPerDay(double perDay) {
		this.perDay = perDay;
	}
	@Override
	public String toString() {
		return "NutrientsFrench [unit=" + unit + ", name=" + name + ", perHundred=" + perHundred + ", perPortion="
				+ perPortion + ", perDay=" + perDay + "]";
	}
}
