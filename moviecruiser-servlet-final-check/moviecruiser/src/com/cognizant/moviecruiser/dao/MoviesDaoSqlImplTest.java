package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImplTest {
	
	public static void testGetMoviesListAdmin() {
		List<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListAdmin();
		System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", "ID", "TITLE", "GROSS", "ACTIVE", "DATE OF LAUNCH",
				"GENRE", "HAS TEASER");
		System.out.println();
		String active;
		String teaser;
		for (Movies movies : moviesList) {
			if (movies.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies.getTeaser() == true) {
				teaser = "Yes";
			} else {
				teaser = "No";
			}
			System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", movies.getId(), movies.getTitle(),
					movies.getGross(), active, movies.getDateOfLaunch(), movies.getGenre(), teaser);
			System.out.println();
		}
	}
	
	public static void testGetMoviesListCustomer() {
		List<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListCustomer();
		System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", "ID", "TITLE", "GROSS", "ACTIVE", "DATE OF LAUNCH",
				"GENRE", "HAS TEASER");
		System.out.println();
		String active;
		String teaser;
		for (Movies movies : moviesList) {
			if (movies.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies.getTeaser() == true) {
				teaser = "Yes";
			} else {
				teaser = "No";
			}
			System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", movies.getId(), movies.getTitle(),
					movies.getGross(), active, movies.getDateOfLaunch(), movies.getGenre(), teaser);
			System.out.println();
		}
	}
	
	public static void testModifyMovies() {		 
		Movies movies = new Movies(5L, "Conjuring", 4512536401L, false, new DateUtil().convertToDate("02/11/2022"),
				"Horror", true);
		new MoviesDaoSqlImpl().modifyMovies(movies);
		List<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListAdmin();
		System.out.println("After Modification");
		System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", "ID", "TITLE", "GROSS", "ACTIVE", "DATE OF LAUNCH",
				"GENRE", "HAS TEASER");
		System.out.println();
		String active;
		String teaser;
		for (Movies movies1 : moviesList) {
			if (movies1.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies1.getTeaser() == true) {
				teaser = "Yes";
			} else {
				teaser = "No";
			}
			System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", movies1.getId(), movies1.getTitle(),
					movies1.getGross(), active, movies1.getDateOfLaunch(), movies1.getGenre(), teaser);
			System.out.println();
		}
	}
	
	public static void testGetMovies() {
		Movies movies = new MoviesDaoSqlImpl().getMovies(2);		 
		System.out.println("User");
		System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", "ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH",
				"CATEGORY", "FREE DELIVERY");
		System.out.println();
		String active;
		String teaser;
		
			if (movies.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies.getTeaser() == true) {
				teaser = "Yes";
			} else {
				teaser = "No";
			}
			System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", movies.getId(), movies.getTitle(),
					movies.getGross(), active, movies.getDateOfLaunch(), movies.getGenre(), teaser);
			System.out.println();
		}

	public static void main(String[] args) {
		testGetMoviesListAdmin();
		testGetMoviesListCustomer();
		testModifyMovies();
		testGetMovies();
	}

}
