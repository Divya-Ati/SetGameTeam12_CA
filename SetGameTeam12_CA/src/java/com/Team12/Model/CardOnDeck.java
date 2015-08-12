package com.Team12.Model;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;

public class CardOnDeck {

    public Card[] gameCards = new Card[81];

    public CardOnDeck getCards() {

        int counter = 0;
        String imageUrl;
        String folder = "images/";
        int imgNum = 0;
        final String[] colors = {"Red", "Purple", "Green"};
        final String[] symbols = {"Squiggle", "Diamond", "Oval"};
        final String[] shadings = {"Solid", "Striped", "Outline"};
        final int[] numbers = {1, 2, 3};

        for (String shading : shadings) {
            for (String symbol : symbols) {
                for (String color : colors) {
                    for (int number : numbers) {
                        imgNum++;
                        Card card = new Card(imgNum,color, symbol, shading, number);
                        imageUrl = folder + new DecimalFormat("00").format(imgNum) + ".gif";
                        card.setImageUrl(imageUrl);
                        gameCards[counter] = card;
                        counter++;
                    }
                }
            }
        }
        return this;
    }

    public CardOnDeck shuffleCards() {
        Collections.shuffle(Arrays.asList(gameCards));
        return this;
    }

}
