
package cn.com.dhcc.cgn.mobins.inspection.client;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Generated(value = {
    "wadl|file:/D:/wadl-dist-1.1.6-bin/wadl-dist-1.1.6/samples/cmdline/application.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2014-08-25T15:54:49.087+08:00")
public class IP10101333 {

    /**
     * The base URI for the resource represented by this proxy
     * 
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("http://10.10.13.33:7981/");
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = IP10101333.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
        if (is!=null) {
            try {
                // Ignore the namespace in the catalog, can't use wildcard until
                // we are sure we have XPath 2.0
                String found = javax.xml.xpath.XPathFactory.newInstance().newXPath().evaluate(
                    "/*[name(.) = 'catalog']/*[name(.) = 'uri' and @name ='" + originalURI +"']/@uri", 
                    new org.xml.sax.InputSource(is)); 
                if (found!=null && found.length()>0) {
                    originalURI = java.net.URI.create(found);
                }
                
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            finally {
                try {
                    is.close();
                } catch (java.io.IOException e) {
                }
            }
        }
        BASE_URI = originalURI;
    }

    public static IP10101333 .Event event(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new IP10101333 .Event(client, baseURI);
    }

    /**
     * Template method to allow tooling to customize the new Client
     * 
     */
    private static void customizeClientConfiguration(ClientConfig cc) {
    }

    /**
     * Template method to allow tooling to override Client factory
     * 
     */
    private static com.sun.jersey.api.client.Client createClientInstance(ClientConfig cc) {
        return com.sun.jersey.api.client.Client.create(cc);
    }

    /**
     * Create a new Client instance
     * 
     */
    public static com.sun.jersey.api.client.Client createClient() {
        ClientConfig cc = new DefaultClientConfig();
        customizeClientConfiguration(cc);
        return createClientInstance(cc);
    }

    public static IP10101333 .Event event() {
        return event(createClient(), BASE_URI);
    }

    public static IP10101333 .Event event(com.sun.jersey.api.client.Client client) {
        return event(client, BASE_URI);
    }

    public static IP10101333 .Alarmlist alarmlist(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new IP10101333 .Alarmlist(client, baseURI);
    }

    public static IP10101333 .Alarmlist alarmlist() {
        return alarmlist(createClient(), BASE_URI);
    }

    public static IP10101333 .Alarmlist alarmlist(com.sun.jersey.api.client.Client client) {
        return alarmlist(client, BASE_URI);
    }

    public static IP10101333 .Clear clear(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new IP10101333 .Clear(client, baseURI);
    }

    public static IP10101333 .Clear clear() {
        return clear(createClient(), BASE_URI);
    }

    public static IP10101333 .Clear clear(com.sun.jersey.api.client.Client client) {
        return clear(client, BASE_URI);
    }

    public static IP10101333 .Alarm alarm(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new IP10101333 .Alarm(client, baseURI);
    }

    public static IP10101333 .Alarm alarm() {
        return alarm(createClient(), BASE_URI);
    }

    public static IP10101333 .Alarm alarm(com.sun.jersey.api.client.Client client) {
        return alarm(client, BASE_URI);
    }

    public static class Alarm {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Alarm(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public Alarm(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/alarm");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public IP10101333 .Alarm.List list() {
            return new IP10101333 .Alarm.List(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public IP10101333 .Alarm.Buff buff() {
            return new IP10101333 .Alarm.Buff(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public static class Buff {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private Buff(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public Buff(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/buff");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public<T >T getAs(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("*/*");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAs(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("*/*");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class List {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private List(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public List(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/list");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public<T >T getAs(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("*/*");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAs(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("*/*");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T getAs(String dmsn, String currentindex, String pagesize, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (dmsn == null) {
                }
                if (dmsn!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("dmsn", dmsn);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("dmsn", ((Object[]) null));
                }
                if (currentindex == null) {
                }
                if (currentindex!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("currentIndex", currentindex);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("currentIndex", ((Object[]) null));
                }
                if (pagesize == null) {
                }
                if (pagesize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pagesize", pagesize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pagesize", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("*/*");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAs(String dmsn, String currentindex, String pagesize, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (dmsn == null) {
                }
                if (dmsn!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("dmsn", dmsn);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("dmsn", ((Object[]) null));
                }
                if (currentindex == null) {
                }
                if (currentindex!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("currentIndex", currentindex);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("currentIndex", ((Object[]) null));
                }
                if (pagesize == null) {
                }
                if (pagesize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pagesize", pagesize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pagesize", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("*/*");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

    }

    public static class Alarmlist {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Alarmlist(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public Alarmlist(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/alarmlist");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public IP10101333 .Alarmlist.Efile efile() {
            return new IP10101333 .Alarmlist.Efile(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public static class Efile {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private Efile(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public Efile(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/efile");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public<T >T getAs(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("*/*");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAs(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("*/*");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T getAs(String dmsn, String param, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (dmsn == null) {
                }
                if (dmsn!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("dmsn", dmsn);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("dmsn", ((Object[]) null));
                }
                if (param == null) {
                }
                if (param!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("param", param);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("param", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("*/*");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAs(String dmsn, String param, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (dmsn == null) {
                }
                if (dmsn!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("dmsn", dmsn);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("dmsn", ((Object[]) null));
                }
                if (param == null) {
                }
                if (param!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("param", param);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("param", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("*/*");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

    }

    public static class Clear {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Clear(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public Clear(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/clear");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public com.sun.jersey.api.client.ClientResponse getAsClientResponse() {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(com.sun.jersey.api.client.ClientResponse.class);
        }

        public<T >T get(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T get(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public com.sun.jersey.api.client.ClientResponse getAsClientResponse(String params, String dmsn) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (params == null) {
            }
            if (params!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("params", params);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("params", ((Object[]) null));
            }
            if (dmsn == null) {
            }
            if (dmsn!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("dmsn", dmsn);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("dmsn", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(com.sun.jersey.api.client.ClientResponse.class);
        }

        public<T >T get(String params, String dmsn, com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (params == null) {
            }
            if (params!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("params", params);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("params", ((Object[]) null));
            }
            if (dmsn == null) {
            }
            if (dmsn!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("dmsn", dmsn);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("dmsn", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T get(String params, String dmsn, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (params == null) {
            }
            if (params!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("params", params);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("params", ((Object[]) null));
            }
            if (dmsn == null) {
            }
            if (dmsn!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("dmsn", dmsn);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("dmsn", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

    }

    public static class Event {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Event(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public Event(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/event");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public com.sun.jersey.api.client.ClientResponse postAsClientResponse() {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(com.sun.jersey.api.client.ClientResponse.class);
        }

        public<T >T post(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T post(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public com.sun.jersey.api.client.ClientResponse postAsClientResponse(String params) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (params == null) {
            }
            if (params!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("params", params);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("params", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(com.sun.jersey.api.client.ClientResponse.class);
        }

        public<T >T post(String params, com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (params == null) {
            }
            if (params!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("params", params);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("params", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T post(String params, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (params == null) {
            }
            if (params!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("params", params);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("params", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public IP10101333 .Event.Test test() {
            return new IP10101333 .Event.Test(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public IP10101333 .Event.Json json() {
            return new IP10101333 .Event.Json(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public static class Json {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private Json(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public Json(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public com.sun.jersey.api.client.ClientResponse postAsClientResponse() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(com.sun.jersey.api.client.ClientResponse.class);
            }

            public<T >T post(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T post(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public com.sun.jersey.api.client.ClientResponse postAsClientResponse(String params) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (params == null) {
                }
                if (params!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("params", params);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("params", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(com.sun.jersey.api.client.ClientResponse.class);
            }

            public<T >T post(String params, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (params == null) {
                }
                if (params!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("params", params);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("params", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T post(String params, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (params == null) {
                }
                if (params!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("params", params);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("params", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class Test {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private Test(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public Test(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/test");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public com.sun.jersey.api.client.ClientResponse postAsClientResponse() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(com.sun.jersey.api.client.ClientResponse.class);
            }

            public<T >T post(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T post(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public com.sun.jersey.api.client.ClientResponse postAsClientResponse(String params) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (params == null) {
                }
                if (params!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("params", params);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("params", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(com.sun.jersey.api.client.ClientResponse.class);
            }

            public<T >T post(String params, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (params == null) {
                }
                if (params!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("params", params);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("params", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T post(String params, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (params == null) {
                }
                if (params!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("params", params);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("params", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new IP10101333 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

    }


    /**
     * Workaround for JAX_RS_SPEC-312
     * 
     */
    private static class WebApplicationExceptionMessage
        extends WebApplicationException
    {


        private WebApplicationExceptionMessage(Response response) {
            super(response);
        }

        /**
         * Workaround for JAX_RS_SPEC-312
         * 
         */
        public String getMessage() {
            Response response = getResponse();
            Response.Status status = Response.Status.fromStatusCode(response.getStatus());
            if (status!= null) {
                return (response.getStatus()+(" "+ status.getReasonPhrase()));
            } else {
                return Integer.toString(response.getStatus());
            }
        }

        public String toString() {
            String s = "javax.ws.rs.WebApplicationException";
            String message = getLocalizedMessage();
            return (s +(": "+ message));
        }

    }

}
