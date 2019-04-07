
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Class for the forest
 * @author Rhea
 *
 */
class ForestNew {

	private Board board = new Board();
	private ArrayList<Animal> anlist = new ArrayList<Animal>();
	private ArrayList<Animal> deadan = new ArrayList<Animal>();

	public static void main(String args[]) {
		ForestNew f1 = new ForestNew();
		f1.enter();
		f1.runprog();

	}

	/**
	 * Adds animals to the forest 
	 */
	private void enter() {
		Scanner keyboard = new Scanner(System.in);
		int inp = 1;
		while (inp != 0){
			board.display();
			System.out.print("1. Dog (d)\n" + 
					"2. Fox (f)\n" + 
					"3. Wolf (w)\n" + 
					"4. Jaguar (j)\n" + 
					"5. Lion (l)\n" + 
					"6. Cat (c)\n" + 
					"7. Kitten (k)\n" + 
					"8. Dinosaur (i)\n" + 
					"9. Turtle (u)\n" + 
					"What would you like to add to the Forest?\n" + 
					"Please enter your choice (1-9, or 0 to finish the animal input):");
			inp = keyboard.nextInt();

			if (inp == 0)
				break;

			Random rand = new Random();
			int i, j;
			do {
				i = rand.nextInt(15);
				j = rand.nextInt(15);
			} while (!board.check(i, j));

			Animal a;
			switch (inp) {
			case 1:
				a = new Dog(i, j, 'd');
				board.add('d', i, j);
				System.out.println("Added Dog at (" + i + ',' + j + "): "
						+ "Dog is Canine, Canine moves in four directions, one or two steps a time.");
				anlist.add(a);

				break;
			case 2:
				a = new Fox(i, j, 'f');
				board.add('f', i, j);
				System.out.println("Added Fox at (" + i + ',' + j + "): "
						+ "Fox is Canine, Canine moves in four directions, one or two steps a time.");
				anlist.add(a);
				break;
			case 3:
				a = new Wolf(i, j, 'w');
				board.add('w', i, j);
				System.out.println("Added Wolf at (" + i + ',' + j + "): "
						+ "Wolf is Canine, Canine moves in four directions, one or two steps a time.");
				anlist.add(a);
				break;
			case 4:
				a = new Jaguar(i, j, 'j');
				board.add('j', i, j);
				System.out.println("Added Jaguar at (" + i + ',' + j + "): "
						+ "Jaguar is a Feline, Feline moves in all eight directions, one step a time.");
				anlist.add(a);
				break;
			case 5:
				a = new Lion(i, j, 'l');
				board.add('l', i, j);
				System.out.println("Added Lion at (" + i + ',' + j + "): "
						+ "Lion is Feline, Feline moves in all eight directions, one step a time.");
				anlist.add(a);
				break;
			case 6:
				a = new Cat(i, j, 'b');
				board.add('c', i, j);
				System.out.println("Added Cat at (" + i + ',' + j + "): "
						+ "Cat is is Feline, Feline moves in all eight directions, one step a time.");
				anlist.add(a);
				break;
			case 7:
				a = new Kitten(i, j, 'k');
				board.add('k', i, j);
				System.out.println("Added Kitten at (" + i + ',' + j + "): "
						+ "Kitten is Cat, Kitten has 30% chance stay in the same position, and 70% chance move in all eight directions, one step at a time.");
				anlist.add(a);
				break;				
			case 8:
				a = new Dinosaur(i, j, 'c');
				board.add('i', i, j);
				System.out.println("Added Dinosaur at (" + i + ',' + j + "): "
						+ "Dinosaur is Animal, Dinosaur moves in four directions, three step a time.");
				anlist.add(a);
				break;				
			case 9:
				a = new Turtle(i, j, 'u');
				board.add('u', i, j);
				System.out.println("Added Turtle at (" + i + ',' + j + "): "
						+ "Turtle is Animal, Turtle has 50% chance stay in the same position, and 50% chance move in four directions, one step at a time.");
				anlist.add(a);
				break;
			}

		}
		Collections.sort(anlist);
		int m=0;
		
		while(!(anlist.get(m) instanceof Dog))
		{
			if(anlist.get(m).getType()=='b')
				anlist.get(m).setType('c');
			else if(anlist.get(m).getType()=='c')
				anlist.get(m).setType('i');
			m++;
		}
		board.display();	
		
	}

