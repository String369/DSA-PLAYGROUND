public class RectangularMatrix {
    public static int solution(char[][] board, String word) {
        int cols = board[0].length;
        int wlen = word.length();
        int count = 0;

        // Horizontal (rows)
        for (char[] chars : board) {
            for (int j = 0; j <= cols - wlen; j++) {
                int k = 0;
                while (k < wlen && chars[j + k] == word.charAt(k)) {
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