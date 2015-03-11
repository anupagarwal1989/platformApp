package service.com.eka;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class CommonOperationService {
	
    public final DB db;
    
    public CommonOperationService(DB db) {
        this.db = db;
    }
    
    public void createCollection(String collectionName,BasicDBObject basicDBObject) {
    	DBCollection collection = db.createCollection(collectionName, basicDBObject);
        collection.insert(basicDBObject);
    }
    
    public void insertCollection(BasicDBObject basicDBObject,String collectionName) {
        	DBCollection collection = db.getCollection(collectionName);
            collection.insert(basicDBObject);
    }
 
    public void deleteSpecficCollection(BasicDBObject basicDBObject,String collectionName) {
    	DBCollection collection = db.getCollectionFromString(collectionName);
    	collection.remove(basicDBObject) ;
    }

    public void updatecollection(BasicDBObject oldDbObject ,BasicDBObject newDbObject ,String collectionName) {
    	DBCollection collection = db.getCollectionFromString(collectionName);
    	collection.update(oldDbObject, newDbObject);
    }
    
}
