<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" version="2.0">
    <jsp:directive.page language="java"
        contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" />
    <jsp:text>
        <![CDATA[ <?xml version="1.0" encoding="ISO-8859-1" ?> ]]>
    </jsp:text>
    <jsp:text>
        <![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
    </jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml"
		xmlns:f="http://java.sun.com/jsf/core"
		xmlns:h="http://java.sun.com/jsf/html"
		xmlns:t="http://myfaces.apache.org/tomahawk">
		<link rel="stylesheet" href="CSS/login.css" />
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Genivity</title>
	<div align="center">
	<img src="CSS/Genivity-logo-horizontal-01.png" alt="HTML5 Icon" style="width:500px;height:200px;"/>
	</div>
</head>
<body >
<div align="center">
<div class="login-page">
 <div class="form" >
	<f:view>
	<h:form >
	<div align="center">
	<h:panelGrid rendered="#{login.renderMessage}" >
		<h:outputText value="#{login.message}" style="color:red; font-size:90%; font-weight:bold"/>
	</h:panelGrid>
	</div>
	<div align="center">
	 <p class="message">Already registered? <a href="#">Sign In</a></p>
	 <br></br>
	 <br></br>
	<h:panelGrid columns="2">
	<h:outputText value="Username"/>
		<h:inputText id="username2" value="#{login.username}"  required="true" requiredMessage="&#160;&#160;Please enter your username"/>
		<h:outputText value="Password"/>
		<h:inputText id="password2" value="#{login.password}" alt="password" required="true" requiredMessage="&#160;&#160;Please enter your password"/>
		<h:message for="password2" style="color:red; font-size:75%" />
		<h:outputText value=" "/>
		<h:message for="username2" style="color:red; font-size:75%" />
		</h:panelGrid>
		</div>
	<h:commandButton value="Login" action="#{login.connect}" styleClass="button"/>
	<br></br>
	<p class="message">Not registered? <a href="RegisterUser.jsp">Create an account</a></p>
	</h:form>
	</f:view>
	</div>
	</div>
	</div>

	
</body>
</html>
</jsp:root>