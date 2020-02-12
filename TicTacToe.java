package com.Marcs_coding;

import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);



        while (true) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your Placement (1-9):");
            int playerPos = scan.nextInt();
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)){
                System.out.println("Position taken! Try a different space");
                playerPos = scan.nextInt();
            }

            checkWinner();
            String result = checkWinner();
            System.out.println(result);

            placePiece(gameBoard, playerPos, "Player");

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;// allocates position 1-9 on the board

            placePiece(gameBoard, cpuPos, "cpu");

                while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos) || cpuPositions.contains(playerPos)) {
                    cpuPos = rand.nextInt(9) + 1;
            }

            checkWinner();{
                System.out.println(result);

            printGameBoard(gameBoard);


            }
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user){

        char symbol ='X';

        if(user.equals("player")){
            symbol ='X';
            playerPositions.add(pos);
        }else if(user.equals("cpu")){
            symbol ='O';
            cpuPositions.add(pos);
        }

            switch (pos) {
                case 1:
                    gameBoard[0][0] = symbol;
                    break;
                case 2:
                    gameBoard[0][2] = symbol;
                    break;
                case 3:
                    gameBoard[0][4] = symbol;
                    break;
                case 4:
                    gameBoard[2][0] = symbol;
                    break;
                case 5:
                    gameBoard[2][2] = symbol;
                    break;
                case 6:
                    gameBoard[2][4] = symbol;
                    break;
                case 7:
                    gameBoard[4][0] = symbol;
                    break;
                case 8:
                    gameBoard[4][2] = symbol;
                    break;
                case 9:
                    gameBoard[4][4] = symbol;
                    break;
                default:
                    break;
        }

    }
    public static String checkWinner() {

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);

        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);

        List diag1 = Arrays.asList(1, 5, 9);
        List diag2 = Arrays.asList(7, 5, 3);

        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(botRow);
        winningConditions.add(leftCol);
        winningConditions.add(midCol);
        winningConditions.add(rightCol);
        winningConditions.add(diag1);
        winningConditions.add(diag2);

        for (List l : winningConditions) {
            if (playerPositions.contains(l)) {
                return "Congratulations You Won !! XD";
            } else if (cpuPositions.contains(l)) {
                return "CPU Conquered You !! :'(";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "Its a Tie!";

            }
        }
        return "...";//Because void statement is not used initially, a return statement
        //must be applied
    }

}