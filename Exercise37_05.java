package chapter37;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Exercise37_05 extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();

        try {
            // Retrieve input values from the form
            double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
            double interestRate = Double.parseDouble(request.getParameter("interestRate"));
            int years = Integer.parseInt(request.getParameter("years"));

            // Create Loan object and calculate payments
            Loan loan = new Loan(interestRate, years, loanAmount);
            double monthlyPayment = loan.getMonthlyPayment();
            double totalPayment = loan.getTotalPayment();

            // Display the input values
            out.println("<html><head><title>Loan Payment Results</title></head><body>");
            out.println("<h3>Loan Payment Results</h3>");
            out.printf("<p>Loan Amount: $%.2f</p>", loanAmount);
            out.printf("<p>Interest Rate: %.2f%%</p>", interestRate);
            out.printf("<p>Number of Years: %d</p>", years);

            // Display the calculated payments
            out.printf("<p>Monthly Payment: $%.2f</p>", monthlyPayment);
            out.printf("<p>Total Payment: $%.2f</p>", totalPayment);
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            // Display an error message if input is invalid
            out.println("<html><head><title>Error</title></head><body>");
            out.println("<h3>Error: Invalid input. Please enter numeric values.</h3>");
            out.println("<a href='Loan.html'>Go back to Loan Form</a>");
            out.println("</body></html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Loan Calculator</title></head><body>");
        out.println("<h3>Please submit the loan details via the form.</h3>");
        out.println("<a href='Loan.html'>Go back to Loan Form</a>");
        out.println("</body></html>");
        out.close();
    }
}
