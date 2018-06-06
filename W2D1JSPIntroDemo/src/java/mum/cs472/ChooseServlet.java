/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs472;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sunling
 */
public class ChooseServlet extends HttpServlet {
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatch = request.getRequestDispatcher("choose.jsp");
        dispatch.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String choice1 = request.getParameter("radioJSPCool");
        
        if (choice1 != null) {
            RadioState state = new RadioState();
            state.checked(choice1); 
            request.setAttribute("stateJSP", state);
        }
        String choice2 = request.getParameter("JSFwayCool");
        if(choice2 != null){
            RadioState state = new RadioState();
            state.checked(choice2); 
            request.setAttribute("stateJSF", state);
        }
        String choice3 = request.getParameter("moonCheese");
        if(choice3 != null){
            RadioState state = new RadioState();
            state.checked(choice3); 
            request.setAttribute("stateMoon", state);
        }
        RequestDispatcher dispatch = request.getRequestDispatcher("choose.jsp");
        dispatch.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
