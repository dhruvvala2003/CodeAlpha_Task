package Task2;

import java.util.*;

public class BankingApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		
		  //<acc no. , balance>
		Map<Integer,Integer>map=new HashMap<>();
		map.put(11111,10000);
		map.put(22222, 2000);
		map.put(33333, 500);
		map.put(44444, 40000);
		
		int tmp_no=0;
		int attempt=3;
		
		
		while(attempt!=0)
		{
			System.out.println("Enter Account No. : ");
			tmp_no=sc.nextInt();
			
			if(!map.containsKey(tmp_no))
			{
				System.out.println("enter valid Account number! & Enter Yes for Re-enter");
				attempt--;
				
				System.out.println("Attempt left : "+ attempt);
				
				String tmp=sc.next();
				
				if(tmp.equals("yes") ||tmp.equals("Yes"))
				{
					continue;
				}
				else {
					System.out.println("sucessfully terminated!!!");
					
					return;
				}
			}
			else {
				break;
			}
		
		}
		
		System.out.println("enter 1 for checking bank balence");
		System.out.println("enter 2 for deposite");
		System.out.println("enetr 3 for widrawal");
		
		int operation_number=sc.nextInt();
		
		if(operation_number==1)
		{
			int balance=map.get(tmp_no);
			System.out.println(balance);
			
		}
		else if(operation_number==2)
		{
			System.out.println("enetr money to deposite!!");
			int deposite_money=sc.nextInt();
			
			int tmp_value=deposite_money+map.get(tmp_no);
			map.put(tmp_no, tmp_value);
			
			System.out.println("sucessfully deposite . New Balance ="+ tmp_value);
			
			
		}
		else if(operation_number==3)
		{
			System.out.println("enetr money to deposite!!");
			int widrawal_money=sc.nextInt();
			
			int tmp_value=map.get(tmp_no);
			
			if(tmp_value<widrawal_money)
			{
				System.out.println("You Have Not Sufficient Balance!!!");
				
			}
			else {
				tmp_value=tmp_value-widrawal_money;
				
				map.put(tmp_no, tmp_value);
				System.out.println("sucessfully Widrawal. Total Balance Left="+tmp_value);
			}
		}
		else {
			System.out.println("Select Number Among 3 only!!!");
		}
			
	}

}
