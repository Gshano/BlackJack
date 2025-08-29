package coe318.lab5;

public class Card implements Comparable {
  // Symbolic constants
  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;

  int rank;
  int suit;
  boolean direction;

  public Card(int rank, int suit, boolean faceUp) {
    this.rank = rank;
    this.suit = suit;
    this.direction = faceUp;
  }

  /**
   * @return whether the card is face up
   */
  public boolean isFaceUp() {
    return this.direction;
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
    this.direction = faceUp;
  }

  /**
   * @return the rank
   */
  public int getRank() {
    return this.rank;
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return this.suit;
  }

  @Override
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) {
      return false;
    }
    Card c = (Card) ob;
    return this.rank == c.rank && this.suit == c.suit;
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }
  
    @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }
  
  public int compareTo(Card c) {
    // Compare based on rank first, then suit
    if (this.rank != c.rank) {
      return this.rank - c.rank;
    } else {
      return this.suit - c.suit;
    }
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() {
      return switch (this.rank) {
          case 11 -> "Jack";
          case 12 -> "Queen";
          case 13 -> "King";
          case 14 -> "Ace";
          default -> String.valueOf(this.rank);
      };
  }

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() {
      return switch (this.suit) {
          case CLUB -> "Clubs";
          case DIAMOND -> "Diamonds";
          case HEART -> "Hearts";
          case SPADE -> "Spades";
          default -> "Unknown";
      };
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {
    if (!this.direction) {
      return "?";
    }
    return getRankString() + " of " + getSuitString();
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, CLUB, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: " + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: " + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: " + club5.equals(spadeAce));
    System.out.println("club5 equals club5: " + club5.equals(club5));
  }
}
