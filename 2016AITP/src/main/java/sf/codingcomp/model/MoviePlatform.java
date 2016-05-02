package sf.codingcomp.model;

public enum MoviePlatform implements Platform<Movie> {
	DVD {
	},
	BLU_RAY {
	};

	@Override
	public boolean inStock(Movie movie) {
		// TODO - determine if the movie is in stock
		switch (this.toString()) {
		case "DVD":
			return Integer.parseInt(movie.getStockDvd()) > 0;
		case "BLU_RAY":
			return Integer.parseInt(movie.getStockBr()) > 0;
		}
		return false;
	}

	@Override
	public void checkout(Movie movie) {
		switch (this.toString()) {
		case "DVD":
			int p = Integer.parseInt(movie.getStockDvd()) - 1;
			movie.setStockDvd(p + "");
		case "BLU_RAY":
			int i = Integer.parseInt(movie.getStockBr()) - 1;
			movie.setStockBr(i + "");
		}
	}
}
