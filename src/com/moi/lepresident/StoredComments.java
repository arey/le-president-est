package com.moi.lepresident;

import java.util.List;

public class StoredComments {
	
	public static void store(String text, String user) {
		Comment comment = new Comment(user, text);
		ObjectifyDAO dao = new ObjectifyDAO();
		dao.ofy().put(comment);
	}
	
	public static List<Comment> retrieveAll() {
		ObjectifyDAO dao = new ObjectifyDAO();
		return dao.ofy().query(Comment.class).order("-date").limit(100).list();
	}

}
