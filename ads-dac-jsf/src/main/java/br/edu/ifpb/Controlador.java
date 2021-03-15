package br.edu.ifpb;

import br.edu.ifpb.domain.Funcionario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Controlador",urlPatterns = {"/controlador"})
public class Controlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        Funcionario funcionario = new Funcionario("");
        funcionario.alterarNome();
        encaminharResposta(request, response, funcionario);
    }

    private void encaminharResposta(HttpServletRequest request, HttpServletResponse response, Funcionario funcionario)
            throws IOException{

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDePessoa</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Nome: " + funcionario.getNome() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
