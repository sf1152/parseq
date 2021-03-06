package com.linkedin.restli.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.linkedin.common.callback.Callback;
import com.linkedin.common.util.None;
import com.linkedin.r2.message.RequestContext;
import com.linkedin.r2.message.rest.RestResponse;
import com.linkedin.r2.transport.common.Client;
import com.linkedin.restli.client.multiplexer.MultiplexedRequest;
import com.linkedin.restli.client.multiplexer.MultiplexedResponse;

class CapturingRestClient extends RestClient {

  private final Map<Request<?>, RequestContext> _capturedRequestContexts = new ConcurrentHashMap<>();

  public Map<Request<?>, RequestContext> getCapturedRequestContexts() {
    return _capturedRequestContexts;
  }

  public void clearCapturedRequestContexts() {
    _capturedRequestContexts.clear();
  }

  private final RestClient _delegate;

  public int hashCode() {
    return _delegate.hashCode();
  }

  public boolean equals(Object obj) {
    return _delegate.equals(obj);
  }

  public void shutdown(Callback<None> callback) {
    _delegate.shutdown(callback);
  }

  public <T> ResponseFuture<T> sendRequest(Request<T> request, RequestContext requestContext) {
    _capturedRequestContexts.put(request, requestContext);
    return _delegate.sendRequest(request, requestContext);
  }

  public <T> ResponseFuture<T> sendRequest(Request<T> request, RequestContext requestContext,
      ErrorHandlingBehavior errorHandlingBehavior) {
    _capturedRequestContexts.put(request, requestContext);
    return _delegate.sendRequest(request, requestContext, errorHandlingBehavior);
  }

  public <T> ResponseFuture<T> sendRequest(RequestBuilder<? extends Request<T>> requestBuilder,
      RequestContext requestContext) {
    return _delegate.sendRequest(requestBuilder, requestContext);
  }

  public <T> ResponseFuture<T> sendRequest(RequestBuilder<? extends Request<T>> requestBuilder,
      RequestContext requestContext, ErrorHandlingBehavior errorHandlingBehavior) {
    return _delegate.sendRequest(requestBuilder, requestContext, errorHandlingBehavior);
  }

  public String toString() {
    return _delegate.toString();
  }

  public <T> void sendRequest(Request<T> request, RequestContext requestContext, Callback<Response<T>> callback) {
    _capturedRequestContexts.put(request, requestContext);
    _delegate.sendRequest(request, requestContext, callback);
  }

  public <T> void sendRestRequest(Request<T> request, RequestContext requestContext,
      Callback<RestResponse> callback) {
    _capturedRequestContexts.put(request, requestContext);
    _delegate.sendRestRequest(request, requestContext, callback);
  }

  public <T> void sendRequest(RequestBuilder<? extends Request<T>> requestBuilder, RequestContext requestContext,
      Callback<Response<T>> callback) {
    _delegate.sendRequest(requestBuilder, requestContext, callback);
  }

  public <T> ResponseFuture<T> sendRequest(Request<T> request) {
    return _delegate.sendRequest(request);
  }

  public <T> ResponseFuture<T> sendRequest(Request<T> request, ErrorHandlingBehavior errorHandlingBehavior) {
    return _delegate.sendRequest(request, errorHandlingBehavior);
  }

  public <T> ResponseFuture<T> sendRequest(RequestBuilder<? extends Request<T>> requestBuilder) {
    return _delegate.sendRequest(requestBuilder);
  }

  public <T> ResponseFuture<T> sendRequest(RequestBuilder<? extends Request<T>> requestBuilder,
      ErrorHandlingBehavior errorHandlingBehavior) {
    return _delegate.sendRequest(requestBuilder, errorHandlingBehavior);
  }

  public <T> void sendRequest(Request<T> request, Callback<Response<T>> callback) {
    _delegate.sendRequest(request, callback);
  }

  public <T> void sendRequest(RequestBuilder<? extends Request<T>> requestBuilder, Callback<Response<T>> callback) {
    _delegate.sendRequest(requestBuilder, callback);
  }

  public void sendRequest(MultiplexedRequest multiplexedRequest) {
    _delegate.sendRequest(multiplexedRequest);
  }

  public void sendRequest(MultiplexedRequest multiplexedRequest, Callback<MultiplexedResponse> callback) {
    _delegate.sendRequest(multiplexedRequest, callback);
  }

  public CapturingRestClient(Client client, String uriPrefix, RestClient delegate) {
    super(client, uriPrefix);
    _delegate = delegate;
  }

}
