package com.greatlearning.db.controller;

import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.db.model.User;

@RestController
public class CouchDbController {
	
	Logger logger=LoggerFactory.getLogger(CouchDbController.class);
	
	@PostMapping("/create")
	public User get(@RequestBody User user) {
		logger.info("enter");
			HttpClient httpClient = new StdHttpClient.Builder()
                .host("localhost")
                .port(5984)
                .username("admin")
                .password("admin")
                .build();
			CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
			//- - - - - - - - Creating database - - - - - - - - - - - - - - //
			CouchDbConnector db = new StdCouchDbConnector("userdb", dbInstance);
			logger.info(user.getId()+user.getUsername());
			db.create(user);
			
			logger.info("exit");
		return user;
	}
	
	@GetMapping("/users")
	public List<String> getAll() {
		logger.info("enter");
			HttpClient httpClient = new StdHttpClient.Builder()
                .host("localhost")
                .port(5984)
                .username("admin")
                .password("admin")
                .build();
			CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
			//- - - - - - - - Creating database - - - - - - - - - - - - - - //
			CouchDbConnector db = new StdCouchDbConnector("userdb", dbInstance);
			logger.info("exit");
		return db.getAllDocIds();
	}
	
	@GetMapping("/user/{userId}")
	public User getById(@PathVariable("userId") String userId) {
		logger.info("userId" + userId);
		logger.info("enter");
			HttpClient httpClient = new StdHttpClient.Builder()
                .host("localhost")
                .port(5984)
                .username("admin")
                .password("admin")
                .build();
			CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
			//- - - - - - - - Creating database - - - - - - - - - - - - - - //
			CouchDbConnector db = new StdCouchDbConnector("userdb", dbInstance);
			logger.info("exit");
		return db.get(User.class, userId);
	}
	
	@PostMapping("/update")
	public User update(@RequestBody User user) {
		logger.info("enter");
			HttpClient httpClient = new StdHttpClient.Builder()
                .host("localhost")
                .port(5984)
                .username("admin")
                .password("admin")
                .build();
			CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
			//- - - - - - - - Creating database - - - - - - - - - - - - - - //
			CouchDbConnector db = new StdCouchDbConnector("userdb", dbInstance);
			
			User userTmp = db.get(User.class, user.getId());
			user.setRevision(userTmp.getRevision());
			updateUser(user,db);
			
			logger.info("exit");
			
		return user;
	}
	
	private void updateUser(User user, CouchDbConnector db) {
		db.update(user);
		
	}

	@DeleteMapping("/delete")
	public User deleteById(@RequestBody User user) {
		logger.info("enter");
			HttpClient httpClient = new StdHttpClient.Builder()
                .host("localhost")
                .port(5984)
                .username("admin")
                .password("admin")
                .build();
			CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
			//- - - - - - - - Creating database - - - - - - - - - - - - - - //
			CouchDbConnector db = new StdCouchDbConnector("userdb", dbInstance);
			User userTmp = db.get(User.class, user.getId());
			deleteUser(userTmp,db);
			
			logger.info("exit");
			
		return userTmp;
	}
	
	private void deleteUser(User user, CouchDbConnector db) {
		db.delete(user);
		
	}
	 

}
