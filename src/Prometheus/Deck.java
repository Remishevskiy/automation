package Prometheus;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Император on 13.03.2017.
 */
/*
public class Deck {


    private Card[] cards;
    private int cardsInDeck;

    public Deck() {
        this.cards = new int[];
        this.cardsInDeck = 0;
    }

    //Перемішує колоду у випадковому порядку
    public void shuffle() {
        Collections.shuffle(cards);
    }
    */
/* * Впорядкування колоди за мастями та значеннями
    * Порядок сотрування:
    * Спочатку всі карти з мастю HEARTS, потім DIAMONDS, CLUBS, SPADES
    * для кожної масті порядок наступний: Ace,King,Queen,Jack,10,9,8,7,6
    * Наприклад
    * HEARTS Ace
    * HEARTS King
    * HEARTS Queen
    * HEARTS Jack
    * HEARTS 10
    * HEARTS 9
    * HEARTS 8
    * HEARTS 7
    * HEARTS 6
    * І так далі для DIAMONDS, CLUBS, SPADES *//*

    public void order() {
        for (int i = 0; i < Suit.values.length; i++) {
            for (int j = 0; j < Rank.values.length; j++) {
                cards.add(new Card(Rank.values[j], Suit.values[i]));
                cardsInDeck++;
            }
        }
    }

    //Повертає true у випадку коли в колоді ще доступні карти
    public boolean hasNext() {
        return cardsInDeck > 0 ? true : false;
    }

    //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
//Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
//SPADES 7, ..., CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
    public Card drawOne() {
        if (cardsInDeck < 1) return null;
        Card card = cards.remove(cardsInDeck - 1);
        cardsInDeck--;
        return card;
    } }
*/

    /*private ArrayList<Card> deck;
    private String[] Rank;
    private String[] getSuit;
    //Перемішує колоду у випадковому порядку
    public void shuffle() {

        ArrayList<Card> temp = new ArrayList<Card>();
        while(!deck.isEmpty()) {
            int loc=(int)(Math.random()*deck.size());
            temp.add(deck.get(loc));
            deck.remove(loc);
        }
        deck=temp;


    }}*/

    /* * Впорядкування колоди за мастями та значеннями
    * Порядок сотрування:
    * Спочатку всі карти з мастю HEARTS, потім DIAMONDS, CLUBS, SPADES
    * для кожної масті порядок наступний: Ace,King,Queen,Jack,10,9,8,7,6
    * Наприклад
    * HEARTS Ace
    * HEARTS King
    * HEARTS Queen
    * HEARTS Jack
    * HEARTS 10
    * HEARTS 9
    * HEARTS 8
    * HEARTS 7
    * HEARTS 6
    * І так далі для DIAMONDS, CLUBS, SPADES */
   /* public void order() {
    }

    //Повертає true у випадку коли в колоді ще доступні карти
    public boolean hasNext() {
    }

    //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
    //Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
    //SPADES 7, ..., CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
    public Card drawOne() {
    }

}*/
