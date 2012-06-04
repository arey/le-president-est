package com.moi.lepresident;

import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;

public class StoredComments {
	
	public static void store(String text, String user) {
		Entity comment = new Entity("Comment");
		comment.setProperty("user", user);
		comment.setProperty("date", new Date());
		comment.setProperty("text", text);
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
		datastoreService.put(comment);
	}
	
	public static List<Entity> retrieveAll() {
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Comment");
		query.addSort("date", SortDirection.DESCENDING);
		return datastoreService.prepare(query).asList(FetchOptions.Builder.withLimit(100));
	}

}
