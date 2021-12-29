package manifolddemo.extensions.org.springframework.http.server.reactive.ServerHttpRequest;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
// cannot find symbols
import org.springframework.http.server.reactive.ServerHttpRequest;


@Extension
public class ServerHttpRequestExt {
  // cannot find symbols
  public static void helloWorld(@This ServerHttpRequest thiz, String hello) {
    if (hello.isNullOrEmpty()) {
      System.out.println("bye!");
    }
    System.out.println("hello " + hello + "!");
  }
}