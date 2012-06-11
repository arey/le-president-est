package com.moi.lepresident;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MailHandlerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Properties props = new Properties(); 
		Session session = Session.getDefaultInstance(props, null);
		try {
			MimeMessage message = new MimeMessage(session, req.getInputStream());
			Multipart content = (Multipart) message.getContent();
			StoredComments.store((String) content.getBodyPart(0).getContent(), message.getFrom()[0].toString());
			
			Message reply = message.reply(false);
	        reply.setFrom(new InternetAddress("antoine.rey@gmail.com"));
	        reply.setText("Merci pour votre commentaire");
	        Transport.send(reply);
		} catch (MessagingException e) {
			throw new ServletException(e);
		}

	}
}
