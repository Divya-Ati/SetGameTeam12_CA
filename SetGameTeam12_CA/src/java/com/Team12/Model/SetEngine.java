package com.Team12.Model;


public class SetEngine {
    public boolean isSet(Card a, Card b, Card c) {
        if (!((a.getNumber() == b.getNumber()) && (b.getNumber() == c.getNumber()) ||
                (a.getNumber() != b.getNumber()) && (a.getNumber() != c.getNumber()) && (b.getNumber() != c.getNumber()))) {
            return false;
        }
        if (!((a.getSymbol() == b.getSymbol()) && (b.getSymbol() == c.getSymbol()) ||
                (a.getSymbol() != b.getSymbol()) && (a.getSymbol() != c.getSymbol()) && (b.getSymbol() != c.getSymbol()))) {
            return false;
        }
        if (!((a.getShading() == b.getShading()) && (b.getShading() == c.getShading()) ||
                (a.getShading() != b.getShading()) && (a.getShading() != c.getShading()) && (b.getShading() != c.getShading()))) {
            return false;
        }
        if (!((a.getColor() == b.getColor()) && (b.getColor() == c.getColor()) ||
                (a.getColor() != b.getColor()) && (a.getColor() != c.getColor()) && (b.getColor() != c.getColor()))) {
            return false;
        }
        if (((a.getNumber() == b.getNumber()) && (b.getNumber() == c.getNumber()) && 
                (a.getColor() == b.getColor()) && (b.getColor() == c.getColor()) &&
                (a.getSymbol() == b.getSymbol()) && (b.getSymbol() == c.getSymbol()) &&
                (a.getShading() == b.getShading()) && (b.getShading() == c.getShading())
                )) {
            return false;
        }
        return true;
      
    }
    
}
