import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        boolean winner = false;
        System.out.println("\nLet's play Tic Tac Toe.\n");

        String[][] board  = { {"_","_", "_"}, {"_","_", "_"}, {"_","_", "_"}  
        };
        for (int i = 0 ; i < board.length; i++) {
            System.out.println("\n");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
        }

        System.out.println("\n\nPress enter to continue: ");
        scan.nextLine();

        for (int x = 0; x < 9; x++) {
            String player_turn = "";
            if (x % 2 == 0) {
                player_turn = "X";
            } else {
                player_turn = "O";
            }
            System.out.println("\n\nTurn: " + player_turn);
            System.out.println("Pick a row and column number: ");
            int rowNumber = scan.nextInt();
            int columnNumber = scan.nextInt();
            if (rowNumber < 0 || rowNumber > 2 || columnNumber < 0 || columnNumber > 2) {
                System.out.println("Invalid input. Use 0, 1, or 2.");
                x--;
                continue; }
            if (board[rowNumber][columnNumber].equals("_")) {
                board[rowNumber][columnNumber] = player_turn;
            } else {
                System.out.println("\nSpot already Taken. Try again.");
                x--;
                continue;
            }
            
            for (int i = 0 ; i < board.length; i++) {
            System.out.println("\n");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);}
            }
            if ( (board[0][0].equals(player_turn) && board[0][1].equals(player_turn) && board[0][2].equals(player_turn)) || 
                (board[1][0].equals(player_turn) && board[1][1].equals(player_turn) && board[1][2].equals(player_turn)) || 
                (board[2][0].equals(player_turn) && board[2][1].equals(player_turn) && board[2][2].equals(player_turn)) ||
                (board[0][0].equals(player_turn) && board[1][0].equals(player_turn) && board[2][0].equals(player_turn))  ||
                (board[0][1].equals(player_turn) && board[1][1].equals(player_turn) && board[2][1].equals(player_turn)) ||
                (board[0][2].equals(player_turn) && board[1][2].equals(player_turn) && board[2][2].equals(player_turn)) ||
                (board[0][0].equals(player_turn) && board[1][1].equals(player_turn) && board[2][2].equals(player_turn)) ||
                (board[0][2].equals(player_turn) && board[1][1].equals(player_turn) && board[2][0].equals(player_turn))) {
                    winner = true;
                    System.out.println("Player: " + player_turn + " wins!");
                    break;
                }
        }

        if (!winner) {
            System.out.println("It's a Draw! ");
        }
        
        scan.close();
    }
}
