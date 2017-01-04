import java.util.ArrayList;

public class Player {
	private String name;
	private int chips;
	private int bet=0; 
	private ArrayList<Card> oneRoundCard; 
	
	public Player(String name, int chips)
	{
		this.name=name;
		this.chips=chips;
	}
	public String get_name()
	{
		return name;
	}
	public int make_bet() 
	{				
		if (chips<100)
		{
			bet=10;
		}
		 if (chips<10)
		{
			bet=1;
		}
		 if (chips <1)
		{
			bet = 0;
		}
		return bet;
	}
	public void setOneRoundCard(ArrayList<Card> cards)
	{
		
		oneRoundCard=cards;
		
		
	}
	
	public boolean hit_me()
	{
		int value = getTotalValue();
		if (value<=16)
		{
			return true;
		}
		return false;		
	}
	public int getTotalValue() 
	{
		int total = 0;
		for(int i = 0;i<oneRoundCard.size();i++)
		{
			Card oneCard = oneRoundCard.get(i);
			int value = 0;
			if(oneCard.getRank()>=10) //JQK
			{
				value = 10;
			}
			if(oneCard.getRank()<10&&oneCard.getRank()>1)
			{
				value=oneCard.getRank();
			}
			if(oneCard.getRank()==1)
			{
				if(total>10){value=1;}
				if(total<=10){value=11;}
			}
			total +=value;
		}
			if(total>21)
			{
			for(int i=0;i<oneRoundCard.size();i++)
			{
				Card oneCard=oneRoundCard.get(i);
				if(oneCard.getRank()==1)
				{
					total=total-10;
					break;
				}
			}
		}
		return total;
		
		
	}
	public int get_current_chips() 
	{
		return chips;
	}
	public void increase_chips (int diff)
	{
		chips+=diff;
	}
	public void say_hello() 
	{
		System.out.println("Hello, I am " + name + "."); 
		System.out.println("I have " + chips + " chips.");
	}
}
