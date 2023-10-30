public class Main {
    public static void main(String[] args) {
        // Створення об'єкта матриці з 3 рядками і 4 стовпцями
        Matrix myMatrix = new Matrix(3, 4);

        // Встановлення значення елементу матриці
        myMatrix.setElement(0, 0, 5);
        myMatrix.setElement(1, 2, 8);
        myMatrix.setElement(2, 3, 3);


        // Отримання значення елементу матриці
        int value = myMatrix.getElement(0, 0);
        System.out.println("This value is: " + value);

        // Отримання кількості рядків і стовпців у матриці
        int numRows = myMatrix.getRows();
        int numColumns = myMatrix.getColumns();
        System.out.println("Number of rows: " + numRows);
        System.out.println("Number of columns: " + numColumns);
        System.out.println("----Matrix----");
        myMatrix.printMatrix();
    }
}






