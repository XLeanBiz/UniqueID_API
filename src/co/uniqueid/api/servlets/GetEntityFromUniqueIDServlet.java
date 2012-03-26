package co.uniqueid.api.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uniqueid.api.operations.GetEntityByUniqueID;
import co.uniqueid.api.operations.URLUtilities;

@SuppressWarnings("serial")
public class GetEntityFromUniqueIDServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		response.getWriter().println(getData(request));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		response.getWriter().println(getData(request));
	}

	private String getData(HttpServletRequest request) {

		String uniqueID = URLUtilities.decode(request.getParameter("UniqueID"));

		String entity = GetEntityByUniqueID.get(uniqueID);

		String answer = CallbackUtilities.getCallback(
				request.getParameter("callback"), entity.toString());

		return answer;
	}
}
