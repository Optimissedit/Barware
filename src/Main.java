
public class Main {

	public static void main(String[] args) {
		SlotMachine s = new SlotMachine(10, 1);
		
		while(true) {
			s.play();	
			try{System.in.read();}
			catch(Exception e){}
		}


	}

}