	/**
	 * Starts generating the forest
	 */
	private void runprog() {
		Scanner keyboard = new Scanner(System.in);
		String inp = "";
		while (!inp.equals("exit")) {
			System.out.print("Press enter to iterate, type 'print' to print the Forest or 'exit' to quit:");
			inp = keyboard.nextLine();

			if (inp.equals("")) {
				this.iterate();
				board.display();
			} else if (inp.equals("print")) {
				board.display();
				for (int i = 0; i < deadan.size(); i++) {
					System.out.println(deadan.get(i).getClass().getSimpleName() + " died at location ("
							+ deadan.get(i).getR() + ',' + deadan.get(i).getC() + ')');
				}
			}
		}
		board.display();
		System.out.println("Animals in the forest:");
		for (int i = 0; i < anlist.size(); i++) {
			System.out.println(anlist.get(i).getClass().getSimpleName() + " at location (" + anlist.get(i).getR() + ','
					+ anlist.get(i).getC() + ')');
		}
		System.out.println();
		System.out.println("Dead Animals:");
		for (int i = 0; i < deadan.size(); i++) {
			System.out.println(deadan.get(i).getClass().getSimpleName() + " died at location (" + deadan.get(i).getR()
					+ ',' + deadan.get(i).getC() + ')');
		}

	}

	/**
	 * Checks whether attack needs to happen and gets resulf of attack
	 * @param i Index value of animal being moved
	 * @param pos Coordinates to move animal to
	 * @param origpos Current coordinates of animal
	 * @return Returns index of the animal being moved
	 */
	private int CheckAttack(int i, int pos[], int origpos[]) {
		
		int c;
		if(pos.length==6)
			c=4;
		else
			c=2;
		
		for (; c >= 0; c -= 2) {

			if (pos[c] == -1) {
				continue;
			}
			int d = c + 1;
			board.remove(origpos[0], origpos[1]);
			int checker = 0;
			for (int j = 0; j < anlist.size(); j++) {

				if (i != j && anlist.get(j).getR() == pos[c] && anlist.get(j).getC() == pos[d]) {

					checker++;
					boolean b = anlist.get(i).attack(anlist.get(j));

					if (b == true) {
						System.out.println(anlist.get(i).getClass().getSimpleName() + " from (" + origpos[0] + ','
								+ origpos[1] + ") attacks " + anlist.get(j).getClass().getSimpleName() + " at ("
								+ pos[c] + ',' + pos[d] + ") and  wins");
						System.out.println(
								anlist.get(j).getClass().getSimpleName() + " dies at (" + pos[c] + ',' + pos[d] + ")");

						if (c == 0) {
							System.out.println(anlist.get(i).getClass().getSimpleName() + " moved from (" + origpos[0]
									+ ',' + origpos[1] + ") to (" + pos[0] + ',' + pos[1] + ')');
							board.add(anlist.get(i).getType(), pos[0], pos[1]);
						}

						deadan.add(anlist.get(j));
						anlist.remove(j);
						if (j < i)
							i--;

					} else {
						System.out.println(anlist.get(i).getClass().getSimpleName() + " from (" + origpos[0] + ','
								+ origpos[1] + ") attacks " + anlist.get(j).getClass().getSimpleName() + " at ("
								+ pos[c] + ',' + pos[d] + ") and  loses");
						System.out.println(
								anlist.get(i).getClass().getSimpleName() + " dies at (" + pos[c] + ',' + pos[d] + ")");

						deadan.add(anlist.get(i));
						anlist.remove(i);
						i--;
						c = -1;
					}

					break;
				}
			}
			if (checker == 0) {
				if (c == 0) {
					board.add(anlist.get(i).getType(), pos[0], pos[1]);
					System.out.println(anlist.get(i).getClass().getSimpleName() + " moved from (" + origpos[0] + ','
							+ origpos[1] + ") to (" + pos[0] + ',' + pos[1] + ')');
				}
			}

		}
		return i;
	}

	/**
	 * Runs iterations to move each animal
	 */
	private void iterate() {

		for (int i = 0; i < anlist.size(); i++) {
			int[] origpos = { anlist.get(i).getR(), anlist.get(i).getC() };

			int[] pos;
			pos = anlist.get(i).move();

			if (origpos[0] == pos[0] && origpos[1] == pos[1]) {
				System.out.println(anlist.get(i).getClass().getSimpleName() + " stayed in (" + origpos[0] + ','
						+ origpos[1] + ')');
			} else {

				i = this.CheckAttack(i, pos, origpos);

			}
		}
	}

}
