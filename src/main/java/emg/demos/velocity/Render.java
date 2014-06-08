package emg.demos.velocity;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.app.event.implement.IncludeRelativePath;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class Render {
	private VelocityEngine vengine;
	private VelocityContext context;

	public void hello() {
		// 1 inicializar engine
		vengine = new VelocityEngine();
		vengine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		vengine.setProperty("classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());
		vengine.init();

		// 2 cargar el template
		String templateUrl = "emg/demos/velocity/templates/helloworld.vm";
		Template template = vengine.getTemplate(templateUrl);

		// 3 crear el contexto (para pasar valores al template)
		context = new VelocityContext();
		context.put("name", "Mundo!");

		// 4 render!!
		StringWriter swriter = new StringWriter();
		template.merge(context, swriter);

		// 5 preview
		System.out.println(swriter.toString());
	}

	public void petList() {
		vengine = new VelocityEngine();
		vengine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		vengine.setProperty("classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());
		vengine.setProperty(RuntimeConstants.EVENTHANDLER_INCLUDE,
				IncludeRelativePath.class.getName());
		vengine.init();
		String templateUrl = "emg/demos/velocity/templates/petoffer.vm";
		Template template = vengine.getTemplate(templateUrl);
		// petlist
		ArrayList<Map<String, String>> petList = new ArrayList<Map<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "gatos");
		map.put("price", "$50.00");
		petList.add(map);
		map = new HashMap<String, String>();
		map.put("name", "aves");
		map.put("price", "$20.00");
		petList.add(map);
		map = new HashMap<String, String>();
		map.put("name", "perros");
		map.put("price", "$45.00");
		petList.add(map);
		map = new HashMap<String, String>();
		map.put("name", "llamas");
		map.put("price", "$500.00");
		petList.add(map);
		// petlist
		context = new VelocityContext();
		context.put("petList", petList);
		StringWriter swriter = new StringWriter();
		template.merge(context, swriter);
		System.out.println(swriter.toString());
	}
}
