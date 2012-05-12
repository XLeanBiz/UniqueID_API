package co.uniqueid.api.operations;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import co.uniqueid.api.utilities.EncryptText;
import co.uniqueid.api.utilities.JSONUtilities;
import co.uniqueid.api.utilities.URLUtilities;

public class SaveUniqueID {

	private static String saveUnoUserUrl = "https://jsonpfy.unoidme.appspot.com/SaveDataService";

	public static String save(JSONObject unoUserJson, String override) {

		String parameters = "kind=UniqueID";

		parameters += "&ID=" + getID(unoUserJson);

		parameters += "&override=" + override;

		parameters += URLUtilities.addSaveParameter(unoUserJson, "entityName");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "image");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "email");

		parameters += URLUtilities.addSaveParameter(unoUserJson,
				"facebookLogin");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "twitterID");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "linkedinID");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "aboutmeURL");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "blogURL");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "githubLogin");

		parameters += URLUtilities.addSaveParameter(unoUserJson,
				"googleAccount");

		URLUtilities.fetchURLPost(saveUnoUserUrl,
				parameters + EncryptText.getAuthParameter());

		return unoUserJson.toString();
	}

	private static String getID(JSONObject unoUserJson) {

		String uniqueID = JSONUtilities.getString(unoUserJson, "ID");

		if (uniqueID == null) {

			uniqueID = URLUtilities.compactName(JSONUtilities.getString(
					unoUserJson, "entityName")) + "_" + (new Date().getTime());

			try {
				unoUserJson.put("ID", uniqueID);

			} catch (JSONException e) {

				e.printStackTrace();
			}
		}

		return uniqueID;
	}
}
