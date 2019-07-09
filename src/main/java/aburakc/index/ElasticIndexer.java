package aburakc.index;

import aburakc.Movie;
import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.common.xcontent.XContentType;
import java.io.IOException;

public class ElasticIndexer implements Indexer {

    private RestHighLevelClient client;


    public ElasticIndexer() {
        client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));
    }

    public String toJson(Movie movie) {
        Gson gson = new Gson();
        return gson.toJson(movie);
    }

    public void index(Movie movie) {
        IndexRequest indexRequest = new IndexRequest("movies").id(movie.getTconst()).source(toJson(movie), XContentType.JSON);
        try {
            IndexResponse index = client.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
