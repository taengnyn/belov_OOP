public class GenericMatrix {
    public interface MatrixElement<T> {
        T getValue();
        void setValue(T value);
    }

    public static class MyMatrixElement<T> implements MatrixElement<T> {
        private T value;

        public MyMatrixElement(T value) {
            this.value = value;
        }

        @Override
        public T getValue() {
            return value;
        }

        @Override
        public void setValue(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString(); // Повертаємо рядок, представлення значення об'єкта
        }
    }

    public static class Matrix<T> {
        private final int rows;
        private final int cols;
        private final T[][] arr;

        public Matrix(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            arr = (T[][]) new Object[rows][cols];
        }

        public int getRows() {
            return rows;
        }

        public int getCols() {
            return cols;
        }

        public T getElement(int i, int j) {
            return arr[i][j];
        }

        public void setElement(int i, int j, T element) {
            arr[i][j] = element;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < rows; i++) {
                sb.append("[");
                for (int j = 0; j < cols; j++) {
                    sb.append(arr[i][j]);
                    if (j < cols - 1) {
                        sb.append(", ");
                    }
                }
                sb.append("]\n");
            }
            return sb.toString();
        }


    }
}
