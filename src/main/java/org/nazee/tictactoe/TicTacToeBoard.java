package org.nazee.tictactoe;

public class TicTacToeBoard {

    private String boardWinner;
    private String [][] grid = new String[3][3];
    private String bottomLeftValue;
    private String bottomMiddleValue;
    private String bottomRightValue;
    private int time = 1;


    public void putBottomLeft(String value) {
        if (bottomLeftValue == null) {
            bottomLeftValue = value;
            time += 1;
            if (value.equals(grid [1][1]) && value.equals(grid [0][2])) {
                // that value is the winner
                boardWinner = value;
            }
            //check  middle left value and top left value and middle bottom value are the same
            leftColumnWins(value);
        }
        bottomRowWins(value);
    }

    private void leftColumnWins(String value) {
        if  (value.equals(grid [1][0]) && value.equals(grid[0][0]) && value.equals(bottomLeftValue)) {
            boardWinner = value;
        }
    }

    public void putMiddle(String value) {
        if (grid [1][1] == null) {
            grid [1][1] = value;
            //it is the next persons turn
            time += 1;
        }
      isMiddleRowWinner(value);
    }

    public void putMiddleLeft(String value) {
        if (grid [1][0] == null) {
            grid [1][0] = value;
            time += 1;
            isMiddleRowWinner(value);
        }
        leftColumnWins(value);
    }

    private void isMiddleRowWinner(String value) {
        if (value.equals (grid [1][1]) && value.equals(grid [1][0]) && value.equals(grid [1][2])) {
            // that value is the winner
            boardWinner = value;
        }
    }

    public void putLeftTop(String value) {
        if (grid[0][0] == null) {
            grid[0][0] = value;
            time += 1;
        }
        topRowWins(value);
        leftColumnWins(value);
    }

    private void topRowWins(String value) {
        if (value.equals(grid [0][2]) && value.equals(grid [0][1]) && value.equals(grid[0][0])) {
            // that value is the winner
            boardWinner = value;
        }
    }

    public void putRightTop(String value) {
        //Put x on the right top box
        if (grid [0][2] == null) {
            grid [0][2] = value;
            time += 1;
        }
        //When there are three x's in a diagonal order (there is an x in the middle)
        //When the three diagonal order have the same value,
        if (value.equals(grid [1][1]) && value.equals(bottomLeftValue)) {
            // that value is the winner
            boardWinner = value;
        }
        topRowWins(value);
        rightColumnWins(value);
    }

    private void rightColumnWins(String value) {
        if (value.equals(bottomRightValue) && value.equals(grid [1][2]) && value.equals(grid [0][2])) {
            boardWinner  =  value;
        }
    }

    public String winner() {
        //no box has a value
        // I added this code
        return boardWinner;
    }

    public void putTopMiddle(String value) {
        if (grid [0][1] == null) {
            grid [0][1] = value;
            time += 1;
        }
        topRowWins(value);
    }


    public void putMiddleRight(String value) {
        if (grid [1][2] == null) {
            grid [1][2] = value;
            time += 1;
        }
        //Check  middle across has  the same value
        isMiddleRowWinner(value);
        rightColumnWins(value);

    }

    public void putBottomMiddle(String value) {
        if (bottomMiddleValue == null) {
            bottomMiddleValue = value;
            time += 1;
            //O wins
            //When the middle column have the same values(X OR O) THAT VALUE WINS
            //When the bottom row all have the same values (X or O) that value wins
            if (value.equals(grid [1][1]) && value.equals(grid [0][1])) {
                // that value is the winner
                boardWinner = value;
            }
            bottomRowWins(value);
        }
    }

    private void bottomRowWins(String value) {
        if (value.equals(bottomLeftValue) && value.equals(bottomRightValue) && value.equals(bottomMiddleValue))  {
            boardWinner  =  value;
        }
    }

    public void putBottomRight(String value) {
        if (bottomRightValue == null) {
            bottomRightValue = value;
            time += 1;
        }
        rightColumnWins(value);
        bottomRowWins(value);
    }

    public String getTopMiddle() {
        // return the value in the top middle
        return grid [0][1];
    }

    public String getTopRight() {
        return grid [0][2];
    }

    public String getTopLeft() {
        return grid[0][0];
    }

    public String getMiddleLeft() {
        return grid [1][0];
    }

    public String getMiddleRight() {
        return grid [1][2];
    }

    public String getBottomLeft() {
        return bottomLeftValue;
    }

    public String getBottomMiddle() {
        return bottomMiddleValue;
    }

    public String getBottomRight() {
        return bottomRightValue;
    }

    public String getMiddle() {
        return grid [1][1];
    }

    public String whoseTurnItIs() {
        //The first time is x's turn
        //when the turn ia an odd number return x
        if (time % 2 == 0) {
            return "o";

            //the second time is o's turn
            //when the turn is an even number return o
        } else {
            return "x";
        }
    }
}



