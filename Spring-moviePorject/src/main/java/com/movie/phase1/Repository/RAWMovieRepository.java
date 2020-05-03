package com.movie.phase1.Repository;

import com.movie.phase1.module.Movie;
import org.sqlite.SQLiteConfig;

import java.sql.*;
import java.util.ArrayList;

public class RAWMovieRepository {

   /* @Autowired
    private PasswordEncoder passwordEncoder;
   public static void main(String[] args) {

        RAWMovieRepository r= new RAWMovieRepository();
      //  r.encryptpassword(r.connectDB());
       // r.updatepass(r.connectDB());
      //  r.encryptpassword(r.connectDB());
       // ArrayList<String> c= r.getpass(r.connectDB());
       r.change();
    }
    public PasswordEncoder  encoder() {
        //return new StandardPasswordEncoder("53cr3t");
        return  new BCryptPasswordEncoder();
    }
    public void change(){
        ArrayList<String> c= this.getpass(this.connectDB());

        for(int i=0; i<c.size(); i++) {
            //    String v = (String) new BCryptPasswordEncoder().encode(c.get(i));
            String x= passwordEncoder.encode("pass");
            this.updateBookRecord(this.connectDB(), x, i+1);
        }
    }
*/
    private Connection connectDB() {

        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            con = DriverManager.getConnection("jdbc:sqlite:C:/Users/User/Desktop/MovieMadnessDB2.db", config.toProperties());
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        }
        return con;
    }

    public void updatepass(Connection con){
        String sql = "UPDATE tblUsers SET password = BCryptPasswordEncoder().encode(password) ";

        try (//Connection conn = this.connect();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            // set the corresponding param
        //    pstmt.setString(1, BCryptPasswordEncoder().encode(password));

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

public  void encryptpassword(Connection con){
  //  String encoded = new BCryptPasswordEncoder().encode(plainTextPassword);
    Statement stmnt = null;
    ArrayList<String> p= getpass(con);
int i=0;
    System.out.println(p.get(0));
    try {

        String getBooksQuery = new StringBuilder().append("update tblUsers set password = \'").append(p.get(0)).append("\' where user_id = 1").toString();
        System.out.println(getBooksQuery);
        stmnt = con.createStatement();
        stmnt.executeQuery(getBooksQuery);

    } catch (Exception ex) {
        System.out.println(ex.getClass());
        ex.printStackTrace();
    } finally {
        try {
            stmnt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

    public ArrayList<Movie> getmovies(Connection con) {

        ArrayList<Movie> all_movies = new ArrayList<>();
        Statement stmnt = null;

        try {
            String getBooksQuery = "SELECT movie_id , movie_title FROM tblMovies";
            stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery(getBooksQuery);

            while (rs.next()) {
                Movie m = new Movie();
                m.setMovie_id(rs.getInt("movie_id"));
                m.setMovie_title(rs.getString("movie_title"));

                all_movies.add(m);
            }

        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        } finally {
            try {
                stmnt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return all_movies;
    }

    public boolean updateBookRecord(Connection con, String vale, int id){


        try {
          //  ArrayList<String> p= getpass(con);
          //  System.out.println(p.get(0));
            String updateRecord = "UPDATE tblUsers SET password = ? WHERE user_id = ?";

            PreparedStatement pst = con.prepareStatement(updateRecord);

           // String x= p.get(0);
            pst.setString(1, vale);
            pst.setInt(2, id);

           // System.out.println(updateRecord);

            pst.executeUpdate();
            pst.close();
        }
        catch(Exception ex){
            System.out.println(ex.getClass());
            ex.printStackTrace();
            return false;
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    public ArrayList<String> getpass(Connection con) {

        ArrayList<String> passes = new ArrayList<>();
        Statement stmnt = null;

        try {
            String getBooksQuery = "SELECT password FROM tblUsers";
            stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery(getBooksQuery);

            while (rs.next()) {
//                Movie m = new Movie();
//                m.setMovie_id(rs.getInt("movie_id"));
//                m.setMovie_title(rs.getString("movie_title"));

                passes.add(rs.getString("password"));
            }

        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        } finally {
            try {
                stmnt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return passes;
    }


    public Connection getDBConnetion() {
        Connection con = connectDB();
      //  createTables(con);
        return con;
    }
}


