package aburakc.index;

import aburakc.Movie;
import io.redisearch.Schema;
import io.redisearch.client.Client;

public class RedisearchIndexer implements Indexer {
    private Client client;

    public RedisearchIndexer() {
        client = new Client("movies", "localhost", 6379);
        Schema sc = new Schema()
                .addTextField("tconst", 1.0)
                .addTextField("indexRequest", 1.0)
                .addTextField("primaryTitle", 1.0)
                .addTextField("originalTitle", 1.0)
                .addNumericField("isAdult")
                .addNumericField("startYear")
                .addNumericField("endYear")
                .addNumericField("runtimeMinutes")
                .addTextField("genres", 1.0);
        client.createIndex(sc, Client.IndexOptions.Default());
    }

    public void index(Movie movie) {
        client.addDocument(movie.getTconst(), movie.toMap());
    }
}
