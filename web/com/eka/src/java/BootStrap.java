package web.com.eka.src.java;

import static spark.SparkBase.ipAddress;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;
import service.com.eka.CollectionOperationService;
import service.com.eka.DataViewOperationService;
import service.com.eka.InSightsOperationService;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class BootStrap {
	public static void main(String[] args) throws Exception {
		ipAddress("localhost");
		port(3000);
		staticFileLocation("/public");
		new CollectionResource(new CollectionOperationService(mongo()));
		new DataViewResource(new DataViewOperationService(mongo()));
		new InSightsResource(new InSightsOperationService(mongo()));
		System.out.print("hello::");
		//get("/hello", (req, res) -> "Hello World");
	}

	private static DB mongo() throws Exception {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		return mongoClient.getDB("nodetest");
	}
}
