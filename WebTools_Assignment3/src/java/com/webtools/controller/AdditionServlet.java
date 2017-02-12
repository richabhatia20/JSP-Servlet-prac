/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webtools.controller;

import com.webtools.beans.MovieBean;
import com.webtools.dao.MovieDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author richa
 */
public class AdditionServlet extends HttpServlet {

    
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
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdditionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdditionServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MovieDAO moviedaoObj = new MovieDAO();
        try {
           
                                String movieTitle=request.getParameter("movieTitle");
				String movieActor=request.getParameter("movieActor");
				String movieActress=request.getParameter("movieActress");
				String movieGenre=request.getParameter("movieGenre");
				String movieYear=request.getParameter("movieYear");
				
				MovieBean movie=new MovieBean();
				movie.setMovieTitle(movieTitle);
                                movie.setMovieActor(movieActor);
                                movie.setMovieActress(movieActress);
                                movie.setMovieGenre(movieGenre);
                                movie.setMovieYear(Integer.parseInt(movieYear));
                                        
                                        
				System.out.println(movieTitle+movieActor+movieActress+movieGenre+movieYear);
				
					boolean flag=moviedaoObj.addMovie(movie);
					
					if(flag==true)
					{
						
						System.out.println("Movie added");
						response.sendRedirect("addsuccess.jsp");
					}
					else
					{
						
						System.out.println("Movie not added");
						response.sendRedirect("errorpage.jsp");
					}

            
        } catch (Exception e) {
            System.out.println("Exception occured in doPost: " + e.getMessage());
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
