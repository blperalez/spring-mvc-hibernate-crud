package com.mvcproject.web.dao;

import java.util.List;

import com.mvcproject.web.entity.Album;

public interface AlbumDAO {

	public List<Album> getAlbums();

	public void saveAlbum(Album theAlbum);

	public Album getAlbums(int theId);

	public void deleteAlbum(int theId);

}
