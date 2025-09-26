import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college_association", "root", "password");
            PreparedStatement ps = con.prepareStatement("INSERT INTO users(username,password,role) VALUES(?,?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, "student");
            ps.executeUpdate();
            
            response.sendRedirect("login.jsp?registered=1");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}