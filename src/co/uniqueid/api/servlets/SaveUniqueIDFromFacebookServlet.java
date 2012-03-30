package co.uniqueid.api.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uniqueid.api.operations.URLUtilities;
import co.uniqueid.api.operations.facebook.GetUniqueIDFromFacebook;

@SuppressWarnings("serial")
public class SaveUniqueIDFromFacebookServlet extends HttpServlet {
	
	// http://localhost:8888/SaveUniqueIDFromFacebookService
	// ?facebookID=alline.oliveira

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		response.getWriter().println(getData(request));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		response.getWriter().println(getData(request));
	}

	private String getData(HttpServletRequest request) {

		String facebookID = URLUtilities.decode(request
				.getParameter("facebookID"));

		GetUniqueIDFromFacebook.save(facebookID);

		String answer = CallbackUtilities.getCallback(
				request.getParameter("callback"), "OK");

		return answer;
	}

}
