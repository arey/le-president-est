package com.moi.lepresident;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;

public class ObjectifyDAO extends DAOBase {
	
	static {
		 ObjectifyService.register(Comment.class);
		
	}

}
