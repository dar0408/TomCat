
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class Login extends HttpServlet {

    // Handles GET request (e.g. visiting /login directly)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.html");
    }

    // Handles POST request (form submission)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Username validation: Starts with capital letter, at least 3 characters
        boolean isUsernameValid = username != null && username.matches("^[A-Z][a-zA-Z]{2,}$");

        // Password validation: min 8 chars, at least 1 uppercase, 1 number, exactly 1 special char
        boolean isPasswordValid = password != null &&
                password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[!@#$%^&*()].*") &&
                password.replaceAll("[^!@#$%^&*()]", "").length() == 1;

        if (isUsernameValid && isPasswordValid) {
            request.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.jsp");
            rd.forward(request, response);
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3 style='color:red;'>Invalid Username or Password Format!</h3>");
            out.println("<a href='login.html'>Try Again</a>");
        }
    }
}
