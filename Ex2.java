public class Ex2 {

    public static int solution(int map[][]) {
        int counter = 0; // number of countries
        int row_size = map.length;
        int col_size = map[0].length;

        // visiting all of the element of array
        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                if (map[i][j] != -1) { // when the array is -1 it means it't not exists as our range is between 0 and
                                       // 300k thus we set the visited elements to -1, in order to ignore it for the
                                       // next neighbour checking
                    counter += 1;
                    neighbors(map, map[i][j], i, j, row_size, col_size); // neighbour check
                }
            }
        }
        return counter;
    }

    private static boolean isValid(int X, int Y, int row_size, int col_size) {
        return X >= 0 && X < row_size && Y >= 0 && Y < col_size;
        // checking if the positions of array (i,j) are included to the boundaries or
        // not
    }

    private static void neighbors(int matrix[][], int current, int x, int y, int row_size, int col_size) {
        matrix[x][y] = -1; // visited element

        int arr[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // for checking the validity of the neighbourhoods
                                                                    // (when the element has less than 4 neighnbour)

        for (int j = 0; j < arr.length; j++) {
            int nextX = x + arr[j][0]; // for upper and bottom neighbours
            int nextY = y + arr[j][1]; // for left and right neighbours
            if (isValid(nextX, nextY, row_size, col_size))
                if (matrix[nextX][nextY] != -1 && matrix[nextX][nextY] == current) // if the element wasn't visited & if
                                                                                   // the value is matching to the
                                                                                   // number of our requirement then we
                                                                                   // keep the recursivity
                    neighbors(matrix, matrix[nextX][nextY], nextX, nextY, row_size, col_size);
        }
    }

    public static void main(String[] args) {
        int map[][] = { { 1, 2 }, { 2, 2 }, { 3, 5 }, { 3, 2 } };

        System.out.println("We have *" + solution(map) + "* countries in the map.");

    }
}