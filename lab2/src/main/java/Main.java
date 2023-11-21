import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        GenericMatrix.Matrix<GenericMatrix.MatrixElement<String>> matrix = new GenericMatrix.Matrix<>(3, 3);
        String[][] data = {{"1", "1", "1"}, {"a2", "b2", "c2"}, {"a1", "b1", "c1"}};


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int finalI = i;
                int finalJ = j;
                matrix.setElement(i, j, new GenericMatrix.MatrixElement<String>() {
                    private String value = data[finalI][finalJ];

                    @Override
                    public String getValue() {
                        return value;
                    }

                    @Override
                    public void setValue(String value) {
                        this.value = value;
                    }
                });
            }
        }

        String t = "";

        matrix.setElement(0, 0, new GenericMatrix.MatrixElement<String>() {
            @Override
            public String getValue() {
                return t;
            }

            @Override
            public void setValue(String value) {

            }
        });

        // Виведіть матрицю на екран
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix.getElement(i, j).getValue() + " ");
            }
            System.out.println();
        }
    }


}






