package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Hello</title></head>");
        out.println("<body>");
        out.println("<h1>Hello from Java Servlet!</h1>");
        out.println("<a href='index.html'>Go to static HTML</a>");
        out.println("</body></html>");
    }
}
