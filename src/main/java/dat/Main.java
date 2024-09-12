package dat;

import dat.dtos.MovieDTO;
import dat.services.MovieService;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Set locale to US to avoid issues with date formatting and number formatting
        Locale.setDefault(Locale.US);

        try {
            String jsonTextMifune = MovieService.getMovieById(139);
            MovieDTO mifuneDTO = MovieDTO.convertFromJson(jsonTextMifune);
            System.out.println(mifuneDTO);
            System.out.println(mifuneDTO.getOverview());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            String jsonText = MovieService.getMoviesByAvgVotingBetween(8.0, 8.8, 2);
            List<MovieDTO> ratedMovies = MovieDTO.convertFromJsonList(jsonText);
            ratedMovies.forEach(System.out::println);

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}