package dat.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO {
    private boolean adult;
    private String backdrop_path;  // example:  https://image.tmdb.org/t/p/w780/921vUyXdfIYpaXqu5Lnf3nVb4IJ.jpg
    private int budget;
    private List<Genre> genres;
    private int id;
    private String imdb_id;
    private List<String> origin_country;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private String poster_path;
    private List<ProductionCompany> production_companies;
    private List<ProductionCountry> production_countries;
    private LocalDate release_date;
    private int revenue;
    private int runtime;
    private List<SpokenLanguage> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;


    public static MovieDTO convertFromJson(String jsonText) {
        // Create an instance of ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            // Convert the JSON string to MovieDTO object
            MovieDTO movie = objectMapper.readValue(jsonText, MovieDTO.class);
            return movie;
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    // convertFromJson to List<MovieDTO>
    public static List<MovieDTO> convertFromJsonList(String jsonText) {
        // Create an instance of ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            // Deserialize into the MovieResponseDTO class
            MovieResponseDTO movieResponse = objectMapper.readValue(jsonText, MovieResponseDTO.class);
            return movieResponse.getResults();
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Getter method to extract release year from release_date
    public String getReleaseYear() {
        if (release_date != null) {
            return String.valueOf(release_date.getYear());
        }
        return null;
    }
}
