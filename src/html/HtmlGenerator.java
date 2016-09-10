package html;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * @author ivan1
 *
 */
public class HtmlGenerator {
	
	private String title;
	private String altText;
	private String photoMessege;
	private String photoFolder;
	private String content;
	private String footer;
	
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAltText() {
		return altText;
	}



	public void setAltText(String altText) {
		this.altText = altText;
	}



	public String getPhotoMessege() {
		return photoMessege;
	}



	public void setPhotoMessege(String photoMessege) {
		this.photoMessege = photoMessege;
	}



	public String getPhotoFolder() throws IOException {
		Path source = Paths.get(photoFolder);
		Path newdir = Paths.get("D:/java/FbRest/content");
		Files.copy(source, newdir.resolve(source.getFileName()));
		return photoFolder;
	}



	public void setPhotoFolder(String photoFolder) {
		this.photoFolder = photoFolder;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getFooter() {
		return footer;
	}



	public void setFooter(String footer) {
		this.footer = footer;
	}



	public void generate() {
		try {
			// Instantiate Configuration class
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
			cfg.setDirectoryForTemplateLoading(new File("D:/java/FbRest/content"));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

			// Create Data Model
			Map<String, Object> map = new HashMap<>();
			map.put("style", "D:/java/FbRest/upload_content/css/style.css");
			map.put("title", getTitle());
			map.put("altText",getAltText());
			map.put("message", getPhotoMessege());
			map.put("image", getPhotoFolder());
			map.put("content", getContent());
			map.put("footer", getFooter());

			// Instantiate template
			Template template = cfg.getTemplate("template.ftl");
			
			// File output
			Writer file = new FileWriter(new File("D:/Java/FbRest/content/post_"+title+".html"));
			template.process(map, file);
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}
