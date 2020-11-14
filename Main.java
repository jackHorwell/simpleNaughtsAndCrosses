package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Call function with game logic
        gameLoop();
    }

    public static void gameLoop(){
        int[] validatedCoords;
        Grid grid = new Grid();
        Scanner input = new Scanner(System.in);

        while(!grid.endOfGame){
            grid.validMove = false;
            while(!grid.validMove) {
                System.out.print("Enter row number: ");
                String rowInput = input.nextLine();
                System.out.print("Enter column number: ");
                String colInput = input.nextLine();

                try {
                    validatedCoords = inputValidation(rowInput, colInput);
                } catch (Exception nfe){
                    System.out.println("==================\nInvalid move, try again\n==================");
                    continue;
                }

                grid.setPosition(validatedCoords[0], validatedCoords[1]);
                grid.printBoard();
                grid.validMove = true;
            }

            switch (checkForWin(grid.grid)) {
                case "p1" -> {
                    grid.endOfGame = true;
                    System.out.println("Player 1 wins!");
                }
                case "p2" -> {
                    grid.endOfGame = true;
                    System.out.println("Player 2 wins!");
                }
                case "d" -> {
                    grid.endOfGame = true;
                    System.out.println("Draw!");
                }
            }
        }
    }

    public static int[] inputValidation(String row, String col) throws Exception {
        int[] validatedCoords = new int[2];
        validatedCoords[0] = Integer.parseInt(row) - 1;
        validatedCoords[1] = Integer.parseInt(col) - 1;


        if (validatedCoords[0] >= 0 && validatedCoords[0] < 3 && validatedCoords[1] >= 0 && validatedCoords[1] < 3){
            return validatedCoords;
        }
        else {
            throw new Exception("Non valid Input");
        }
    }

    public static String checkForWin(String[][] grid){
        String winSymbol = "none";
        for (int i = 0; i < 3; i++) {
            if (grid[i][0].equals(grid[i][1]) && grid[i][1].equals(grid[i][2]) && !grid[i][0].equals(" ")) {
                winSymbol = grid[i][0];
            }
            else if (grid[0][i].equals(grid[1][i]) && grid[1][i].equals(grid[2][i]) && !grid[0][i].equals(" ")) {
                winSymbol = grid[0][i];
            }
        }

        if (grid[0][0].equals(grid[1][1]) && grid[1][1].equals(grid[2][2]) && !grid[0][0].equals(" ")) {
            winSymbol = grid[0][0];
        }
        else if (grid[0][2].equals(grid[1][1]) && grid[1][1].equals(grid[2][0]) && !grid[0][2].equals(" ")) {
            winSymbol = grid[0][2];
        }

        boolean isBlankSpace = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j].equals(" ")){
                    isBlankSpace = true;
                }
                if (!grid[2][2].equals(" ") && !isBlankSpace && i == 2 && j == 2){
                    winSymbol = "d";
                }
            }
        }

        return switch (winSymbol) {
            case "x" -> "p1";
            case "o" -> "p2";
            case "d" -> "d";
            default -> "none";
        };
    }
}
