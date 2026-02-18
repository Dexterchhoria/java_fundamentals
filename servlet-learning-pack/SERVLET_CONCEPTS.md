# Servlet Concepts (Complete Map)

## 1) What Is a Servlet?

A servlet is a server-side Java class that handles web requests and builds web responses.
It runs inside a servlet container (Tomcat/Jetty/etc), not as a normal `main()` program.

Request flow:
`Browser -> Web Server/Servlet Container -> Servlet -> Response -> Browser`

## 2) Core APIs

- `Servlet` (root interface)
- `GenericServlet` (protocol-neutral base)
- `HttpServlet` (HTTP-specific base class)
- `HttpServletRequest` (incoming request data)
- `HttpServletResponse` (outgoing response)

`HttpServlet` dispatches to method handlers by HTTP verb:
- `GET -> doGet`
- `POST -> doPost`
- `PUT -> doPut`
- `DELETE -> doDelete`
- etc.

## 3) Lifecycle

Container-managed lifecycle:
1. Create servlet instance (usually once)
2. Call `init(ServletConfig)` once
3. Call `service(...)` per request (usually multi-threaded)
4. Call `destroy()` once before unload/shutdown

Important:
- A single servlet instance can serve many concurrent requests.
- Do not store request-specific mutable state in instance fields.

## 4) URL Mapping

Two common styles:
- Annotation: `@WebServlet("/hello")`
- Descriptor: `web.xml` servlet + servlet-mapping

This pack shows both.

## 5) Request Handling

Common request reads:
- Query/form params: `getParameter`
- Headers: `getHeader`, `getHeaderNames`
- Path data: `getRequestURI`, `getPathInfo`
- Attributes (server-side sharing): `setAttribute/getAttribute`

## 6) Response Handling

Common response writes:
- Content type: `setContentType`
- Status code: `setStatus`, `sendError`
- Headers: `setHeader`
- Body: `getWriter().println(...)`

## 7) Redirect vs Forward vs Include

- Redirect: `sendRedirect(...)`
  - Client gets 3xx and makes a new request.
  - URL changes in browser.
- Forward: `RequestDispatcher.forward(...)`
  - Server-internal handoff, same request object.
  - URL does not change.
- Include: `RequestDispatcher.include(...)`
  - Insert output of another resource into current response.

## 8) State Management

HTTP is stateless. Common techniques:
- Cookies (`javax.servlet.http.Cookie`)
- Sessions (`HttpSession`)
  - Container tracks session id (usually `JSESSIONID` cookie).
  - Per-user data across requests.

## 9) Config and Context

- `ServletConfig`
  - Per-servlet init params from annotation/web.xml.
- `ServletContext`
  - App-wide shared context and params.

## 10) Filters

`Filter` sits before/after servlet invocation.
Typical uses:
- Logging
- Auth checks
- Compression/CORS

Chain flow:
`request -> filter1 -> filter2 -> servlet -> filter2 -> filter1`

## 11) Listeners

Listeners observe container events:
- `ServletContextListener`: app startup/shutdown
- `HttpSessionListener`: session create/destroy

Good for bootstrapping resources, metrics, auditing.

## 12) Async Processing

With `@WebServlet(asyncSupported = true)`:
- Start async via `request.startAsync()`
- Do background work
- Write response later
- Call `asyncContext.complete()`

Prevents blocking container request thread for long jobs.

## 13) File Upload

Use `@MultipartConfig` + `request.getPart("file")` for multipart/form-data.

## 14) Error Handling

Options:
- Inline: `sendError(...)` from servlet
- Central mapping: `<error-page>` in `web.xml`

## 15) Concurrency Rules

Servlet instance fields are shared across threads.
Keep servlet class stateless unless using thread-safe constructs.

Bad:
- `private int counter;` incremented per request without sync

Good:
- Local variables inside request methods
- Immutable or synchronized/shared-safe state only when needed
