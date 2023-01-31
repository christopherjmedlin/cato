package xyz.christophermedlin.cato.entities;

public enum MeasurementUnit {
  MILILITER("mL"),
  LITER("L"),
  TEASPOON("tsp"),
  TABLESPOON("tbsp"),
  FLUID_OUNCE("fl oz"),
  CUP("cups"),
  PINT("pt"),
  GALLON("gal"),
  MILIGRAM("mg"),
  GRAM("g"),
  KILOGRAM("kg"),
  POUND("lb"),
  OUNCE("oz");

  private String str;

  private MeasurementUnit(String str) {
    this.str = str;
  }

  public String toString() {
    return this.str;
  }
}
