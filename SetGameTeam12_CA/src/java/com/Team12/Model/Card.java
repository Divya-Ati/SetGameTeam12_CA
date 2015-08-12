package com.Team12.Model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.validation.constraints.NotNull;

public class Card  {
    @NotNull
    private int id;
    
    @NotNull
    private String Shading;
    
    @NotNull
    private String Symbol;
    
    @NotNull
    private String Color;
    
    @NotNull
    private int Number;
    
    @NotNull
    private String imageUrl;
    
    public String getShading() {
        return Shading;
    }

    public void setShading(String Shading) {
        this.Shading = Shading;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String Symbol) {
        this.Symbol = Symbol;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public Card() {
    }

    public Card(int id,String Color, String Symbol, String Shading, int Number) {
        this.id=id;
        this.Color = Color;
        this.Symbol = Symbol;
        this.Shading = Shading;
        this.Number = Number;
    }

     public JsonObject toJson(){
        return(Json.createObjectBuilder()
                .add("id", id)
                .add("shading", Shading)
                .add("symbol", Symbol)
                .add("Color", Color)
                .add("number", Number)
                .add("imageUrl", imageUrl)
                .build());
    }
     
    @Override
    public String toString() {
        return "Card{" + "Shading=" + Shading + ", Symbol=" + Symbol + ", Color=" + Color + ", Number=" + Number + '}';
    }
 
}
