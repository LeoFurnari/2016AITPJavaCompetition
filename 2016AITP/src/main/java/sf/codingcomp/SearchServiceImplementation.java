/*edit this file*/
package sf.codingcomp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import sf.codingcomp.exception.TitleNotAvailableException;
import sf.codingcomp.model.Entertainment;
import sf.codingcomp.model.Game;
import sf.codingcomp.model.GamePlatform;
import sf.codingcomp.model.Movie;
import sf.codingcomp.model.Platform;
import sf.codingcomp.reader.Reader;

public class SearchServiceImplementation implements SearchService {

	/**
	 * 
	 * @param searchValue
	 *            a part of the title of a movie
	 * @return a list of movies that contains the given searchValue in its
	 *         title, null otherwise
	 */
	@Override
	public List<Movie> searchMovie(String searchValue) {

		Reader reader = new Reader();
		List<Movie> movies = reader.readMovies();
		List<Movie> foundMovies = new ArrayList<Movie>();
		for (Movie m : movies) {
			if (m.getTitle().toLowerCase().contains(searchValue.toLowerCase())) {
				foundMovies.add(m);
			}
		}
		try {
			if (foundMovies.isEmpty()) {
				throw new TitleNotAvailableException();
			}
		} catch (TitleNotAvailableException e) {
			// May need to be changed after
			System.err.println("No movie found with that title");
			return null;
		}

		return foundMovies;
	}

	/**
	 * 
	 * @param searchValue
	 *            part of the title of the game being searched for
	 * @return list of games containing search value if any found, null
	 *         otherwise
	 */
	@Override
	public List<Game> searchGame(String searchValue) {

		Reader reader = new Reader();
		List<Game> games = reader.readGames();
		List<Game> foundGames = new ArrayList<Game>();
		for (Game g : games) {
			if (g.getTitle().toLowerCase().contains(searchValue.toLowerCase())) {
				foundGames.add(g);
			}
		}
		try {
			if (foundGames.isEmpty()) {
				throw new TitleNotAvailableException();
			}
		} catch (TitleNotAvailableException e) {
			// May need to be changed after
			System.err.println("No game found with that title");
			return null;
		}

		return foundGames;
	}

	@Override
	public List<Entertainment> searchGameAndMovies(String searchValue) {
		Reader reader = new Reader();
		List<Game> games = reader.readGames();
		List<Movie> movies = reader.readMovies();
		List<Entertainment> gamesAndMovies = new ArrayList<Entertainment>();
		gamesAndMovies.addAll(games);
		gamesAndMovies.addAll(movies);
		List<Entertainment> foundGamesAndMovies = new ArrayList<Entertainment>();
		for (Entertainment e : gamesAndMovies) {
			if (e.getTitle().toLowerCase().contains(searchValue.toLowerCase())) {
				foundGamesAndMovies.add(e);
			}
		}
		try {
			if (foundGamesAndMovies.isEmpty()) {
				throw new TitleNotAvailableException();
			}
		} catch (TitleNotAvailableException e) {
			// May need to be changed after
			System.err.println("No game or movie found with that title");
			return null;
		}
		return foundGamesAndMovies;
	}

	//////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	// Fix this
	//////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	@Override
	public List<Movie> sortMoviesByDate(String searchValue, Double userRating) {
		Reader reader = new Reader();
		List<Movie> movies = reader.readMovies();
		List<Movie> foundMovies = new ArrayList<Movie>();
		for (Movie m : movies) {
			if (m.getTitle().toLowerCase().contains(searchValue.toLowerCase())) {
				if (Double.parseDouble(m.getUserRating()) >= userRating) {
					foundMovies.add(m);
				}

			}
		}
		try {
			if (foundMovies.isEmpty()) {
				throw new TitleNotAvailableException();
			}
		} catch (TitleNotAvailableException e) {
			// May need to be changed after
			System.err.println("No movie found with that title and rating");
			return null;
		}
		foundMovies.sort(new Comparator<Movie>() {
			@Override
			public int compare(Movie m1, Movie m2) {
				return m1.getReleased().compareTo(m2.getReleased());
			}

		});
		return foundMovies;
	}

	@Override
	public List<Game> sortGamesByDate(String searchValue, Double userRating) {
		Reader reader = new Reader();
		List<Game> games = reader.readGames();
		List<Game> foundGames = new ArrayList<Game>();
		for (Game g : games) {
			if (g.getTitle().toLowerCase().contains(searchValue.toLowerCase())) {
				if (Double.parseDouble(g.getUserRating()) >= userRating) {
					foundGames.add(g);
				}
			}
		}
		try {
			if (foundGames.isEmpty()) {
				throw new TitleNotAvailableException();
			}
		} catch (TitleNotAvailableException e) {
			// May need to be changed after
			System.err.println("No game found with that title and rating");
			return null;
		}
		foundGames.sort(new Comparator<Entertainment>() {
			@Override
			public int compare(Entertainment g1, Entertainment g2) {
				String d1Released = g1.getReleased();
				String d2Released = g2.getReleased();
				String[] d1 = d1Released.split(" ");
				String[] d2 = d2Released.split(" ");
				if (d2[2].compareTo(d1[2]) == 0) {
					if (d2[1].compareTo(d1[1]) == 0) {
						return d2[0].compareTo(d1[0]);
					}
					return d2[1].compareTo(d1[1]);
				}
				return d2[2].compareTo(d1[2]);
			}
		});
		return foundGames;
	}

