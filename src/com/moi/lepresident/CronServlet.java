package com.moi.lepresident;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CronServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		President president = new President();
		president.active = true;
		president.name = "Hollande";
		president.image = "image\\hollande.png";
		new ObjectifyDAO().ofy().put(president);
	}

}
