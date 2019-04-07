import java.util.Random;

/**
 * @author Rhea
 *
 */
abstract class Animal implements Comparable<Animal> {

	
	private int r;
	private int c;
	private char type;
	
	
	/**
	 * Finds position to move object to
	 * @return coordinates of new position
	 */
	abstract int[] move();
	/**
	 * Determines result of attack with another animal object
	 * @param a animal to be attacked
	 * @return boolean value representing whether fight was won(true) or lost(false) by attacker
	 */
	abstract boolean attack(Animal a);
	
	/**
	 * Constructor for animal object
	 * @param i Row position
	 * @param j Column position
	 * @param x Character representation of Animal
	 */
	public Animal(int i, int j, char x)
	{
		r=i;
		c=j;
		type=x;
	}
	
	/**
	 * Returns type value of animal
	 * @return Type of animal
	 */
	public char getType() {
		return type;
	}

	/**
	 * Returns row position of animal
	 * @return row position
	 */
	public int getR() {
		return r;
	}

	/**
	 * Returns column position of animal
	 * @return column position
	 */
	public int getC() {
		return c;
	}
		
	/**
	 * Assigns Coordinates for the animal
	 * @param r row position
	 * @param c column position
	 */
	public void setcord(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	/**
	 * Assigns type value for animal object
	 * @param type character representation of animal
	 */
	public void setType(char type) {
		this.type = type;
	}
	
	/**
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Animal a)
	{
		String a1= Character.toString(a.getType());
		String b1= Character.toString(this.getType());
		return b1.compareTo(a1);
	}
}