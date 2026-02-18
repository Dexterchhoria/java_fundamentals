# Servlet Learning Pack (For Spring Boot Mastery)

This guide teaches only servlet concepts that directly help you master Spring Boot.

## How To Use This Pack

1. Study one step at a time.
2. Build a tiny demo for each step.
3. After each step, map it to the matching Spring Boot feature.
4. Do not over-invest in legacy XML style unless mentioned.

## Step 0: Prerequisites (Keep It Short)

Learn:
- HTTP basics: request, response, headers, status codes, methods (GET/POST/PUT/DELETE)
- JSON basics
- Maven/Gradle basics

Classes to open:
- (No Java class for this step; foundation concepts only)

Why for Spring Boot:
- Spring MVC and REST are built on HTTP semantics.

Where to learn:
- MDN HTTP Overview: https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview
- HTTP Methods: https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods
- JSON intro: https://www.json.org/json-en.html
- Maven in 5 minutes: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

## Step 1: Servlet Lifecycle and Container

Learn:
- What a servlet container is (Tomcat/Jetty/Undertow)
- Servlet lifecycle: `init()`, `service()`, `destroy()`
- Difference between container-managed lifecycle vs creating objects manually

Classes to open:
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/servlet/LifecycleServlet.java`
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/listener/AppLifecycleListener.java`

Mini task:
- Create one servlet that logs lifecycle events.

Spring Boot mapping:
- Boot embeds servlet container (default Tomcat).
- Spring beans have lifecycle hooks; understanding container lifecycle helps with startup/shutdown behavior.

Where to learn:
- Jakarta Servlet Spec (official): https://jakarta.ee/specifications/servlet/
- Tomcat intro docs: https://tomcat.apache.org/tomcat-10.1-doc/introduction.html
- HttpServlet Javadoc: https://jakarta.ee/specifications/servlet/6.0/apidocs/jakarta.servlet/jakarta/servlet/http/httpservlet

## Step 2: HttpServlet, Request, Response

Learn:
- `HttpServlet` and `doGet()`, `doPost()`
- `HttpServletRequest`: path, query params, headers, body
- `HttpServletResponse`: status, headers, writing body

Classes to open:
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/servlet/HelloServlet.java`
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/servlet/RequestInfoServlet.java`
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/servlet/ResponseDemoServlet.java`
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/servlet/HttpMethodsServlet.java`

Mini task:
- Build `/hello` endpoint with query param and custom status/header.

Spring Boot mapping:
- `@GetMapping`, `@PostMapping`, `@RequestParam`, `@RequestBody`, `ResponseEntity` are abstraction over this.

Where to learn:
- `HttpServletRequest` Javadoc: https://jakarta.ee/specifications/servlet/6.0/apidocs/jakarta.servlet/jakarta/servlet/http/httpservletrequest
- `HttpServletResponse` Javadoc: https://jakarta.ee/specifications/servlet/6.0/apidocs/jakarta.servlet/jakarta/servlet/http/httpservletresponse
- Baeldung servlet basics: https://www.baeldung.com/intro-to-servlets

## Step 3: URL Mapping and Dispatcher Idea

Learn:
- Servlet URL patterns
- How a single front controller can route multiple endpoints

Classes to open:
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/servlet/NavigationServlet.java`
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/servlet/DescriptorConfiguredServlet.java`

Mini task:
- Create one servlet mapped to `/*` and route based on path manually.

Spring Boot mapping:
- Spring MVC uses `DispatcherServlet` as front controller.
- Handler mappings in Spring are evolved routing over this concept.

Where to learn:
- Servlet mapping basics (Oracle tutorial style): https://docs.oracle.com/javaee/7/tutorial/servlets012.htm
- Spring `DispatcherServlet` reference: https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-servlet.html

## Step 4: Filter Chain (Most Important)

Learn:
- Servlet `Filter` lifecycle and chain
- Pre-processing and post-processing request/response
- Common uses: logging, auth checks, CORS, header manipulation

Classes to open:
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/filter/RequestLoggingFilter.java`
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/filter/SimpleAuthFilter.java`

Mini task:
- Add logging filter and response-time filter.

Spring Boot mapping:
- Spring Security internally relies heavily on filter chain.
- `OncePerRequestFilter`, `FilterRegistrationBean`, and many cross-cutting concerns come from this model.

Where to learn:
- `Filter` Javadoc: https://jakarta.ee/specifications/servlet/6.0/apidocs/jakarta.servlet/jakarta/servlet/filter
- Servlet filter tutorial: https://www.baeldung.com/servlets-java
- Spring Security architecture (filter chain context): https://docs.spring.io/spring-security/reference/servlet/architecture.html

## Step 5: Exception and Error Handling

Learn:
- What happens when servlet throws exceptions
- Error pages/status handling in container

