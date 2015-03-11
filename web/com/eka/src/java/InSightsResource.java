package web.com.eka.src.java;

import static spark.Spark.post;
import service.com.eka.InSightsOperationService;

public class InSightsResource {

	private static final String API_CONTEXT = "/platformAPI";

	private final InSightsOperationService inSightsOperationService;

	public InSightsResource(InSightsOperationService inSightsOperationService) {
		this.inSightsOperationService = inSightsOperationService;
		setupEndpoints();
	}

	private void setupEndpoints() {
		post(API_CONTEXT + "/createCollection", "application/json", (request,
				response) -> {
					inSightsOperationService.createInSights(request.body());
			response.status(201);
			return response;
		}, new JsonTransformer());

		
		post(API_CONTEXT + "/deleteCollection/:id", "application/json", (request,
				response) -> {
					inSightsOperationService.deleteInSights(request.params(":id"));
			response.status(204);
			return response;
		}, new JsonTransformer());
	}
}
