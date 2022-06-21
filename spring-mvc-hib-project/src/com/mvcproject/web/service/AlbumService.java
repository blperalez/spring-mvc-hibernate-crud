package com.mvcproject.web.service;

import java.util.List;

import com.mvcproject.web.entity.Album;

public interface AlbumService {

	public List<Album> getAlbums();

	public void saveAlbum(Album theAlbum);

	public Album getAlbums(int theId);

	public void deleteAlbum(int theId);
}
