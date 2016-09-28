package com.zetcode.web;

import com.zetcode.service.ReadBugs;
import com.zetcode.util.Utils;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Bugs", urlPatterns = {"/Bugs"})
public class Bugs extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String term = request.getParameter("term");
        String q = term.toLowerCase();

        List<String> bugsList = ReadBugs.readAll(getServletContext());
        List<String> filteredBugsList = Utils.filterListByTerm(bugsList, q);
        String json = Utils.list2Json(filteredBugsList);

        response.getWriter().write(json);
    }
}
