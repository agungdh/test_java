/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.test.Config;

import org.javalite.activejdbc.Base;

/**
 *
 * @author user
 */
public class ActiveJDBC {
    public static void Init(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/cilara_test", "root", "");
    }
}
