<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>500 Server Error</title></head>
<body>
<h1>500 - Server Error</h1>
<p>A runtime exception occurred and was mapped in web.xml.</p>
<p><a href="<%= request.getContextPath() %>/">Back to home</a></p>
</body>
</html>
