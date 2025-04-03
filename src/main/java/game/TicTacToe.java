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

        //Śledzenie, czyja jest kolej
        boolean isPlayer1 = true;

        //Śledzenie, czy gra się zakończyła
        boolean gameEnded = false;

        while (!gameEnded){
            //Narysuj planszę
            drawBoard(board);

            //Śledzenie symbolu, którego używamy do gry
            char symbol = ' ';
            if (isPlayer1) {
                symbol = 'x';
            } else {
                symbol = 'o';
            }

            //Wydrukuj turę gracza
            if (isPlayer1) {
                System.out.println("Tura gracza " + p1 + "(x): ");
            } else {
                System.out.println("Tura gracza " + p2 + "(x): ");
            }

            //Zmienne wiersza i kolumny
            int row = 0;
            int col = 0;

            while (true) {
                //Pobieranie wiersza i kolumny od użytkownika
                System.out.println("Wprowadź wiersz (0, 1 lub 2): ");
                row = sc.nextInt();

                System.out.println("Wprowadź kolumnę (0, 1 lub 2): ");
                col = sc.nextInt();

                //Sprawdzenie poprawności wiersza i kolumny
                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    //Wiersz i kolumna wykraczają poza zakres
                    System.out.println("Wiersz i kolumna wykraczają poza zakresem");
                } else if (board[row][col] != '-') {
                    //Pozycja na tablicy ma znak x lub o
                    System.out.println("Ktoś już wykonał ruch w tym kierunku");
                } else {
                    //Wiersz i kolumna są poprawne
                    break;
                }
            }

            //Ustawienie pozycji na planszy na symbol gracza
            board[row][col] = symbol;

            //Sprawdzenie, czy gracz wygrał
            if (hasWon(board) == 'x') {
                //gracz 1 wygrał
                System.out.println(p1 + " wygrał !");
                gameEnded = true;
            } else if (hasWon(board) == 'o') {
                //gracz 2 wygrał
                System.out.println(p2 + " wygrał !");
                gameEnded = true;
            } else {
                //Nikt nie wygrał
                if (hasTied(board)) {
                    //Remis
                    System.out.println("Remis !");
                } else {
                    //Kontynuacja gry i przełączenie tury
                    isPlayer1 = !isPlayer1;
                }
            }

        }
        //Wydruk ostatecznego stanu tablicy
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

    public static char hasWon(char[][] board){
        //Wiersz
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-'){
                return board[i][0];
            }
        }

        //Kolumna
        for (int j = 0; j < 3; j++) {
            if (board[j][0] == board[j][1] && board[j][1] == board[j][2] && board[j][0] != '-'){
               return board[0][j];
            }
        }

        //Diagonale
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-'){
           return board[0][0];
        }

        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-'){
            return board[2][0];
        }

        //Nikt nie wygrał
        return '-';
    }

    //Sprawdź, czy tablica jest pełna
    public static boolean hasTied(char[][] board){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }
}