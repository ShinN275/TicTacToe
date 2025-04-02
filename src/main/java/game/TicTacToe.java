package game;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Pobierz imię gracza
        System.out.println("Player 1, jak masz na imię?");
        String p1 = sc.nextLine();

        System.out.println("Player 2, jak masz na imię?");
        String p2 = sc.nextLine();

        //3x3 tablica Tic Tac Toe
        // - pusta przestrzeń
        //x gracz 1
        //o gracz 2
        char[][] board = new char[3][3];

        //Wypełnij planszę myślnikami
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        //Narysuj planszę
        drawBoard(board);

        //Śledzenie, czyja jest kolej
        boolean isPlayer1 = true;

        //Śledzenie symbolu, którego używamy do gry
        char symbol = ' ';
        if (isPlayer1){
            symbol = 'x';
        } else {
            symbol = 'o';
        }

        //Zmienne wiersza i kolumny
        int row = 0;
        int col  = 0;

        while(true) {
            //Pobieranie wiersza i kolumny od użytkownika
            System.out.println("Enter a row (0,1, or 2): ");
            row = sc.nextInt();

            System.out.println("Enter a column (0,1, or 2): ");
            col = sc.nextInt();

            //Sprawdzenie poprawności wiersza i kolumny
            if (row < 0 || col < 0 || row > 2 || col > 2) {
                //Wiersz i kolumna wykraczają poza zakres
                System.out.println("Row and column are out of bounds");
            } else if (board[row][col] != '-') {
                //Pozycja na tablicy ma znak x lub o
                System.out.println("Someone has already made a move there");
            } else {
                //Wiersz i kolumna są poprawne
                break;
            }
        }

        //Ustawienie pozycji na planszy na symbol gracza
        board[row][col] = symbol;
        drawBoard(board);
    }

    //Wydruk planszy
    public static void drawBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
