package edu.ib;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private ArrayList<Card> deck;
    private String backOfCardImage;

    //1. define the class
    //2. define the instance variables
    //3. create Constructor - this will define the object in the system
    //4. create get/set methods
    //5. create any custom methods


    /**
     * This is a 1 argument constructor that passes in a collection
     * of Card objects
     * @param deck
     */
    public DeckOfCards(ArrayList<Card> deck) {
        this.deck = deck;
        backOfCardImage = "/fxml/images/backOfCard.png";
        //backOfCardImage=new Image(getClass().getResourceAsStream("/edu/ib/images/red_joker.png"));
    }

    /**
     * This is a zero argument constructor that will build a full Deck of Cards
     */
    public DeckOfCards()
    {
        List<String> suits = Card.getValidSuits(); //this is calling a static method
                                                    //so we do NOT need an instance of Card
                                                    //to call it
        List<String> faceNames = Card.getValidFaceNames();

        deck = new ArrayList<>();

        for (String suit:suits)
        {
            for (String faceName:faceNames)
                deck.add(new Card(faceName,suit));
        }
        backOfCardImage = "/fxml/images/backOfCard.png";
        //backOfCardImage = new Image("file:/fxml/images/red_joker.png");
        //backOfCardImage=new Image(getClass().getResourceAsStream("/edu/ib/images/red_joker.png"));

    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public String getBackOfCardImage() {
        return backOfCardImage;
    }

    public void setBackOfCardImage(String backOfCardImage) {
        this.backOfCardImage = backOfCardImage;
    }

    /**
     * This method will "deal" the top card off the deck
     */
    public Card dealTopCard()
    {
        if (deck.size()>0)
            return deck.remove(0);
        else
            return null;
    }

    /**
     * This method will shuffle the deck of cards
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
}
