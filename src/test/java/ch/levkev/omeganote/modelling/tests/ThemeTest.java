package ch.levkev.omeganote.modelling.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import ch.levkev.omeganote.modelling.Notebook;
import ch.levkev.omeganote.modelling.Theme;
import ch.levkev.omeganote.modelling.ThemeException;

public class ThemeTest {
	
	private Theme theme;

	@Rule
	public TemporaryFolder tmp = new TemporaryFolder();
	
	
	@Before
	public void setUp() throws IOException {
		tmp.newFolder(Theme.THEME_IMAGES_FILENAME);
		tmp.newFile(Theme.THEME_CSS_FILENAME);
		tmp.newFile(Theme.THEME_OUTPUT_FILENAME);
		this.theme = new Theme(tmp.getRoot());
	}
	
	@Test
	public void canGetFileCssObject() {
		assertEquals(tmp.getRoot().getPath() + "/" + Theme.THEME_CSS_FILENAME, this.theme.getThemeStylesheet().getPath());
	}
	
	@Test
	public void canGetOutputCssObject() {
		assertEquals(tmp.getRoot().getPath() + "/" + Theme.THEME_OUTPUT_FILENAME, this.theme.getOutputStylesheet().getPath());
	}
	
	@Test
	public void canGetImagesFileObject() {
		assertEquals(tmp.getRoot().getPath() + "/" + Theme.THEME_IMAGES_FILENAME, this.theme.getImagesFolder().getPath());
	}
	
	@Test
	public void getNameWillReturnFolderName() {
		assertEquals(tmp.getRoot().getName(), this.theme.getName());
	}
	
	@Test(expected=ThemeException.class)
	public void themeWithNoCssFileWillResultInException() {
		this.tmp.getRoot().toPath().resolve(Theme.THEME_CSS_FILENAME).toFile().delete();
		this.theme = new Theme(tmp.getRoot());
	}
	
	@Test(expected=ThemeException.class)
	public void themeWithNoOutputFileWillResultInException() {
		this.tmp.getRoot().toPath().resolve(Theme.THEME_OUTPUT_FILENAME).toFile().delete();
		this.theme = new Theme(tmp.getRoot());
	}
	
	@Test(expected=ThemeException.class)
	public void themeWithNoImageFolderWillResultInException() {
		this.tmp.getRoot().toPath().resolve(Theme.THEME_IMAGES_FILENAME).toFile().delete();
		this.theme = new Theme(tmp.getRoot());
	}
}
