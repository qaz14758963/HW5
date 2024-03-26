package wh5;

import java.util.Scanner;

public class hw5 {

	public static void main(String[] args) {
		var card1=new StoreValueCard("ntunhs001",500,0);
		int loop = 0;
		while(loop==0) {
		loop=0;
		System.out.print("請輸入以下指令：1. 儲值 2. 扣款 3.兌換紅利 4. 查看明細 0. 離開系統:");
		var scanner =new Scanner(System.in);
		var menu=scanner.nextInt();
		if(menu==0) {
			System.out.println(" 離開系統");
			loop=1;
		}
		else if(menu==1) {
			
			System.out.print("請輸入儲值金額:");
			int money=scanner.nextInt();
			card1.addValue(money);
			card1.printDetails();
			
		}
		else if(menu==2) {
			
			System.out.print("請輸入扣款金額:");
			int money=scanner.nextInt();
			card1.charge(money);
			card1.printDetails();
			
		}
		else if(menu==3) {
			
			System.out.print("請輸入兌換紅利:");
			int money=scanner.nextInt();
			card1.exchangeBonus(money);
			card1.printDetails();
			
		}
		else if(menu==4) {
			
			
			card1.printDetails();
		}
		else{
			System.out.print("錯誤指令");
		}
		
		
		
		
		
		
		

		
		
		
	}

}

	}
class StoreValueCard {
	static int totalCardNum=0;
	
	public int meun;
	
	private String cardld;
	private int balance;
	private int bonus;
	StoreValueCard(String cardld ,int balance,int bonus){
			this.cardld=cardld;
			this.balance=balance;
			this.bonus=bonus;
			totalCardNum++;
		
	}
	  void addValue(int money) {
		if(money>0) {
			this.balance +=money;
			if(money>=1000) {
				this.bonus++;
				
			}
		}
		else {
			System.out.println("請確認儲值金額不能為負值");
		}
		
	}
	void charge(int money) {
		if(money >0) {
			if(money <this.balance) {
				this.balance -=money;
				
			}
			else {
				System.out.println("餘額不足請除值");
			}
			
		}
		else {
			System.out.println("請確認儲值金額不能為負值");
		}
	}
	void exchangeBonus (int bonus) {
		if(bonus>0) {
			if(bonus <this.bonus) {
				this.bonus-=bonus;
			}
			else {
				System.out.println("紅利不足無法兌換");
			}
		}
		else {
			System.out.println("請確認紅利不能為負值");
		}
	}
	void printDetails() {
		System.out.printf("(%s, %d, %d)%n",this.cardld, this.balance, this.bonus);
	}
	int getBalance(){
		return balance;
	}
	int getBonus(){
		return bonus;
	}
	String getNumber(){
		return cardld;
	}
}