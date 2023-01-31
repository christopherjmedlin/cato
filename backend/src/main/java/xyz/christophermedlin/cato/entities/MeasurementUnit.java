package xyz.christophermedlin.cato.entities;

import com.fasterxml.jackson.annotation.JsonValue;

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

  @Override
  @JsonValue
  public String toString() {
    return this.str;
  }
}
