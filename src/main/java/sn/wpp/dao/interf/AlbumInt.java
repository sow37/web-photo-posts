package sn.wpp.dao.interf;

import java.util.List;

import sn.wpp.beans.Album;

public interface AlbumInt {
	
	public void add(Album album);
	public List<Album> getAll();
	public Album getAlbumById(int id);
	public void update(Album album);
	public void delete(Album album);

}
