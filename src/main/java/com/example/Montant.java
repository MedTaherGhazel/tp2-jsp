package com.example;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Montant")
public class Montant extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final double TVA = 0.12;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codeClient = request.getParameter("codeClient");
        double article1 = Double.parseDouble(request.getParameter("article1"));
        double article2 = Double.parseDouble(request.getParameter("article2"));
        double article3 = Double.parseDouble(request.getParameter("article3"));

        double totalHT = article1 + article2 + article3;
        double totalTTC = totalHT + (totalHT * TVA);

        request.setAttribute("codeClient", codeClient);
        request.setAttribute("totalTTC", totalTTC);

        request.getRequestDispatcher("resultat.jsp").forward(request, response);
    }
}
