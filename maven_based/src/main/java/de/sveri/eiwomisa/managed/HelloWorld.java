package de.sveri.eiwomisa.managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class HelloWorld {

	// private String testString;

	public String getTestString() {
		return "testString";
	}

	// public void setTestString(String testString) {
	// this.testString = testString;
	// }
}
