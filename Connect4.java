// Mingwei Zhang 
import java.util.*;
public class Connect4 {
	static int red = 0;
	static int yellow = 0;
	static int row = 0;
	public static void main(String[] args) {
		char[][] rowcol = new char [6][7];
		
		for(int x = 0; x < rowcol.length; x++) {
			for(int y = 0; y < rowcol[x].length; y++) {
				rowcol[x][y] = ' ';
			}
		}
		
		A : for (int x = 0 ; x < 21; x++){
			System.out.print("Drop a red disk at column (0 - 6): ");	
			Red(rowcol);
			Board(rowcol);
			
			String[] WinRed = {WinRedColumn(red,rowcol), WinRedRow(row, rowcol), WinRedDiagional(rowcol)};
			for (String st : WinRed) {
				if (st.equals("Red wins")) {
					System.out.println("Red wins");
					break A;}
			}
			
			
			System.out.print("Drop a yellow disk at column (0 - 6): ");
			Yellow(rowcol);
			Board(rowcol);
			String[] WinYellow = {WinYellowColumn(yellow,rowcol), WinYellowRow(row, rowcol),WinYellowDiagional(rowcol)};
			for(String st: WinYellow) {
				if (st.equals("Yellow wins")) {
					System.out.println("Yellow wins");
					break A;
				}
			}
			
			
			if(x == 20) {
				System.out.println("Draw");
				break;
			}
		}
	}	
	
	
	public static void Board(char[][] rowcol) {
		for(int x = 0; x < rowcol.length; x++) {
			for(int y = 0; y < rowcol[x].length; y++) {
				System.out.print("|" + rowcol[x][y]);
			}
			System.out.print("|");
			System.out.println();
			}
		}	
	//
	//
	public static void Red(char[][] rowcol) {
		Scanner input = new Scanner(System.in);
		while (true) {
		try{
			red = input.nextInt();

			if ((red < 0  || red  > 6)){
				System.out.print("Out-of-Bound: Enter again: ");
				//Board(rowcol);
			}
			else if (rowcol[0][red] != ' '){
				System.out.print("Out-of-bound: Enter again: ");
				//Board(rowcol);
			}
			else 
				break;
		}
		catch(InputMismatchException e){
			System.out.print("Incorrect input. Try Again: ");
			input.next();
			//Board(rowcol);
		}
	}	
		for(row = 5; row >= 0; row--) {
			if (rowcol[row][red] == ' ')
			{
				rowcol[row][red] = 'R';
				break;
			}
		}
		}
	//
	//
	public static String WinRedColumn(int red, char[][] rowcol) {
		for (int x = 0 ; x < 3 ; x++){
			if(rowcol[x][red] == 'R' & rowcol[x][red] == rowcol[x+1][red] & rowcol[x][red] == rowcol[x+2][red] & rowcol[x][red] == rowcol[x+3][red]){
				return "Red wins";
			}
		}
		return "";
	}
	//
	//
	public static String WinRedRow(int row, char[][] rowcol) {
		for (int x = 0 ; x < 4 ; x++){
			if(rowcol[row][x] == 'R' & rowcol[row][x] == rowcol[row][x+1] & rowcol[row][x] == rowcol[row][x+2] & rowcol[row][x] == rowcol[row][x+3]){
				return "Red wins";
			}
		}
		return "";
	}
	//
	//
	public static String WinRedDiagional(char[][] rowcol) {
		for (int x = 0, y = 0; x < 3; x++, y++)	{ //Left Diagional
			if (rowcol[x][y] == 'R' & rowcol[x][y] == rowcol[x+1][y+1] & rowcol[x][y] == rowcol[x+2][y+2] & rowcol[x][y] == rowcol[x+3][y+3]){
				return "Red wins";
			}
		}
	
		for (int x = 0, y = 1; x < 3; x++, y++)	{
			if (rowcol[x][y] == 'R' & rowcol[x][y] == rowcol[x+1][y+1] & rowcol[x][y] == rowcol[x+2][y+2] & rowcol[x][y] == rowcol[x+3][y+3]){
				return "Red wins";
			}
		}
		for (int x = 0, y = 2; x < 2; x++, y++)	{
			if (rowcol[x][y] == 'R' & rowcol[x][y] == rowcol[x+1][y+1] & rowcol[x][y] == rowcol[x+2][y+2] & rowcol[x][y] == rowcol[x+3][y+3]){
				return "Red wins";
			}
		}
		for (int x = 0, y = 3; x < 1; x++, y++)	{
			if (rowcol[x][y] == 'R' & rowcol[x][y] == rowcol[x+1][y+1] & rowcol[x][y] == rowcol[x+2][y+2] & rowcol[x][y] == rowcol[x+3][y+3]){
				return "Red wins";
			}
		}
		for (int x = 1, y = 0; x < 3; x++, y++)	{
			if (rowcol[x][y] == 'R' & rowcol[x][y] == rowcol[x+1][y+1] & rowcol[x][y] == rowcol[x+2][y+2] & rowcol[x][y] == rowcol[x+3][y+3]){
				return "Red wins";
			}
		}
		for (int x = 2, y = 0; x < 3; x++, y++)	{
			if (rowcol[x][y] == 'R' & rowcol[x][y] == rowcol[x+1][y+1] & rowcol[x][y] == rowcol[x+2][y+2] & rowcol[x][y] == rowcol[x+3][y+3]){
				return "Red wins";
			}
		}
		
		for (int x = 0, y = 6; x < 3; x++, y--)	{  // Right Diagional
			if (rowcol[x][y] == 'R' & rowcol[x][y] == rowcol[x+1][y-1] & rowcol[x][y] == rowcol[x+2][y-2] & rowcol[x][y] == rowcol[x+3][y-3]){
				return "Red wins";
			}
		}
		for (int x = 0, y = 5; x < 3; x++, y--)	{
			if (rowcol[x][y] == 'R' & rowcol[x][y] == rowcol[x+1][y-1] & rowcol[x][y] == rowcol[x+2][y-2] & rowcol[x][y] == rowcol[x+3][y-3]){
				return "Red wins";
			}
		}
		for (int x = 0, y = 4; x < 2; x++, y--)	{
			if (rowcol[x][y] == 'R' & rowcol[x][y] == rowcol[x+1][y-1] & rowcol[x][y] == rowcol[x+2][y-2] & rowcol[x][y] == rowcol[x+3][y-3]){
				return "Red wins";
			}
		}
		for (int x = 0, y = 3; x < 1; x++, y--)	{
			if (rowcol[x][y] == 'R' & rowcol[x][y] == rowcol[x+1][y-1] & rowcol[x][y] == rowcol[x+2][y-2] & rowcol[x][y] == rowcol[x+3][y-3]){
				return "Red wins";
			}
		}
		for (int x = 1, y = 6; x < 3; x++, y--)	{
			if (rowcol[x][y] == 'R' & rowcol[x][y] == rowcol[x+1][y-1] & rowcol[x][y] == rowcol[x+2][y-2] & rowcol[x][y] == rowcol[x+3][y-3]){
				return "Red wins";
			}
		}
		for (int x = 2, y = 6; x < 3; x++, y--)	{
			if (rowcol[x][y] == 'R' & rowcol[x][y] == rowcol[x+1][y-1] & rowcol[x][y] == rowcol[x+2][y-2] & rowcol[x][y] == rowcol[x+3][y-3]){
				return "Red wins";
			}
		}
		return "";
	}
	//
	//
	public static void Yellow(char[][] rowcol) {
		Scanner input = new Scanner(System.in);
		while (true) {
		try{
			yellow = input.nextInt();
			if (yellow < 0  || yellow  > 6 ){
				System.out.print("Out-of-Bound: Enter again: ");
				//Board(rowcol);
			}
			else if (rowcol[0][yellow] != ' '){
				System.out.print("Out-of-bound: Enter again: ");
				//Board(rowcol);
			}
			else 
				break;
		}
		catch(InputMismatchException e){
			//Board(rowcol);
			System.out.print("Incorrect input. Try Again: ");
			input.next();
			//Board(rowcol);
			
		}
	}
		for(row = 5; row >= 0; row--) {
			if (rowcol[row][yellow] == ' '){
				rowcol[row][yellow] = 'Y';
				break;
			}
			}	
		}
	//
	//
	public static String WinYellowColumn(int yellow, char[][] rowcol) {
		for (int x = 0 ; x < 3 ; x++){
			if(rowcol[x][yellow] == 'Y' & rowcol[x][yellow] == rowcol[x+1][yellow] & rowcol[x][yellow] == rowcol[x+2][yellow] & rowcol[x][yellow] == rowcol[x+3][yellow])	{
				return "Yellow wins";
			}
		}
		return "";
	}
	//
	//
	public static String WinYellowRow(int row, char[][] rowcol) {
		for (int x = 0 ; x < 4 ; x++){
			if(rowcol[row][x] == 'Y' & rowcol[row][x] == rowcol[row][x+1] & rowcol[row][x] == rowcol[row][x+2] & rowcol[row][x] == rowcol[row][x+3]){
				return "Yellow wins";
			}
		}
		return "";
	}
	//
	//
	public static String WinYellowDiagional(char[][] rowcol) {
		for (int x = 0, y = 0; x < 3; x++, y++)	{ //Left Diagional
			if (rowcol[x][y] == 'Y' & rowcol[x][y] == rowcol[x+1][y+1] & rowcol[x][y] == rowcol[x+2][y+2] & rowcol[x][y] == rowcol[x+3][y+3]){
				return "Yellow wins";
			}
		} 
		for (int x = 0, y = 1; x < 3; x++, y++)	{
			if (rowcol[x][y] == 'Y' & rowcol[x][y] == rowcol[x+1][y+1] & rowcol[x][y] == rowcol[x+2][y+2] & rowcol[x][y] == rowcol[x+3][y+3]){
				return "Yellow wins";
			}
		}
		for (int x = 0, y = 2; x < 2; x++, y++)	{
			if (rowcol[x][y] == 'Y' & rowcol[x][y] == rowcol[x+1][y+1] & rowcol[x][y] == rowcol[x+2][y+2] & rowcol[x][y] == rowcol[x+3][y+3]){
				System.out.println("Yellow wins");
			}
		}
		for (int x = 0, y = 3; x < 1; x++, y++)	{
			if (rowcol[x][y] == 'Y' & rowcol[x][y] == rowcol[x+1][y+1] & rowcol[x][y] == rowcol[x+2][y+2] & rowcol[x][y] == rowcol[x+3][y+3]){
				return "Yellow wins";
			}
		}
		for (int x = 1, y = 0; x < 3; x++, y++)	{
			if (rowcol[x][y] == 'Y' & rowcol[x][y] == rowcol[x+1][y+1] & rowcol[x][y] == rowcol[x+2][y+2] & rowcol[x][y] == rowcol[x+3][y+3]){
				return "Yellow wins";
			}
		}
		for (int x = 2, y = 0; x < 3; x++, y++)	{
			if (rowcol[x][y] == 'Y' & rowcol[x][y] == rowcol[x+1][y+1] & rowcol[x][y] == rowcol[x+2][y+2] & rowcol[x][y] == rowcol[x+3][y+3]){
				return "Yellow wins";
			}
		}
		
		for (int x = 0, y = 6; x < 3; x++, y--)	{  // Right Diagional
			if (rowcol[x][y] == 'Y' & rowcol[x][y] == rowcol[x+1][y-1] & rowcol[x][y] == rowcol[x+2][y-2] & rowcol[x][y] == rowcol[x+3][y-3]){
				return "Yellow wins";
			}
		}
		for (int x = 0, y = 5; x < 3; x++, y--)	{
			if (rowcol[x][y] == 'Y' & rowcol[x][y] == rowcol[x+1][y-1] & rowcol[x][y] == rowcol[x+2][y-2] & rowcol[x][y] == rowcol[x+3][y-3]){
				return "Yellow wins";
			}
		}
		for (int x = 0, y = 4; x < 2; x++, y--)	{
			if (rowcol[x][y] == 'Y' & rowcol[x][y] == rowcol[x+1][y-1] & rowcol[x][y] == rowcol[x+2][y-2] & rowcol[x][y] == rowcol[x+3][y-3]){
				return "Yellow wins";
			}
		}
		for (int x = 0, y = 3; x < 1; x++, y--)	{
			if (rowcol[x][y] == 'Y' & rowcol[x][y] == rowcol[x+1][y-1] & rowcol[x][y] == rowcol[x+2][y-2] & rowcol[x][y] == rowcol[x+3][y-3]){
				return "Yellow wins";
			}
		}
		for (int x = 1, y = 6; x < 3; x++, y--)	{
			if (rowcol[x][y] == 'Y' & rowcol[x][y] == rowcol[x+1][y-1] & rowcol[x][y] == rowcol[x+2][y-2] & rowcol[x][y] == rowcol[x+3][y-3]){
				return "Yellow wins";
			}
		}
		for (int x = 2, y = 6; x < 3; x++, y--)	{
			if (rowcol[x][y] == 'Y' & rowcol[x][y] == rowcol[x+1][y-1] & rowcol[x][y] == rowcol[x+2][y-2] & rowcol[x][y] == rowcol[x+3][y-3]){
				return "Yellow wins";
			}
		}
		return "";
	}
}




	
