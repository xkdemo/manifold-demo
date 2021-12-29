package manifolddemo.extensions.org.springframework.http.server.reactive.ServerHttpRequest;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.springframework.http.server.reactive.ServerHttpRequest;

@Extension
public class ServerHttpRequestExt {
  public static void helloWorld(@This ServerHttpRequest thiz) {
    System.out.println("hello world!");
  }
}