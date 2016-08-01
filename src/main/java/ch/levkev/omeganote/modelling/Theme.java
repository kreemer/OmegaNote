package ch.levkev.omeganote.modelling;

import java.io.File;

import ch.levkev.omeganote.modelling.interfaces.ITheme;

public class Theme implements ITheme {

	public static final String THEME_CSS_FILENAME = "theme.css";
	
	public static final String THEME_OUTPUT_FILENAME = "output.css";
	
	public static final String THEME_IMAGES_FILENAME = "images";
	
	private File baseDir;
	
	public Theme(File file) throws ThemeException {
		assert(file.isDirectory());
		this.baseDir = file;
		if (!this.getThemeStylesheet().exists()) {
			throw new ThemeException();
		}
		
		if (!this.getOutputStylesheet().exists()) {
			throw new ThemeException();
		}
		
		if (!this.getImagesFolder().exists()) {
			throw new ThemeException();
		}
	}
	
	@Override
	public File getThemeStylesheet() {
		return this.baseDir.toPath().resolve(THEME_CSS_FILENAME).toFile();
	}

	@Override
	public File getOutputStylesheet() {
		return this.baseDir.toPath().resolve(THEME_OUTPUT_FILENAME).toFile();
	}

	@Override
	public File getImagesFolder() {
		return this.baseDir.toPath().resolve(THEME_IMAGES_FILENAME).toFile();
	}

	@Override
	public String getName() {
		return this.baseDir.getName();
	}

}
