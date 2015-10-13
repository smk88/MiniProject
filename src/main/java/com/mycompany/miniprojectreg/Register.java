/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miniprojectreg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/register")

public class Register {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String reg(String group) throws Exception {
        System.out.println("IN REGISTER");
        System.out.println(group);
        JSONObject inputJsonObj = new JSONObject(group);
        String div = (String) inputJsonObj.get("div");
        String year = (String) inputJsonObj.get("year");
        String grno1 = (String) inputJsonObj.get("grno1");
        String grno2 = (String) inputJsonObj.get("grno2");
        String grno3 = (String) inputJsonObj.get("grno3");
        String grno4 = (String) inputJsonObj.get("grno4");
        String grno5 = (String) inputJsonObj.get("grno5");
        String roll1 = (String) inputJsonObj.get("roll1");
        String roll2 = (String) inputJsonObj.get("roll2");
        String roll3 = (String) inputJsonObj.get("roll3");
        String roll4 = (String) inputJsonObj.get("roll4");
        String roll5 = (String) inputJsonObj.get("roll5");
        String name1 = (String) inputJsonObj.get("name1");
        String name2 = (String) inputJsonObj.get("name2");
        String name3 = (String) inputJsonObj.get("name3");
        String name4 = (String) inputJsonObj.get("name4");
        String name5 = (String) inputJsonObj.get("name5");
        String domain1 = (String) inputJsonObj.get("domain1");
        String domain2 = (String) inputJsonObj.get("domain2");
        String domain3 = (String) inputJsonObj.get("domain3");
        try {

            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/miniproject";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "abc", "Project123");
            // the mysql insert statement
            String query = " insert into register (year,grpid, divname, grno1,grno2,grno3,grno4,grno5,rollno1,rollno2,rollno3,rollno4,rollno5, name1,name2,name3,name4,name5, domain1,domain2,domain3,domain_allot,guide)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt1 = conn.prepareStatement(query);
            preparedStmt1.setString(1, year);
            preparedStmt1.setString(2, "1");
            preparedStmt1.setString(3, div);
            preparedStmt1.setString(4, grno1);
            preparedStmt1.setString(5, grno2);
            preparedStmt1.setString(6, grno3);
            preparedStmt1.setString(7, grno4);
            preparedStmt1.setString(8, grno5);
            preparedStmt1.setString(9, roll1);
            preparedStmt1.setString(10,roll2);
            preparedStmt1.setString(11,roll3);
            preparedStmt1.setString(12, roll4);
            preparedStmt1.setString(13, roll5);
            preparedStmt1.setString(14, name1);
            preparedStmt1.setString(15, name2);
            preparedStmt1.setString(16, name3);
            preparedStmt1.setString(17, name4);
            preparedStmt1.setString(18, name5);
            preparedStmt1.setString(19, domain1);
            preparedStmt1.setString(20, domain2);
            preparedStmt1.setString(21, domain3);
            preparedStmt1.setString(22, "-");
            preparedStmt1.setString(23, "-");
            //execute the preparedstatement
            preparedStmt1.execute();

            conn.close();
            return "Success";
        } catch (Exception err) {
            System.out.println("ERROR: " + err);
        }
        return null;

    }
}
