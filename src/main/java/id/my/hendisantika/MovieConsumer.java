package id.my.hendisantika;

import io.smallrye.reactive.messaging.kafka.Record;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-kafka
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/12/24
 * Time: 06:55
 * To change this template use File | Settings | File Templates.
 */
@ApplicationScoped
public class MovieConsumer {

    private final Logger logger = Logger.getLogger(MovieConsumer.class);

    @Incoming("movies-in")
    public void receive(Record<Integer, String> record) {
        logger.infof("Got a movie: %d - %s", record.key(), record.value());
    }
}
