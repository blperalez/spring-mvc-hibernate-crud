package com.mvcproject.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvcproject.web.dao.AlbumDAO;
import com.mvcproject.web.entity.Album;
import com.mvcproject.web.service.AlbumService;

@Controller
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private AlbumDAO albumDao;
	
	@GetMapping("/list")
	public String albumList(Model theModel) {
		/*
		// get customer from service
		List<Album> albums = albumService.getAlbums();
		
		// add album to the model
		theModel.addAttribute("albums", albums);
		*/
		
		// get customer from service
		List<Album> albums = albumDao.getAlbums();
				
		// add album to the model
		theModel.addAttribute("albums", albums);
		
		// jsp page name
		return "album-list";
	}
	
	@GetMapping("/addForm")
	public String addAlbum(Model theModel) {
		
		Album album = new Album();
		
		theModel.addAttribute("album", album);
		
		return "album-form";
	}
	
	@PostMapping("/saveAlbum")
	public String saveAlbum(@ModelAttribute("album") Album theAlbum) {
		
		albumService.saveAlbum(theAlbum);
		
		return "redirect:/album/list";
		
	}
	
	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("albumId") int theId, Model theModel) {
		
		// create an album object
		Album theAlbum = albumService.getAlbums(theId);
		
		// post object to model
		theModel.addAttribute("album", theAlbum);
		
		// return form name		
		return "album-form";
	}
	
	@GetMapping("/delete")
	public String deleteAlbum(@RequestParam("albumId") int theId) {
		
		// delete the album
		albumService.deleteAlbum(theId);
		
		return "redirect:/album/list";
	}

}
