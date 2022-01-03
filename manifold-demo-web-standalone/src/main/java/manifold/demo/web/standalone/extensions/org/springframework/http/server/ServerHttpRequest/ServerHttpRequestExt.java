package manifold.demo.web.standalone.extensions.org.springframework.http.server.ServerHttpRequest;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.springframework.http.server.ServerHttpRequest;

@Extension
public class ServerHttpRequestExt {
  public static void helloWorld(@This ServerHttpRequest thiz, String hello) {
    if (hello.isNullOrEmpty()) {
      System.out.println("isNullOrEmpty");
    }
    else {
      System.out.println("hello world!");
    }
  }
}