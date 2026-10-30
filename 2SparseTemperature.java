// P2: Consolidate temperature data of two stations using sparse matrix (triplet) addition
public class SparseTemperature {
    public static void main(String[] args) {
        // {rows, cols, non-zero count} then {row, col, value}
        int[][] station1 = { {2, 2, 3}, {0, 0, 10}, {0, 1, 20}, {1, 0, 30} };
        int[][] station2 = { {2, 2, 3}, {0, 0, 5},  {0, 1, 8},  {1, 0, 7}  };
        int[][] result   = { {2, 2, 3}, {0, 0, 0},  {0, 1, 0},  {1, 0, 0}  };

        // Add temperatures at the same positions
        result[1][2] = station1[1][2] + station2[1][2]; // 10 + 5
        result[2][2] = station1[2][2] + station2[2][2]; // 20 + 8
        result[3][2] = station1[3][2] + station2[3][2]; // 30 + 7

        System.out.println("Consolidated Temperature Data");
        System.out.println("Row\tColumn\tTemperature");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i][0] + "\t");
            System.out.print(result[i][1] + "\t");
            System.out.println(result[i][2]);
        }
    }
}
