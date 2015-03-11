package service.com.eka;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import dataobjects.com.eka.src.java.CollectionDO;
import dataobjects.com.eka.src.java.SmartAPPPlatformConstants;

public class CollectionOperationService extends CommonOperationService {
	
    public CollectionOperationService(DB db) {
		super(db);
	}

	public List<BasicDBObject> getCollectionList() {
        List<CollectionDO> collectionDOs = new ArrayList<>();
        List<BasicDBObject> listBasicDBObjects = new ArrayList<BasicDBObject>();
        DBCollection collection = db.getCollection(SmartAPPPlatformConstants.COLLECTION_LIST);
        DBCursor dbObjects = collection.find();    
        
        while (dbObjects.hasNext()) {
            DBObject dbObject = dbObjects.next();
            System.out.println((BasicDBObject) dbObject);
            listBasicDBObjects.add((BasicDBObject) dbObject);
            collectionDOs.add(new CollectionDO((BasicDBObject) dbObject));
        }
        return listBasicDBObjects;
    }
 
    public void createCollection(String body) {
    	
    	CollectionDO collectionDO = new Gson().fromJson(body, CollectionDO.class);
    	BasicDBObject basicDBObject = new BasicDBObject("title", collectionDO.getTitle()).append("done", collectionDO.isDone()).append("createdOn", new Date());
        
    	insertCollection(basicDBObject, SmartAPPPlatformConstants.COLLECTION_LIST);
    }
 
    public void removeCollection(String collId) {
      	
    	BasicDBObject basicDBObject = new BasicDBObject("_id", new ObjectId(collId));
    	deleteSpecficCollection(basicDBObject, SmartAPPPlatformConstants.COLLECTION_LIST);
    }

}
