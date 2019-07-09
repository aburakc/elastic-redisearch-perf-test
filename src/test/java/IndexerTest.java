import aburakc.IMDBParser;
import aburakc.index.ElasticIndexer;
import aburakc.index.RedisearchIndexer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class IndexerTest {

    ElasticIndexer elasticIndexer;
    RedisearchIndexer  redisearchIndexer;
    IMDBParser parser;

    @BeforeEach
    public void before() {
        elasticIndexer = new ElasticIndexer();
        redisearchIndexer = new RedisearchIndexer();
        parser = new IMDBParser();
    }

    @Test
    public void elasticIndex() throws IOException {
        parser.parse(elasticIndexer, "src/main/data.tsv");
    }

    @Test
    public void redisearhIndex() throws IOException {
        parser.parse(redisearchIndexer, "src/main/data.tsv");
    }
}