Classes to open:
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/servlet/ErrorDemoServlet.java`

Mini task:
- Throw controlled exception and return structured error JSON.

Spring Boot mapping:
- `@ControllerAdvice`, `@ExceptionHandler`, `BasicErrorController` build on servlet error flow.

Where to learn:
- Servlet error handling concepts: https://www.baeldung.com/servlet-exceptions
- Spring MVC exception handling: https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-exceptionhandler.html

## Step 6: Session, Cookies, and Statelessness

Learn:
- `HttpSession` lifecycle
- Cookie creation and reading
- Server state vs stateless API design

Classes to open:
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/servlet/SessionCookieServlet.java`
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/listener/UserSessionListener.java`

Mini task:
- Implement simple login flag using session, then compare with token-style stateless flow (conceptually).

Spring Boot mapping:
- Session-based auth and Spring Security session policies.
- Why JWT/token APIs avoid server session.

Where to learn:
- `HttpSession` Javadoc: https://jakarta.ee/specifications/servlet/6.0/apidocs/jakarta.servlet/jakarta/servlet/http/httpsession
- MDN Cookies: https://developer.mozilla.org/en-US/docs/Web/HTTP/Cookies
- Spring Security session management: https://docs.spring.io/spring-security/reference/servlet/authentication/session-management.html

## Step 7: ServletContext and Config

Learn:
- `ServletContext` shared application scope
- Init parameters and app-level configuration

Classes to open:
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/servlet/ConfigServlet.java`
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/listener/AppLifecycleListener.java`

Mini task:
- Store app startup time in context and expose it.

Spring Boot mapping:
- Similar to application-wide bean/context concepts.
- Helps understand startup configuration sources and shared objects.

Where to learn:
- `ServletContext` Javadoc: https://jakarta.ee/specifications/servlet/6.0/apidocs/jakarta.servlet/jakarta/servlet/servletcontext
- Context params overview: https://www.geeksforgeeks.org/servletcontext-interface/

## Step 8: Character Encoding, Content Type, and JSON

Learn:
- `Content-Type`, `Accept`, charset (`UTF-8`)
- Correct JSON response handling

Classes to open:
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/servlet/ResponseDemoServlet.java`
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/servlet/HelloServlet.java`

Mini task:
- Return UTF-8 JSON and test with wrong/absent headers.

Spring Boot mapping:
- Message converters (`MappingJackson2HttpMessageConverter`) and content negotiation.

Where to learn:
- MDN Content-Type: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Type
- MDN Accept header: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept
- Spring message converters: https://docs.spring.io/spring-framework/reference/web/webmvc/message-converters.html

## Step 9: Async Request Processing (Need-to-Know)

Learn:
- Async servlet processing basics (`AsyncContext`)
- Why blocking request threads hurts scalability

Classes to open:
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/servlet/AsyncDemoServlet.java`

Mini task:
- Convert one slow endpoint to async processing.

Spring Boot mapping:
- MVC async support (`Callable`, `DeferredResult`) and understanding thread model.

Where to learn:
- Async servlet basics (official tutorial): https://jakarta.ee/learn/docs/jakartaee-tutorial/current/web/servlets/servlets.html
- Spring MVC async requests: https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-ann-async.html

## Step 10: Security Foundation via Filters

Learn:
- Authentication vs authorization at request pipeline level
- Filter ordering and security implications

Classes to open:
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/filter/SimpleAuthFilter.java`
- `servlet-learning-pack/src/main/java/com/siddh/servletguide/filter/RequestLoggingFilter.java`

Mini task:
- Implement naive auth filter and role check.

Spring Boot mapping:
- Direct mental model for Spring Security chain, custom filters, and order.

Where to learn:
- Spring Security servlet architecture: https://docs.spring.io/spring-security/reference/servlet/architecture.html
- Custom filter examples: https://www.baeldung.com/spring-security-custom-filter

## What You Can Skip (For Spring Boot Path)

Skip or lightly read:
- JSP, JSTL, old-school server-side view rendering internals
- Deep XML servlet config (`web.xml`) beyond awareness
- Deprecated APIs and container vendor-specific details

## 2-Week Focus Plan

### Week 1

1. Day 1: Step 0 + Step 1
2. Day 2: Step 2
3. Day 3: Step 3
4. Day 4: Step 4
5. Day 5: Step 5
6. Day 6: Step 6
7. Day 7: Revision + mini project cleanup

### Week 2

1. Day 8: Step 7
2. Day 9: Step 8
3. Day 10: Step 9
4. Day 11: Step 10
5. Day 12-13: Build one mini API using only servlets + filters
6. Day 14: Rebuild same API in Spring Boot and compare layer-by-layer

## Final Integration Exercise (Important)

Build this twice:

Version A (Servlet):
- User API: create user, list user
- Auth filter
- Error handling
- JSON responses

Version B (Spring Boot):
- `@RestController`
- `@Service`
- `@Repository` (in-memory is fine)
- Spring Security basic setup
- Global exception handler

Compare:
- Routing
- Filter/interceptor behavior
- Error pipeline
- Auth flow
- Object lifecycle

## Mastery Checklist

You are ready for deep Spring Boot when you can explain:

1. How request reaches `DispatcherServlet`
2. How filters execute before controller methods
3. How request/response map to Spring MVC annotations
4. How exceptions become HTTP error responses
5. How security chain wraps request processing
6. Why stateless APIs change session behavior

## Next Step After This Pack

Move to:
1. Spring MVC internals
2. Spring Boot auto-configuration basics
3. Spring Security architecture
4. Spring Data JPA fundamentals
