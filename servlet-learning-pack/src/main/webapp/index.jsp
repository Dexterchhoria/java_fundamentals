<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Servlet Learning Pack</title>
</head>
<body>
<h1>Servlet Learning Pack</h1>
<p>Use these links to test servlet concepts.</p>
<ul>
    <li><a href="hello">Hello Servlet</a></li>
    <li><a href="lifecycle">Lifecycle Servlet</a></li>
    <li><a href="methods">HTTP Methods Servlet</a></li>
    <li><a href="request-info/sample/path?name=Siddh&role=student">Request Info Servlet</a></li>
    <li><a href="response-demo">Response Demo Servlet</a></li>
    <li><a href="navigation">Navigation Servlet</a></li>
    <li><a href="session-cookie">Session + Cookie Servlet</a></li>
    <li><a href="config">Config Servlet</a></li>
    <li><a href="async-demo">Async Servlet</a></li>
    <li><a href="upload">Upload Servlet</a></li>
    <li><a href="error-demo?type=404">Error Demo: 404</a></li>
    <li><a href="error-demo?type=500">Error Demo: 500</a></li>
</ul>

<h2>POST test for /methods</h2>
<form method="post" action="methods">
    <label>message: <input name="message" value="Hello via POST"/></label>
    <button type="submit">Send POST</button>
</form>
</body>
</html>
