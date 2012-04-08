package co.uniqueid.api.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uniqueid.api.operations.GetUniqueID;
import co.uniqueid.api.utilities.CallbackUtilities;
import co.uniqueid.api.utilities.URLUtilities;

@SuppressWarnings("serial")
public class SearchUniqueIDServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		// response.getWriter().println(getData(request));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		response.getWriter().println(getData(request));
	}

	private String getData(HttpServletRequest request) {

		String fieldName = URLUtilities.decode(request
				.getParameter("fieldName"));

		String fieldValue = URLUtilities.decode(request
				.getParameter("fieldValue"));

		String entity = GetUniqueID.getByField(fieldName, fieldValue);

		String answer = CallbackUtilities.getCallback(
				request.getParameter("callback"), entity.toString());

		return answer;
	}
}
