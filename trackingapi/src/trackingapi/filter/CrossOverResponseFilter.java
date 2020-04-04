package trackingapi.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter; 

public class CrossOverResponseFilter implements ContainerResponseFilter {

    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {

        //System.out.println(request.getQueryParameters().get("_type"));
      

//        if (request.getQueryParameters().get("_type") != null) {
//            if (request.getQueryParameters().get("_type").size() > 0) {
//                if (request.getQueryParameters().get("_type").get(0).equalsIgnoreCase("json")) {
//
//                    request.getAcceptableMediaTypes().add(MediaType.APPLICATION_JSON_TYPE);
//                    response.setContainerRequest(request);
//                    response.getHttpHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON);
//                }
//            }
//        } else {
//            
//            request.getAcceptableMediaTypes().add(MediaType.APPLICATION_XML_TYPE);
//            response.setContainerRequest(request);
//            response.getHttpHeaders().putSingle("Content-Type", MediaType.APPLICATION_XML);
//        }
        response.getHttpHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHttpHeaders().putSingle("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response.getHttpHeaders().putSingle("Access-Control-Allow-Headers", "Accept, Content-type, Origin, X-Requested-With, Content-Type, Last-Modified");
        return response;
    }
}