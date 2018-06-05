

import java.util.Scanner;

public class LongestPalindromSubString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        int length = s1.length();

        //Here we will dp array of 2 dimensinonal which will have true and false if substring S[i...j] is palindrome.
        boolean dp[][] = new boolean[length][length];
        int maxLength = 0;
        int start = 0;

        //Now fill this DP array based on 3 variants
        //1. one character substring string always be palindrome
        //2. two character substring will be plaindrome if both are same character
        //3. fill for more than 3 character sub string
/**
 *      DP recusrence and overlapping structure of problem is :
 *            P(i,j)={   true,if the substring Si…Sj is a palindr
 *                       false, omeotherwise.
 *                     }
 *
 *             Therefore,
 *
 *                 P(i,j)=(P(i+1,j−1) and Si == Sj
 *
 */

        // One character sub string
        for(int i =0; i < length;i++){
            dp[i][i] = true;
            maxLength = 1;
        }

        for(int i =0 ; i < length-1;i++){
            if(s1.charAt(i) == s1.charAt(i+1)){
                dp[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for(int k = 3 ; k < length ; k++){
            for(int i = 0 ; i < length -k +1;i++){

                //Get the ending index of substring
                int j = i+k-1;
                if(dp[i+1][j-1] && s1.charAt(i) == s1.charAt(j)){
                    dp[i][j] = true;
                    maxLength = k;
                    start = i;
                }

            }
        }

        System.out.print("Longest palindrome substring is length  "+maxLength);
        System.out.println(s1.substring(start,start + maxLength));


    }
}
