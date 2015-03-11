package web.com.eka.src.java;

import static spark.Spark.post;
import service.com.eka.DataViewOperationService;

public class DataViewResource {

	private static final String API_CONTEXT = "/platformAPI";

	private final DataViewOperationService dataViewOperationService;

	public DataViewResource(DataViewOperationService dataViewOperationService) {
		this.dataViewOperationService = dataViewOperationService;
		setupEndpoints();
	}

	private void setupEndpoints() {
		post(API_CONTEXT + "/createDataView", "application/json", (request,
				response) -> {
					dataViewOperationService.createDataView(request.body());
			response.status(201);
			return response;
		}, new JsonTransformer());

		
		post(API_CONTEXT + "/deleteDataView/:id", "application/json", (request,
				response) -> {
					dataViewOperationService.deleteDataView(request.params(":id"));
			response.status(204);
			return response;
		}, new JsonTransformer());
	}
}
