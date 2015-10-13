package com.mycompany.miniprojectreg;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import java.sql.*;

/**
 * Example resource class hosted at the URI path "/myresource"
 */

@Path("/update")

public class update {

    static String driver;
    static String url;
    static Connection con;
    static Statement stm;
    static ResultSet RS,RS1;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{myresource1}/{myresource2}")

    public String getIt1(@PathParam("myresource1") String domain, @PathParam("myresource2") String guide) throws SQLException {
        System.out.println(domain + "\t" + guide);
        return insert(domain, guide);
    }

    public static String insert(String input1, String input2) throws SQLException {
        String login = "false";
        String str;
        try {
            
            String url = "jdbc:mysql://localhost:3306/miniproject";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "abc", "Project123");
            str = "Database connection established";
            System.out.println(str);
            int i=0;
            stm = con.createStatement();
            System.out.println(input1 + "\t" + input2);
            String sql = "";     // where Username = '"+str1+"' and Password = '"+str2+"' "; 
            RS = stm.executeQuery(sql);

            while (RS.next()) {
                String Username = RS.getString("Username");
                String Password = RS.getString("Password");
                if (Username.equals(input1) & Password.equals(input2)) {

                    System.out.println("Logged In Successfully !");
                   String sql1 = "SELECT * FROM students2015_16 where GRNo='" + input1 + "'";
                    RS1= stm.executeQuery(sql1);
                    if(RS1.next())
                    {
                        System.out.println(RS1.getString("DivisionName") + RS1.getString("RollNo") + RS1.getString("GRNo") + RS1.getString("FirstName") + RS1.getString("MiddleName") + RS1.getString("SurName") + RS1.getString("Course") + RS1.getString("Branch") + RS1.getString("Class") + RS1.getString("ModuleName") + RS1.getString("Gender"));
                        login= RS1.getString("DivisionName") +'_'+ RS1.getString("RollNo")+'_'+ RS1.getString("GRNo") +'_'+ RS1.getString("FirstName") + '_'+RS1.getString("MiddleName") + '_'+RS1.getString("SurName") +'_'+ RS1.getString("Course") +'_'+ RS1.getString("Branch") +'_'+ RS1.getString("Class") +'_'+ RS1.getString("ModuleName") +'_'+ RS1.getString("Gender");
                    }
                    return login;
                } else {
                    System.out.println("Invalid Username Or Password!");
                    login = "false";
                }
            }
        } catch (Exception err) {
            System.out.println("ERROR: " + err);
        }
        return login;
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{a}")
        public String print()
        {
            return "Insufficient Data";
        }

}
