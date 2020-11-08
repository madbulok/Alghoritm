package homework.lesson2.exeptions;

public class MyArrayDataException extends NumberFormatException {

    private int column;
    private int row;

    public MyArrayDataException(String message, int column, int row) {
        super(message);
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
