/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.test.Classes;

import test.test.Forms.*;

/**
 *
 * @author user
 */
public class Main {
    public static void main(String args[]) {
        test.test.Config.ActiveJDBC.Init();
        
        new Form().setVisible(true);
        
        Temp.test();
    }
}