	@Override
	public List<Entertainment> sortGamesAndMoviesByDate(String searchValue, Double userRating) {
		Reader reader = new Reader();
		List<Movie> movies = reader.readMovies();
		List<Game> games = reader.readGames();
		List<Entertainment> entertainments = new ArrayList<Entertainment>();
		entertainments.addAll(movies);
		entertainments.addAll(games);
		List<Entertainment> foundEntertainment = new ArrayList<Entertainment>();
		for (Entertainment e : entertainments) {
			if (e.getTitle().toLowerCase().contains(searchValue.toLowerCase())) {
				if (Double.parseDouble(e.getUserRating()) >= userRating) {
					foundEntertainment.add(e);
				}
			}
		}
		try {
			if (foundEntertainment.isEmpty()) {
				throw new TitleNotAvailableException();
			}
		} catch (TitleNotAvailableException e) {
			// May need to be changed after
			System.err.println("No movie found with that title and rating");
			return null;
		}
		foundEntertainment.sort(new Comparator<Entertainment>() {
			@Override
			public int compare(Entertainment g1, Entertainment g2) {
				String d1Released = g1.getReleased();
				String d2Released = g2.getReleased();
				String[] d1 = d1Released.split(" ");
				String[] d2 = d2Released.split(" ");
				if (d2[2].compareTo(d1[2]) == 0) {
					if (d2[1].compareTo(d1[1]) == 0) {
						return d2[0].compareTo(d1[0]);
					}
					return d2[1].compareTo(d1[1]);
				}
				return d2[2].compareTo(d1[2]);
			}
		});
		return foundEntertainment;
	}

	@Override
	public List<Movie> moviesByGenreAndRating(String Genre, String Rating) {
		Reader reader = new Reader();
		List<Movie> movies = reader.readMovies();
		List<Movie> foundMovies = new ArrayList<Movie>();
		for (Movie m : movies) {
			if (m.getRated().toLowerCase().contains(Rating.toLowerCase())) {
				if (m.getGenre().toLowerCase().contains(Genre.toLowerCase())) {
					foundMovies.add(m);
				}

			}
		}
		try {
			if (foundMovies.isEmpty()) {
				throw new TitleNotAvailableException();
			}
		} catch (TitleNotAvailableException e) {
			// May need to be changed after
			System.err.println("No movie found with that title and rating");
			return null;
		}
		return foundMovies;
	}

	@Override
	public List<Game> gamesByGenreAndRating(String Genre, String Rating) {
		Reader reader = new Reader();
		List<Game> games = reader.readGames();
		List<Game> foundGames = new ArrayList<Game>();
		for (Game g : games) {
			if (g.getRated().toLowerCase().contains(Rating.toLowerCase())) {
				if (g.getGenre().toLowerCase().contains(Genre.toLowerCase())) {
					foundGames.add(g);
				}

			}
		}
		try {
			if (foundGames.isEmpty()) {
				throw new TitleNotAvailableException();
			}
		} catch (TitleNotAvailableException e) {
			// May need to be changed after
			System.err.println("No games found with that genre and rating");
			return null;
		}
		return foundGames;
	}

	@Override
	public List<Entertainment> entertainmentByGenreAndRating(String Genre, String Rating) {
		String gameRating = Rating == "G" ? "E" : Rating == "PG" || Rating == "PG-13" ? "T" : Rating == "R" ? "M" : Rating == "NOT RATED" ? "N/A" : Rating;
		String movieRating = Rating == "E" ? "G" : Rating == "T" ? "PG-13" : Rating == "M" ? "R" : Rating == "N/A" ? "NOT RATED" : Rating;
		Reader reader = new Reader();
		List<Game> games = reader.readGames();
		List<Movie> movies = reader.readMovies();
		List<Entertainment> entertainments = new ArrayList<Entertainment>();
		entertainments.addAll(games);
		entertainments.addAll(movies);
		List<Entertainment> foundEntertainments = new ArrayList<Entertainment>();
		for (Entertainment e : entertainments) {
			if(e instanceof Movie) {
				if (e.getRated().toLowerCase().contains(movieRating.toLowerCase())) {
					if (e.getGenre().toLowerCase().contains(Genre.toLowerCase())) {
						foundEntertainments.add(e);
					}
				}
			} else if (e instanceof Game) {
				if (e.getRated().toLowerCase().contains(gameRating.toLowerCase())) {
					if (e.getGenre().toLowerCase().contains(Genre.toLowerCase())) {
						foundEntertainments.add(e);
					}
				}
			} else {
				System.err.println("Something's funky");
			}
		}
		try {
			if (foundEntertainments.isEmpty()) {
				throw new TitleNotAvailableException();
			}
		} catch (TitleNotAvailableException e) {
			System.err.println("No entertainment found with that genre and rating");
			return null;
		}
		return foundEntertainments;
	}

	/*
	 * This method should allow someone to checkout a movie or a game for a
	 * particular platform. The checkout should affect the title passed in
	 * directly and only in memory. There is no need to store the changes back
	 * to the json files.(non-Javadoc)
	 */
	@Override
	public <T extends Entertainment> void checkout(T title, Platform<T> platform) {
		if (platform.inStock(title)) {
			platform.checkout(title);
		} else {
			throw new TitleNotAvailableException();
		}
	}
}
