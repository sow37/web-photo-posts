package sn.wpp.dao.interf;

import javax.servlet.http.HttpServletRequest;

import sn.wpp.beans.Image;

public interface ImageInt {
	
	public Image findById(Long id);
	public void add(Image image);
	public void delete(Image image, String uplodaDirectory);
	public void deleteById(Long id, HttpServletRequest request);
	public void update(Image image);
	public void removeImageFile(String path, Image img);

}
