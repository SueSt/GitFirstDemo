
public class Array {

	public static void main(String[] args) {
// Question1: Write a program to print the following pattern for loop:
/*
 * 00 01 02 03 04 05 06 07 07 09
 * 10 11 12 13 14 15 16 17 18 19
 * 20 21 22 23 24 25 26 27 28 29
 * 30 32 32 33 34 35 36 37 38 39
 * 
 */
 
		for (int i=0; i<=39; i++) {
			System.out.println(i);
		}
		
/*Question2: Write a program to create a static Array, having following cricket data:
 * --name, age, teamname, DOB, gender, Strike rate
 * --try to create multiple Object Arrays for different players
 * --try to print all the values of each player on the console:	
 */
		
		Object player1[]= new Object[6];
		player1[0]= "John";
		player1[1]= 25;
		player1[2]= "Dream";
		player1[3]= 12/29/1980;
		player1[4]= "M";
		player1[5]= "60%";
		
		Object player2[]= new Object[6];
		player2[0]= "Sam";
		player2[1]= 26;
		player2[2]= "Dream";
		player2[3]= 1/23/1980;
		player2[4]= "M";
		player2[5]= "50%";

		
		
		Object player3[]= new Object[6];
		player3[0]= "David";
		player3[1]= 25;
		player3[2]= "Dream";
		player3[3]= 1/20/1980;
		player3[4]= "M";
		player3[5]= "70%";
		
		for(int i=0; i<player1.length; i++) {
			System.out.println(player1[i]);	
		}
		
		for(int j=0; j<player2.length; j++) {
			System.out.println(player2[j]);	
		}
		
		for(int k=0; k<player3.length; k++) {
			System.out.println(player3[k]);	
		}
		
/*
 * Question3: Try to print the following pattern on the console:
 * n=4
 * n=3
 * n=2
 * n=1
 * n=0
 * 
 */
		int n[]= new int[5];
		n[0]=0;
		n[1]=1;
		n[2]=2;
		n[3]=3;
		n[4]=4;
		
		for (int i=5; i<n.length; i--) {
			System.out.println(n[i]);
			
		}
	}
}
