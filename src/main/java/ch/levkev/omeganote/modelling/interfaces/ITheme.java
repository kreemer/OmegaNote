package ch.levkev.omeganote.modelling.interfaces;

import java.io.File;

/**
 * interface for theme class
 * 
 * @author kreemer
 */
public interface ITheme {
	/**
	 * get the theme css as file object
	 * @return
	 */
	public File getThemeStylesheet();
	
	/**
	 * get the output stylesheet for the markdown output
	 * @return
	 */
	public File getOutputStylesheet();
	
	/**
	 * get the folder of the images
	 * @return
	 */
	public File getImagesFolder();
	
	/**
	 * get the name of the theme
	 * @return
	 */
	public String getName();
}
