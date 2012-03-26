package co.uniqueid.api.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import co.uniqueid.api.operations.SaveUniqueID;
import co.uniqueid.api.operations.URLUtilities;

@SuppressWarnings("serial")
public class SaveUniqueIDServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		// response.getWriter().println(getData(request));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		response.getWriter().println(getData(request));
	}

	private String getData(HttpServletRequest request) {

		JSONObject entityJson = new JSONObject();

		String uniqueID = URLUtilities.decode(request.getParameter("UniqueID"));
		try {
			entityJson.put("ID", uniqueID);
		} catch (JSONException e) {
			// e.printStackTrace();
		}

		addValue(request, entityJson, "entityName");
		addValue(request, entityJson, "image");
		addValue(request, entityJson, "email");
		addValue(request, entityJson, "facebookLogin");
		addValue(request, entityJson, "twitterID");
		addValue(request, entityJson, "linkedinID");
		addValue(request, entityJson, "aboutmeURL");
		addValue(request, entityJson, "blogURL");
		addValue(request, entityJson, "githubLogin");
		addValue(request, entityJson, "googleAccount");

		String entity = SaveUniqueID.save(entityJson);

		String answer = CallbackUtilities.getCallback(
				request.getParameter("callback"), entity.toString());

		return answer;
	}

	private static void addValue(HttpServletRequest request,
			JSONObject entityJson, final String fieldName) {

		String value = URLUtilities.decode(request.getParameter(fieldName));

		try {
			entityJson.put(fieldName, value);
		} catch (JSONException e) {
			// e.printStackTrace();
		}
	}

}
