package mumi.admincontroller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FrontController
 */
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		Map<String, Action> map;
		
	@Override
	public void init(ServletConfig config) throws ServletException {
		// aplication영역에 저장된Map을 꺼내서 전역변수에 저장한다.
		map = (Map<String, Action>) config.getServletContext().getAttribute("map");

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// parameter 넘어오는 command 받기 = key
		String key = request.getParameter("command");
		if (key == null) {
			key = "list";
		}
		
		//map에서 key에 해당하는 클래스를 꺼내서 메소드를 호출하고 리턴값을 받는다.
		ModelAndView mv = map.get(key).execute(request, response);
		//리턴값(ModelAndView)에 따라 이동방식과 이동경로를 정한다.
		if(mv.isRedirect()) {
			response.sendRedirect(mv.getPath());
		}else {
			request.getRequestDispatcher(mv.getPath()).forward(request,response);
		}
	}

}
