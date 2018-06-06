/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs472;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sunling
 */
public class QuizServlet extends HttpServlet {

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
        doPost(request, response);
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

        HttpSession session = request.getSession();

        String opt = request.getParameter("opt");
        if (null != opt && "STARTOVER".equals(opt)) {

            session.setAttribute("score", 0);
            session.setAttribute("attempts", 0);

            session.setAttribute("quiz", new Quiz());
            Quiz q = (Quiz) session.getAttribute("quiz");
            session.setAttribute("currQ", q.getNextQ());
            session.setAttribute("currH", q.getHint());
            session.setAttribute("currA", q.getAnswer());
            request.setAttribute("errorMsg", "");
            request.setAttribute("tryMsg", "");

            RequestDispatcher dispatch = request.getRequestDispatcher("quiz.jsp");
            dispatch.forward(request, response);
            return;
        }

        //0.validate age 
        String age = request.getParameter("age");
        String errorMsg = "";
        if (null != age) {
            try {
                if (!"".equals(age)) {
                    int a = Integer.parseInt(age);
                    if (a < 4 || a > 100) {
                        errorMsg = "Age must be between 4 and 100";
                    } else {
                        request.setAttribute("age", age);
                    }
                } else {
                    errorMsg = "Age number is required";
                }
            } catch (NumberFormatException e) {
                errorMsg = "Invalid number";
            }
        }

        //1.Get the Quiz Object
        Object obj = session.getAttribute("quiz");
        if (obj == null) {
            session.setAttribute("quiz", new Quiz());
        }
        Quiz q = (Quiz) session.getAttribute("quiz");
        //2.Check the answer,calculate the score
        Object score = session.getAttribute("score");
        if (score == null) {
            session.setAttribute("score", 0);
        }

        Object attempts = session.getAttribute("attempts");
        if (attempts == null) {
            session.setAttribute("attempts", 0);
        }
        String guess = request.getParameter("guess");
        String tryMsg = "";
        boolean goNext = Boolean.FALSE;
        if (null != guess && !"".equals(guess) && "".equals(errorMsg)) {
            Integer tries = (Integer) session.getAttribute("attempts");
            Integer answer = (Integer) session.getAttribute("currA");
            Integer sc = (Integer) session.getAttribute("score");
            if (answer == Integer.parseInt(guess)) {
                if (tries <= 0) {
                    session.setAttribute("score", sc + 10);
                } else if (tries == 1) {
                    session.setAttribute("score", sc + 5);
                } else if (tries == 2) {
                    session.setAttribute("score", sc + 2);
                }
                goNext = Boolean.TRUE;
                tryMsg = "";
            } else {
                tries++;
                session.setAttribute("attempts", tries);
                if (tries == 3) {
                    tryMsg = "No more Attempt! Correct answer is " + answer;
                    request.setAttribute("answer", answer);
                } else {
                    tryMsg = "Your last answer was not correct! Please try again";
                }
            }
        }
        String fwdPage = "quiz.jsp";
        //3.set next question but when there is error on age field, Q stay the same 
        Object currQ = session.getAttribute("currQ");
        if (null == currQ || goNext) {
            if (q.hasQ()) {
                session.setAttribute("attempts", 0);
                session.setAttribute("currQ", q.getNextQ());
                session.setAttribute("currH", q.getHint());
                session.setAttribute("currA", q.getAnswer());
            } else {
                Integer sc = (Integer) session.getAttribute("score");
                request.setAttribute("grade", getGradeByScore(sc));
                fwdPage = "result.jsp"; 
            }
        }
        request.setAttribute("errorMsg", errorMsg);
        request.setAttribute("tryMsg", tryMsg);

        RequestDispatcher dispatch = request.getRequestDispatcher(fwdPage);
        dispatch.forward(request, response);

    }

    private String getGradeByScore(int score) {
        if (score >= 45 && score <= 50) {
            return "A";
        } else if (score >= 35 && score <= 44) {
            return "B";
        } else if (score >= 25 && score <= 34) {
            return "C";
        } else {
            return "NC";
        }
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
