# Servlet Learning Pack

This folder is a complete servlet reference by code.

It uses Java EE 7 `javax.servlet` APIs (same family as:
`javax.servlet.http.HttpServlet`).

## Concepts Covered

- Servlet architecture and request flow
- `HttpServlet` lifecycle: `init()`, `service()`, `destroy()`
- HTTP methods: `doGet`, `doPost`, `doPut`, `doDelete`
- Request data: query params, form params, headers, path info
- Response building: status code, headers, content type, body
- Redirect vs forward vs include
- Session tracking and cookies
- `ServletConfig` and `ServletContext`
- Filters (`Filter`, `FilterChain`)
- Listeners (`ServletContextListener`, `HttpSessionListener`)
- Async processing (`startAsync`)
- File upload (`@MultipartConfig`, `Part`)
- Error handling (`sendError`, exception mapping in `web.xml`)
- Thread-safety basics for servlets

## Run Locally (Tomcat 9 / Java 8+)

1. Build:
   - `mvn clean package`
2. Deploy `target/servlet-learning-pack.war` to Tomcat.
3. Open:
   - `http://localhost:8080/servlet-learning-pack/`

## Endpoints

- `/hello`
- `/lifecycle`
- `/methods`
- `/request-info/*`
- `/response-demo`
- `/navigation`
- `/session-cookie`
- `/config`
- `/async-demo`
- `/upload` (GET form, POST file)
- `/error-demo`

## Docs

- Oracle Java EE 7 `HttpServlet`:
  `https://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpServlet.html`
