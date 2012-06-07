package com.moi.lepresident;

import java.util.List;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

public class StoredComments {
	
	public static void store(String text, String user) {
		Comment comment = new Comment(user, text);
		ObjectifyDAO dao = new ObjectifyDAO();
		dao.ofy().put(comment);
		MemcacheServiceFactory.getMemcacheService().delete("100Comments"); // purge le cache
	}
	
	public static List<Comment> retrieveAll() {
		MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
	    List<Comment> comments = (List<Comment>)cache.get("100Comments");		
	    if (comments == null) {
	    	ObjectifyDAO dao = new ObjectifyDAO();
	    	comments = dao.ofy().query(Comment.class).order("-date").limit(100).list();
	    	cache.put("100Comments", comments);
	    }
	    return comments;
	}

}
