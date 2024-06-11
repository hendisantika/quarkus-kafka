package id.my.hendisantika;

import io.smallrye.reactive.messaging.kafka.Record;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-kafka
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/12/24
 * Time: 06:54
 * To change this template use File | Settings | File Templates.
 */
@ApplicationScoped
public class MovieProducer {

    @Inject
    @Channel("movies-out")
    Emitter<Record<Integer, String>> emitter;

    public void sendMovieToKafka(Movie movie) {
        emitter.send(Record.of(movie.year, movie.title));
    }
}
