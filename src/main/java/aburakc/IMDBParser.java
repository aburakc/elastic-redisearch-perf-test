package aburakc;

import aburakc.index.Indexer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class IMDBParser {

    private static Short toShort(String str) {
        if(str == null || str.equals("\\N")) {
            return null;
        }

        return Short.parseShort(str);
    }

    public void parse(Indexer indexer, String url) throws IOException {
        long begin = System.currentTimeMillis();
        BufferedReader imdbData = new BufferedReader(new FileReader(url));
        String row;
        Movie movie = new Movie();
        imdbData.readLine();
        while ((row = imdbData.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(row, "\t");

            int i = 1;
            while (st.hasMoreElements()) {
                switch (i) {
                    case 1:
                        movie.setTconst(st.nextToken());
                        break;
                    case 2:
                        movie.setTitleType(st.nextToken());
                        break;
                    case 3:
                        movie.setPrimaryTitle(st.nextToken());
                        break;
                    case 4:
                        movie.setOriginalTitle(st.nextToken());
                        break;
                    case 5:
                        movie.setAdult(st.nextElement().equals(0) ? Boolean.FALSE : Boolean.TRUE);
                        break;
                    case 6:
                        movie.setStartYear(toShort(st.nextToken()));
                        break;
                    case 7:
                        movie.setEndYear(toShort(st.nextToken()));
                        break;
                    case 8:
                        movie.setRuntimeMinutes(toShort(st.nextToken()));
                        break;
                    case 9:
                        movie.setGenres(st.nextToken());
                        break;
                }
                i++;
            }
            long b1 = System.currentTimeMillis();
            indexer.index(movie);
            System.out.println("IND : " + movie.getTconst() + " - " + (System.currentTimeMillis() - b1));
        }
        imdbData.close();

        System.out.println(System.currentTimeMillis() - begin);

    }
}
