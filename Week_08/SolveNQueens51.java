import java.util.*;

public class SolveNQueens51 {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();

        helper(res,new ArrayList<>(),0,n,columns,diagonals1,diagonals2);
        return res;

    }

    public void helper(List<List<String>> res, List<String> tempList, int k, int n ,Set<Integer> columns ,Set<Integer> diagonals1 ,Set<Integer> diagonals2 ) {

        if (k > n - 1) {
            List<String> copy = new ArrayList<>(tempList);
            res.add(copy);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) {
                continue;
            }
            int diagonal1 = k - i;
            if (diagonals1.contains(diagonal1)) {
                continue;
            }
            int diagonal2 = k + i;
            if (diagonals2.contains(diagonal2)) {
                continue;
            }
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= i-1; j++) {
                sb.append('.');
            }
            sb.append("Q");
            for (int j = i+1; j < n; j++) {
                sb.append('.');
            }
            tempList.add(sb.toString());
            helper(res, tempList, k + 1, n, columns, diagonals1, diagonals2);
            tempList.remove(tempList.size() - 1);
            columns.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }

    public static void main(String[] args) {
        SolveNQueens51 solveNQueens51 = new SolveNQueens51();

        System.out.println(solveNQueens51.solveNQueens(4));

    }
}
