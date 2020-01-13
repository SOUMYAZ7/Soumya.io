package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImplTest {
	
	public static void testAddFavoriteMovies() {
		new FavoritesDaoSqlImpl().addFavoriteMovies(1, 2);
	}
	
	public static void testGetAllFavoriteMovies() throws FavoritesEmptyException {
		Favorites favorites = new FavoritesDaoSqlImpl().getAllFavoriteMovies(1);
		List<Movies> MoviesList = favorites.getMoviesList();
		System.out.println("Favorites");
		System.out.format("%-20s%-20s%-20s%-20s","ID", "TITLE", "GROSS", "GENRE");
		System.out.println();
		for(Movies movies : MoviesList) {
		 System.out.format("%-20s%-20s%-20s%-20s\n",movies.getId(), movies.getTitle(), movies.getGross(), movies.getGenre());
		 System.out.println();
		}		
		System.out.format("%-40s","No. of Favorites    "+favorites.getTotal());
	}
	
	public static void testRemoveFavoriteMovies() throws FavoritesEmptyException {
		new FavoritesDaoSqlImpl().removeFavoriteMovies(1, 4);
		testGetAllFavoriteMovies();
	}
	
	public static void main(String[] args) throws FavoritesEmptyException {
		testAddFavoriteMovies();
		//testGetAllFavoriteMovies();
		//testRemoveFavoriteMovies();
	}

}
