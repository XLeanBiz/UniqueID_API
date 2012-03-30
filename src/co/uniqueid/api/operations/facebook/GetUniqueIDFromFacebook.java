package co.uniqueid.api.operations.facebook;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import co.uniqueid.api.operations.GetUniqueID;
import co.uniqueid.api.operations.JSONUtilities;
import co.uniqueid.api.operations.URLUtilities;

public class GetUniqueIDFromFacebook {

	private static String graphFacebookUrl = "https://graph.facebook.com/";

	public static void save(final String facebookID) {

		JSONObject facebookUser = getFacebookUser(facebookID);

		saveUniqueID(facebookUser);
	}

	private static JSONObject getFacebookUser(final String facebookID) {

		JSONObject json = new JSONObject();

		final String jsonString = URLUtilities.fetchURLGet(graphFacebookUrl
				+ facebookID, null);

		try {
			json = new JSONObject(jsonString);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return json;
	}

	private static String saveUniqueID(JSONObject facebookMe) {

		String facebookLogin = JSONUtilities.getString(facebookMe, "username");
		if (facebookLogin == null) {
			facebookLogin = JSONUtilities.getString(facebookMe, "id");
		}

		JSONObject unoUserJson = JSONUtilities.getUserJson(GetUniqueID
				.getByField("facebookLogin", facebookLogin));

		if (unoUserJson == null) {

			String email = JSONUtilities.getString(facebookMe, "email");

			unoUserJson = JSONUtilities.getUserJson(GetUniqueID.getByField(
					"email", email));
			if (unoUserJson != null
					&& JSONUtilities.getString(unoUserJson, "facebookLogin") == null) {
				try {
					unoUserJson.put("facebookLogin", facebookLogin);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}

		if (unoUserJson == null) {

			String name = JSONUtilities.getString(facebookMe, "first_name");

			if (name == null) {

				name = JSONUtilities.getString(facebookMe, "name");
			} else {

				name += JSONUtilities.getString(facebookMe, "last_name");
			}

			String unoUserID = URLUtilities.compactName(name) + "_" + (new Date()).getTime();

			unoUserJson = createUniqueID(unoUserID, facebookLogin);
		}

		SaveUniqueIDFromFacebook.save(unoUserJson, facebookMe);

		return unoUserJson.toString();
	}

	private static JSONObject createUniqueID(final String unoUserID,
			final String facebookLogin) {

		JSONObject jsonObject = new JSONObject();

		try {

			jsonObject.put("ID", unoUserID);
			jsonObject.put("facebookLogin", facebookLogin);
			// jsonObject.put("email", email);

		} catch (JSONException e) {
			// e.printStackTrace();
		}

		return jsonObject;
	}
}
