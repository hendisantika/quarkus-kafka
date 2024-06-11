package id.my.hendisantika;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-kafka
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/12/24
 * Time: 06:56
 * To change this template use File | Settings | File Templates.
 */
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

    @Inject
    MovieProducer producer;

    @POST
    public Response send(Movie movie) {
        producer.sendMovieToKafka(movie);
        // Return an 202 - Accepted response.
        return Response.accepted().build();
    }

}
