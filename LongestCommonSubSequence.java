

import java.util.Scanner;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int l1 = s1.length();
        int l2 = s2.length();

        int dp[][] = new int[l1+1][l2+1];

        for(int i = 0 ; i <= l1;i++){
            for(int j =0; j <= l2;j++){

                if(i == 0 || j ==0){
                    dp[i][j] = 0;
                }

                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }

        printArray(dp);

        System.out.println( "");
        System.out.println( "");
        System.out.println( "");

//        lcs(s1.toCharArray(),s2.toCharArray(),s1.toCharArray().length,s2.toCharArray().length);

        int length = dp[l1][l2];
        char answers [] = new char[length];
        int i = s1.length(),j = s2.length();
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                answers[length-1] = s1.charAt(i-1);
                i--;j--;
                length--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i = i-1;
            }else{
                j = j-1;
            }
        }
        System.out.println(answers);


    }

   static int lcs( char[] X, char[] Y, int m, int n )
    {
        int L[][] = new int[m+1][n+1];

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }

        printArray(L);
        return L[m][n];
    }

    public static void printArray(int [][] a){
        for(int i = 0 ; i < a.length;i++){
            for(int j = 0 ; j < a[i].length;j++){
                System.out.print(a[i][j] + " ,");
            }
            System.out.println(" ");
        }
    }
}
