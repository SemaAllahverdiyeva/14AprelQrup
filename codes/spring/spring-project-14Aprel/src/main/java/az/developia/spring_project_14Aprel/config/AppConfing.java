package az.developia.spring_project_14Aprel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfing {
	@Value(value = "${app.name}")
	private String name;

	@Value(value = "${app.version}")
	private String version;

	public void showProperties() {
		System.out.println(name);
		System.out.println(version);
	}
}