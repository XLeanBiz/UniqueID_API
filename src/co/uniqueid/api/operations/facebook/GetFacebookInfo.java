package co.uniqueid.api.operations.facebook;

import co.uniqueid.api.operations.URLUtilities;


public class GetFacebookInfo {

	// http://jsonpfy.unoidme.appspot.com/ListDataService
	// ?kind=FacebookInfo
	// &filterField=email&filterValue=alline.oliveira@gmail.com

	private static String getUniqueIDUrl = "http://jsonpfy.unoidme.appspot.com/ListDataService";

	public static String getByField(final String fieldName,
			final String fieldValue) {

		String parameters = "kind=FacebookInfo&filterField=" + fieldName
				+ "&filterValue=" + fieldValue;

		final String jsonString = URLUtilities.fetchURLPost(getUniqueIDUrl,
				parameters);

		return jsonString;
	}
}
