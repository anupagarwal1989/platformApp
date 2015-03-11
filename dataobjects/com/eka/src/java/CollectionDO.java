package dataobjects.com.eka.src.java;

import java.util.Date;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

public class CollectionDO {
	 	private String id;
	    private String title;
	    private boolean done;
	    private Date createdOn = new Date();
	 
	    public CollectionDO(BasicDBObject dbObject) {
	        this.id = ((ObjectId) dbObject.get("_id")).toString();
	        this.title = dbObject.getString("title");
	        this.done = dbObject.getBoolean("done");
	        this.createdOn = dbObject.getDate("createdOn");
	    }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public boolean isDone() {
			return done;
		}

		public void setDone(boolean done) {
			this.done = done;
		}

		public Date getCreatedOn() {
			return createdOn;
		}

		public void setCreatedOn(Date createdOn) {
			this.createdOn = createdOn;
		}
	    
	    
	    
	    

}
