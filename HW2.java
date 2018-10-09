import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here b0544216 林佩璇
 * * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 所有的排
	 * @param nDeck 總共有給副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here 幾副牌deck,花色flower，幾張牌num (同花色)
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points) 
	public Deck(int nDeck){
		        //1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
				//Hint: Use new Card(x,y) and  3 for loops to add card into deck
				//Sample code start
				//Card card=new Card(1,1); ->means new card as clubs ace
				//cards.add(card);
				//Sample code end
		cards=new ArrayList<Card>();
	  int deck,flower,num;
	  for(deck=0;deck<nDeck;deck++) 
	  {
		  for(flower=1;flower<=4;flower++)
		  {
			  for(num=1;num<=13;num++)
			  {
				  Card card=new Card (flower,num);
				  cards.add(card);
			  }
			  
		  }
		  
	  }
		
		 

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
       int deck;
       for(deck=0;deck<cards.size();deck++)
       {
    	   Card poker=cards.get(deck);
    	   poker.printCard();
    	   
       }
       
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here加入2個陣列，一個是花色的，一個是牌數的
 */
class Card{
	private int suit; //花色Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13牌數
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		String suitarray[]={"Clubs","Diamonds","Hearts","Spades"};
		String rankarray[]= {"Ace","2","3","4","5","6","7","8","9","10","J","Q","k"};
		System.out.println(suitarray[suit-1]+","+rankarray[rank-1]);
		
		//Hint: print (System.out.println) card	 as suit,rank, for example: print 1,1 as Clubs Ace

	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
