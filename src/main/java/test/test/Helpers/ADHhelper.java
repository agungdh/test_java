/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.test.Helpers;

import static java.lang.System.out;

/**
 *
 * @author user
 */
public class ADHhelper {
    public static void d(String string, boolean pembatas) {
        if (!pembatas) {
            out.println(string);
        } else {
            d(string);
        }
    }
    
    public static void d(String string) {
        out.println("===========================================");
        out.println(string);
        out.println("===========================================");
    }
}
