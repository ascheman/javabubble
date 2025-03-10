package org.javabubble.generator;

import java.io.IOException;
import java.nio.file.Path;

import org.javabubble.generator.model.ModelLoader;
import org.javabubble.generator.model.ModelValidator;
import org.javabubble.generator.site.FileOutput;
import org.javabubble.generator.site.Site;

public class Main {

	public static void main(String[] args) throws IOException {
		var bubble = new ModelLoader(Path.of("../javapeople.yaml")).load();
		// TODO add some nice CLI handling, e.g., with picocli
		boolean validateOnPlatforms = args.length > 0 && args[0].equals("--validate-on-platforms");
		ModelValidator.validate(bubble, validateOnPlatforms);
		var output = new FileOutput(Path.of("target/site"));
		new Site(bubble, output).generate();
	}
}
