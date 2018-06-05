

import java.util.Scanner;

public class LongestPalindromSubSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();

        StringBuilder sb = new StringBuilder(s1).reverse();
        String s2 = sb.toString();

        int l1 = s1.length();
        int l2 = s2.length();

        int dp[][] = new int[l1+1][l2+1];
        for(int r =0 ; r <= l1;r++){
            for(int c = 0;c<= l2 ;c++){
                if(r ==0 || c ==0){
                    dp[r][c] = 0;
                }
               else  if(s1.charAt(r-1) == s2.charAt(c-1)){
                    dp[r][c] = dp[r-1][c-1]+1;
                }
                else {
                    dp[r][c] = Math.max(dp[r-1][c],dp[r][c-1]);
                }

            }
        }
        printArray(dp);
        System.out.println("length of longest palindrom :" + dp[l1][l2]);

        char answer [] = new char[dp[l1][l2]];
        int length = dp[l1][l2];

        int i = l1;
        int j = l2;
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                answer[length-1] = s1.charAt(i-1);
                i--;j--;length--;
            }
            else if(dp[i-1][j] > dp [i][j-1]){
                i--;

            }
            else{
                j--;
            }
        }





        System.out.println(answer);



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
