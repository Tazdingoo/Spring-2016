package edu.nyu.cs9053.homework3.dance;
public class DanceCat{
	private final String name;
	private final DanceMove[] danceMoves;
	private static String[] parseUnparsedMoves(String unparsedMoves){
		String[] moves = new String[18];
		int lengthOfUnparsed = unparsedMoves.length();
		for (int i=0; i<lengthOfUnparsed; i++) {
			moves[i] = String.valueOf(unparsedMoves.charAt(i));
		}
		if (lengthOfUnparsed<18) {
			for (int i=lengthOfUnparsed; i<18; i++) {
				moves[i] = " '\"\"' ";
			}
		}
		return moves;
	}

	private static String defaultName(){
		String[] nameList = {"Mickey", "Donald", "Goofy", "Daisy", "Pluto", "Tom", "Jerry"};
		int index = (int)(Math.random()*nameList.length);
		//System.out.println(index);
		return nameList[index];
	}

	private static DanceMove[] creatDanceMove(String[] moves, String[] idealMoves){
		DanceMove[] danceMoves = new DanceMove[18];
		for (int i=0; i<18; i++) {
			danceMoves[i] = new DanceMove(moves[i], idealMoves[i]);
		}
		return danceMoves;
	}

	public static int getComputerLevel(){
		return (int)(Math.random()*101);
	}
	//1st constructor
	public DanceCat(String unparsedMoves, String[] idealMoves){
		//call the second constructor
		this(parseUnparsedMoves(unparsedMoves), idealMoves);
	}
	//2ed constructor
	public DanceCat(String[] moves, String[] idealMoves){
		this(creatDanceMove(moves, idealMoves));
	}
	//3rd constructor
	public DanceCat(DanceMove[] danceMoves){
		this(defaultName(), danceMoves);
	}
	//4th constructor
	public DanceCat(String name, DanceMove[] danceMoves){
		this.name = name;
		this.danceMoves = danceMoves;
	}

	public String getName(){
		return name;
	}

	public DanceMove[] getDanceMoves(){
		return danceMoves;
	}

	public int getNumberOfCorrectMoves(){
		int numberOfCorrectMoves = 0;
		for (int i=0; i<18; i++) {
			if (danceMoves[i].correctMove()) {
				numberOfCorrectMoves +=1;
			}
		}
		return numberOfCorrectMoves;
	}







}