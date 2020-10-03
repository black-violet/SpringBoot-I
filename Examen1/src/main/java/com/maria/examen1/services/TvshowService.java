package com.maria.examen1.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maria.examen1.models.Tvshow;
import com.maria.examen1.repositories.TvshowRepository;

@Service
public class TvshowService {
	
	private TvshowRepository tvshowRepository;

	public TvshowService(TvshowRepository tvshowRepository) {
		this.tvshowRepository = tvshowRepository;
	}
	
	public Tvshow create(Tvshow tvshow) {
		
		return tvshowRepository.save(tvshow);
	}
	
	public Tvshow findTvShow(Long id) {
		Optional<Tvshow> optionalshow = tvshowRepository.findById(id);
		if(optionalshow.isPresent()) {
			return optionalshow.get();
		}else {
		return null;
		}
	}

	//  este para buscar el id
	public Tvshow findById(Long id) {
		Optional<Tvshow> optionalEvent = tvshowRepository.findById(id);
		if (optionalEvent.isPresent()) {
			return optionalEvent.get();
		} else {
			return null;
		}
	}

	public Tvshow updateTvShow(Long id, Tvshow tvshow, String title, String network) {
		Optional<Tvshow> optionalshow = tvshowRepository.findById(id);
		if(optionalshow.isPresent()) {
			Tvshow up = optionalshow.get();
			up.setTitle(title);
			up.setNetwork(network);
			return tvshowRepository.save(up);
		}else {
		return null;
		}
	}

	/*public List<Object[]> listAllShows() {
		List<Object[]> show = tvshowRepository.findAllShow();
		Object[] tv = show.get(0);
		Object showId = tv[0];
		Object showName = tv[1];
		System.out.println(((Tvshow) showId).getTitle());
	    System.out.println(((Tvshow) showName).getId());
		
	return show;
		
	}*/
}
