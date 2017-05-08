/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.util.ArrayList;
import java.util.Scanner;



public class Solution {

  

   public static void main(String[] args) {
       
       ArrayList <String> list = new ArrayList < String >();
       
   Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();        
         in.nextLine();        
        for(int i=0; i<testCases; i++){
           
            String s = in.nextLine();
            list.add(s);
            String res = printResult(list.get(i), i + 1);
            if ( i < testCases - 1 ) {
                System.out.print("Case #" + (i + 1) + ": " + res + "\n");
            } else {
                System.out.print("Case #" + (i + 1) + ": " + res);
            }
            
        }
    
    }  
   
    private static String printResult(String string, int index) {
        String s = string.replaceAll( "[^:\\(\\)]", "" );

        for (int i = 0; i < s.length() / 2; i++) {
            String lead = "";
            String trail = "";
            if (s.charAt(i) == '(' && s.charAt(s.length() - i - 1) == ')') {
                if (i > 0) {
                    lead = s.substring(0, i);
                    trail = s.substring(s.length() - i, s.length());
                }
                s = lead + s.substring(i + 1, s.length() - i - 1) + trail;
                --i;
            }
        }
        s = s.replaceAll( ":\\(", "" );
        s = s.replaceAll( ":\\)", "" );

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                return "NO";
            }
        }

        return "YES";
     }
   
}



