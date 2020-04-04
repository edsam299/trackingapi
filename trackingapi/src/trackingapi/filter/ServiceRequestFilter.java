package trackingapi.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class ServiceRequestFilter implements ContainerRequestFilter{

    @Override
    public ContainerRequest filter(ContainerRequest cr) {
   
        return cr;
    }
}