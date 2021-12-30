package manifolddemo.extensions.org.springframework.http.HttpRequest;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.springframework.http.HttpRequest;

@Extension
public class HttpRequestExt {
  public static void helloWorld(@This HttpRequest thiz, String hello) {
    if (hello.isNullOrEmpty()) {
      System.out.println("bye!");
    }
    System.out.println("hello " + hello + "!");
  }
}