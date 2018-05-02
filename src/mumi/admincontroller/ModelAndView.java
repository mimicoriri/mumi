package mumi.admincontroller;

public class ModelAndView {

	private String path;
	private boolean isRedirect; //true면 redirect, false이면 forward방식(default)

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

}
