import java.util.Random;

public class SlotMachine {
	// Number of credits player has to spin remaining
	private int credits;
	// The denomination each spin costs
	private int denom;
	
	public SlotMachine(int cr, int dm) {
		this.credits = cr;
		this.denom = dm;
	}
	
	// Returns middle-line results for a spin 
	private int[] spin() {
		Random rand = new Random();
		
		int[] result = new int[3];
		
		if(credits >= denom) {
			// Subtract credits for play
			credits -= denom;
			// Spin
			for(int i = 0; i < 3; i++) {
				result[i] = rand.nextInt(10);
			}
			
		} else {
			
			System.out.println("Not enough credits");
			result[0] = -1; result[1] = -1; result[2] = -1;
		}
		
		return result;
	}
	
	private int payOut(int[] num) {
		
		int compare = num[0];
		boolean pay = true;
		
		for(int i = 0; i < 3; i++) {
			
			if(num[i] != compare || num[i] < 0) {
				pay = false;
			}
		}
		
		if(pay) {
			return 2 * denom;
		}
		else {
			return 0;
		}
	}
	
	// Starts a single spin for a user
	public void play() {
		
		int[] hehe = spin();
		
		for(int i = 0; i < 3; i++) {
			System.out.print(hehe[i]);
		}
		
		int creds = payOut(hehe);
		System.out.println("\nPlayer wins " + creds + " credits.");
		addCredits(creds);

	}
	
	// Add more credits to the machine
	public void addCredits(int add) {
		this.credits += add;
	}
	
}
