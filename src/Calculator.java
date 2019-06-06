import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Calculator", urlPatterns = "/Calculator")
public class Calculator extends HttpServlet {
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html"); //ustawienie typu odpowiedzi czyli HTTP
        response.setCharacterEncoding("UTF-8"); // ustawienie kodowania (znaki polskie)

        try (PrintWriter out = response.getWriter()) {

            int number1 = Integer.valueOf(request.getParameter("t1"));
            int number2 = Integer.valueOf(request.getParameter("t2"));
            String op = request.getParameter("operator");

            if (op.equals("+")) {
                out.println("Addition of " + number1 + " and " + number2 + " is " + (number1+number2));
            } else if (op.equals("-")) {
                out.println("Sybtraction of " + number1 + " and " + number2 + " is " + (number1-number2));
            } else if (op.equals("*")) {
                out.println("Multiplication of " + number1 + " and " + number2 + " is " + (number1*number2));
            } else if (op.equals("/")) {
                out.println("Division of " + number1 + " and " + number2 + " is " + (number1/number2));
            }
        }
    }
}
