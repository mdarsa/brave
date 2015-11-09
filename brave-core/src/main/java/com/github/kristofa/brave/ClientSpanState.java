package com.github.kristofa.brave;

import com.github.kristofa.brave.internal.Nullable;
import com.twitter.zipkin.gen.Endpoint;
import com.twitter.zipkin.gen.Span;

/**
 * Maintains client span state.
 * 
 * @author kristof
 */
public interface ClientSpanState extends CommonSpanState {

    /**
     * Gets the Span for the client request that was started as part of current request.
     * <p/>
     * Should be thread-aware to support multiple parallel requests.
     * 
     * @return Client request span for current thread.
     */
    Span getCurrentClientSpan();

    /**
     * Gets the Endpoint (ip, port, service name) for this service.
     * Service name might have been overridden.
     * Should be thread-aware to the service name can be overridden per request.
     *
     * @return Endpoint for this service.
     */
    Endpoint getClientEndpoint();

    /**
     * Sets current client span.
     * <p/>
     * Should be thread-aware to support multiple parallel requests.
     * 
     * @param span Client span.
     */
    void setCurrentClientSpan(final Span span);

    /**
     * @param serviceName Name of the local service being traced. If specified, should be lowercase and not empty.
     */
    void setCurrentClientServiceName(@Nullable String serviceName);
}
