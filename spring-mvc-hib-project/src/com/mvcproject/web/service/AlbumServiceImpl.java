package com.mvcproject.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvcproject.web.dao.AlbumDAO;
import com.mvcproject.web.entity.Album;

@Service
public class AlbumServiceImpl implements AlbumService {
	
	@Autowired
	private AlbumDAO albumDao;
	
	@Override
	//@Transactional
	public List<Album> getAlbums() {
		return albumDao.getAlbums();
	}

	@Override
	public void saveAlbum(Album theAlbum) {
		albumDao.saveAlbum(theAlbum);
	}

	@Override
	public Album getAlbums(int theId) {
		
		return albumDao.getAlbums(theId);
	}

	@Override
	public void deleteAlbum(int theId) {
		albumDao.deleteAlbum(theId);
	}

}
