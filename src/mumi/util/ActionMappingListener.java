package mumi.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import mumi.admincontroller.Action;


/**
 * Application Lifecycle Listener implementation class ActionMappingListener
 *
 */
@WebListener
public class ActionMappingListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent e) {
	}

	public void contextInitialized(ServletContextEvent e) {
		// 객체들의 정보는 ~.properties파일에 있기 때문에 properties 먼저 읽어온다.(ResourceBundle객체 이용)
		Map<String, Action> map = new HashMap<>();

		ServletContext application = e.getServletContext();
		String fileName = application.getInitParameter("fileName");

		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		Iterator<String> it = rb.keySet().iterator();

		while (it.hasNext()) {
			String key = it.next();
			String className = rb.getString(key);
			try {
				Action action = (Action) Class.forName(className).newInstance();
				map.put(key, action);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// 미리 객체 생성해서 map저장 -> application저장 (사전초기화작업)
		application.setAttribute("map", map);

	}

}
