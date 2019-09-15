/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test1;

import java.util.Arrays;

/**
 *
 * @author Ash_360
 */
public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        int[] arr = {2,1,3,4,5};
//        Arrays.sort(arr);
//        
//        for (int item : arr) {
//            System.out.println(item);
//        }
//        int sum = 0;
//        for (int i=0; i<4; i++) {
//            sum += arr[i];
//        }
//        System.out.println(sum);
        String s = "07:05:45PM";
//        System.out.println(s.substring(s.length()-2, s.length()));
//         String time = s.substring(0, s.length()-2);
//        String [] str = new String [3];
//        str = s.split(":");
//        System.out.println(str[0]);
         String amOrpm = s.substring(s.length()-2, s.length());
//         amOrpm = amOrpm.strip();
//         System.out.println(amOrpm);
        String time = s.substring(0, s.length()-2);
        String [] str = new String [3];
        str = time.split(":");
        int addTime;
        if (amOrpm.equals("PM")) {
            addTime = Integer.parseInt(str[0]) + 12;
            System.out.println(addTime);
            str[0] =  Integer.toString(addTime);
        } 
//        System.out.println(str[0]);
        String hourTime = "";
        for (String _time : str) {
            hourTime += _time;
        }
//        System.out.println(hourTime);
    }
    
}
