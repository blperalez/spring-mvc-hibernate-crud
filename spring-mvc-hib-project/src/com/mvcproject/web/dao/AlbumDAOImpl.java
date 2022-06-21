package com.mvcproject.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mvcproject.web.entity.Album;

@Repository
public class AlbumDAOImpl implements AlbumDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Album> getAlbums() {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query
		Query<Album> theQuery = currentSession.createQuery("from Album", Album.class);
		
		// execute query
		List<Album> theAlbums = theQuery.getResultList();
		
		// return results
		return theAlbums;
	}

	@Override
	@Transactional
	public void saveAlbum(Album theAlbum) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save theAlbum to DB
		currentSession.saveOrUpdate(theAlbum);
		
	}

	@Override
	@Transactional
	public Album getAlbums(int theId) {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get the album based off the id
		Album theAlbum = currentSession.get(Album.class, theId);
		
		// return the object		
		return theAlbum;
	}

	@Override
	@Transactional
	public void deleteAlbum(int theId) {
		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query
		Query theQuery = currentSession.createQuery("delete from Album where id=:albumId");
		
		// set the id:=albumId parameter
		theQuery.setParameter("albumId", theId);
		
		// execute query
		theQuery.executeUpdate();
		
		
	}
}
