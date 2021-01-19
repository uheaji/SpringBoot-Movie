package com.cos.movie.domain;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
	
	List<Movie> movies = new ArrayList<>();
	
	public List<Movie> findAll() {
		movies.add(new Movie(1, "title1", 4.5, Timestamp.valueOf("2010-12-25 00:00:00")));
		movies.add(new Movie(2, "title2", 5, Timestamp.valueOf("2020-10-18 00:00:00")));
		movies.add(new Movie(3, "title3", 3.8, Timestamp.valueOf("2010-12-25 00:00:00")));
		movies.add(new Movie(4, "title4", 4.3, Timestamp.valueOf("2021-01-18 00:00:00")));
		movies.add(new Movie(5, "title5", 4.9, Timestamp.valueOf("2010-12-25 00:00:00")));
		movies.add(new Movie(6, "title6", 4.1, Timestamp.valueOf("2020-09-18 00:00:00")));
		movies.add(new Movie(7, "title7", 3.5, Timestamp.valueOf("2020-09-18 00:00:00")));
		movies.add(new Movie(8, "title8", 2.5, Timestamp.valueOf("2021-01-18 00:00:00")));
		return movies;
	}
	
	public Movie findById(int id) {
		for (Movie movie : movies) {
			if (id == movie.getId()) {
				return movie;
			}
		}
		return null;
	}
	
	public void save(SaveReqDto dto) throws Exception {
		System.out.println("영화등록 완료");
	}
	
	public void delete(int id) {
		System.out.println("영화삭제 완료");
	}
	
	public void update(int id, UpdateReqDto dto) {
		System.out.println("영화수정 완료");
	}
}
