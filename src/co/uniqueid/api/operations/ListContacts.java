package co.uniqueid.api.operations;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListContacts {

	// http://jsonpfy.unoidme.appspot.com/ListSubArrayService
	// ?kind=Entity
	// &ID=goLiveSource
	// &fieldSubArray=groupConnections

	// http://jsonpfy.unoidme.appspot.com/ListSubArrayService
	// ?kind=UniqueID
	// &ID=AllineWatkins_1332886062783
	// &fieldSubArray=Contact

	private static String getListContactsUrl = "http://jsonpfy.unoidme.appspot.com/ListSubArrayService";

	public static String list(final String uniqueID) {

		String parameters = "kind=UniqueID&ID=" + uniqueID
				+ "&fieldSubArray=Contacts";

		final String jsonString = URLUtilities.fetchURLPost(getListContactsUrl,
				parameters);

		String groupJsonString = getFoundedInfo(jsonString);

		return groupJsonString;

	}

	public static String getFoundedInfo(final String groupJsonString) {

		JSONArray jsonArray = new JSONArray();

		try {

			jsonArray = new JSONArray(groupJsonString);

			JSONArray contactsArray = new JSONArray();

			for (int i = 0; i < jsonArray.length(); i++) {

				JSONObject contact = (JSONObject) jsonArray.get(i);

				if (!contact.isNull("Founded")) {

					JSONArray foundeds = (JSONArray) contact.get("Founded");

					JSONArray foudedArray = new JSONArray();

					for (int j = 0; j < foundeds.length(); j++) {

						String foundedID = (String) foundeds.get(j);

						JSONObject founded = GetEntityByUniqueID
								.getBasicInfo(JSONUtilities
										.convertToEntityID(foundedID));

						foudedArray.put(founded);
					}

					contact.put("FoundedEntities", foudedArray);

				}

				contactsArray.put(contact);
			}

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return jsonArray.toString();
	}
}
