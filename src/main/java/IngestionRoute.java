import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.debezium.DebeziumConstants;
import org.apache.camel.model.dataformat.JsonLibrary;

/**
 * This class extends Apache Camel's RouteBuilder to create a custom route for processing
 * PostgreSQL database change events via Debezium. Because who wouldn't want to capture
 * every INSERT, UPDATE, and DELETE event, and then do something quirky with it?
 *
 * How it works:
 * - Connects to a PostgreSQL database using Debezium.
 * - Converts the database change event into a JSON format using Gson.
 * - Logs the event along with some (occasionally) useful metadata.
 * - Depending on the operation type (INSERT, UPDATE, DELETE), it logs the event accordingly.
 *
 * Feel free to extend or modify, but beware: with great power comes great responsibility.
 *
 * Disclaimer: No databases were harmed in the making of this route.
 *
 * @author Rajat Nigam
 */
@ApplicationScoped
public class IngestionRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Starting the fun ride from Postgres to your logs
        from("debezium-postgres:dbserver1?databaseHostName=localhost"
                + "&databasePort=5432"
                + "&databaseUser=postgres"
                + "&databasePassword=postgres"
                + "&databaseDbname=employee"
                + "&offsetStorageFileName=/tmp/offset.dat"
                + "&topicPrefix=console"
                + "&pluginName=pgoutput")
                .marshal().json(JsonLibrary.Gson)
                .routeId("FromPostgres")
                // Logging the event received, because knowing is half the battle
                .log("Event received from Postgres: ${body}")
                .log("    with metadata: ${headers}")
                // Deciding the type of operation, because classification is key
                .choice()
                .when(header(DebeziumConstants.HEADER_OPERATION).isEqualTo("c"))
                .log("INSERT: ${body}")
                .when(header(DebeziumConstants.HEADER_OPERATION).isEqualTo("u"))
                .log("UPDATE: ${body}")
                .when(header(DebeziumConstants.HEADER_OPERATION).isEqualTo("d"))
                .log("DELETE: ${body}")
                .otherwise()
                // For those mysterious operations that
                .log("UNKNOWN: ${body}");
    }
}
