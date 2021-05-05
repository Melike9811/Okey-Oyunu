import java.util.concurrent.ThreadLocalRandom;

public class Player {
	/**
	 * {@value} Players Game Piece Count
	 */
	private int count;
	private GamePiece[] pieces = new GamePiece[15];
	//private ArrayList<GamePiece> piecess = new ArrayList<GamePiece>();
	
	Player() {
		this.count = 0;
	}
	/*public void setCount(int newValue) {
		this.count = newValue;
	}*/
	
	public void addPiece(GamePiece p) {
		if(this.count < 15) {
			this.pieces[this.count] = p;
			this.count += 1;

		}
	}
	
	public void remove() {
		int luckyPiece = ThreadLocalRandom.current().nextInt(0, this.count);
		GamePiece[] newPieces = new GamePiece[15];
		for(int i = 0; i < this.count; i++) {
			if(i != luckyPiece) {
				newPieces[i] = this.pieces[i];
			}
			this.count = i;
		}
		

	}
	
	public int countDoubles() {
		int doubleCount = 0;
		for(int i = 0; i < this.count; i++) {
			for(int y = i + 1; y < this.count; y++) {
				if(this.pieces[i].getColor() == this.pieces[y].getColor() && this.pieces[i].getValue() == this.pieces[y].getValue()) {
					doubleCount++;
				}
			}
		}
		return doubleCount;
	}
	
	public int getMostColor() {
		int[] colors = new int[4];
		for(int i = 0; i < this.count; i++) {
			int colorIndex = this.pieces[i].getColor()-1;
			colors[colorIndex] += 1;
		}
		int max = 0;
		for(int i = 0; i < colors.length; i++) {
			if(colors[i] > max) {
				max = i+1;
			}
		}
		return max;
	}
	public String toString() {
		String returnString = "";
		for(int i = 0; i < this.count; i++) {
			returnString +=  this.pieces[i] + "\n";
		};
		return returnString;
	}
	
	
	
	public static void main(String[] args) {
		GamePiece a = new GamePiece(13,4);
		System.out.println(a.toString());
		Player b = new Player();
		
		for(int i = 0; i < 15; i++) {
			b.addPiece(new GamePiece());
			
		}
		
		System.out.println(b.toString());
		System.out.println("Çiftler: " + b.countDoubles());
		System.out.println("En Çok Olan Renk : " + b.getMostColor());
	}
