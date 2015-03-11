package web.com.eka.src.java;

import static spark.Spark.get;
import static spark.Spark.post;
import service.com.eka.CollectionOperationService;

public class CollectionResource {

	private static final String API_CONTEXT = "/platformAPI";

	private final CollectionOperationService collectionOperationService;

	public CollectionResource(CollectionOperationService collectionOperationService) {
		this.collectionOperationService = collectionOperationService;
		setupEndpoints();
	}

	private void setupEndpoints() {
		post(API_CONTEXT + "/createCollection", "application/json", (request,
				response) -> {
					collectionOperationService.createCollection(request.body());
			response.status(201);
			return response;
		}, new JsonTransformer());


		get(API_CONTEXT + "/getCollectionList", "application/json", (request, response)

		-> collectionOperationService.getCollectionList(), new JsonTransformer());
		
		post(API_CONTEXT + "/deleteCollection/:id", "application/json", (request,
				response) -> {
					collectionOperationService.removeCollection(request.params(":id"));
			response.status(204);
			return response;
		}, new JsonTransformer());
	}
}
