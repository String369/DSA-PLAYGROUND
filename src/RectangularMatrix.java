public class RectangularMatrix {
    public static int solution(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        int wlen = word.length();
        int count = 0;

        // Horizontal (rows)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= cols - wlen; j++) {
                int k = 0;
                while (k < wlen && board[i][j + k] == word.charAt(k)) {
                    k++;
                }
                if (k == wlen) count++;
            }
        }

        // Vertical (columns)
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i <= rows - wlen; i++) {
                int k = 0;
                while (k < wlen && board[i + k][j] == word.charAt(k)) {
                    k++;
                }
                if (k == wlen) count++;
            }
        }
        return count;
    }
public static void main(String[] args) {
    char[][] board = {
            {'a', 'a'},
            {'a', 'a'}
    };
    String word = "aa";
    int result = solution(board, word);
    System.out.println(result); // Expected output: 5
}
}