package com.company;

public class Grid {
    // Store the state of the board
    String[][] grid = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    boolean endOfGame = false;
    boolean p1Turn = true;
    boolean validMove;

    public void setPosition(int row, int col){
        if (!grid[row][col].equals(" ")){
            System.out.println("==================\nInvalid move, try again\n==================");
            return;
        }

        String setTo;
        if (p1Turn){
            setTo = "x";
        }
        else{
            setTo = "o";
        }

        grid[row][col] = setTo;
        p1Turn = !p1Turn;
    }

    public void printBoard(){
        System.out.println("   1   2   3");
        System.out.println("1  " + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2]);
        System.out.println("   =========");
        System.out.println("2  " + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2]);
        System.out.println("   =========");
        System.out.println("3  " + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2]);
    }
}