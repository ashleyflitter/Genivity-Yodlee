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
		<link rel="stylesheet" href="CSS/Register.css" />
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Genivity</title>
</head>
<body>
<div align="center">
<img src="CSS/Genivity-logo-horizontal-01.png" alt="HTML5 Icon" style="width:500px;height:200px;"/>
</div>
<div class="login-page">
 <div class="form" >

	<f:view>
	<h:form>
	<div align="center">
	<h:panelGrid  rendered="#{register.renderMessage}" >
		<h:outputText value="#{register.message}" style="color:red; font-size:90%; font-weight:bold"/>
	</h:panelGrid>
	</div>
	<br></br>
	<br></br>
	<div align="center">
	<p class="message">Enter Your Details</p>
	<br></br>
	<br></br>
	<h:panelGrid columns="3" >
		<h:outputText value="Login Username:" />
		<h:inputText id="username" value="#{register.username}" style="width:100%" required="true" requiredMessage="&#160;&#160;Please enter your username"/>
		<h:message for="username" style="color:red; font-size:75%" />
		<h:outputText value="Login Password:"/>
		<h:inputSecret id="password1" value="#{register.password}" style="width:100%" required="true" requiredMessage="&#160;&#160;Please enter your password"/>
		<h:message for="password1" style="color:red; font-size:75%" />
		<h:outputText value="Please confirm Password:"/>
		<h:inputSecret id="password2" value="#{register.confirmpassword}" style="width:100%" required="true" requiredMessage="&#160;&#160;Please enter your password"/>
		<h:message for="password2" style="color:red; font-size:75%" />
		<h:outputText value="Email:"/>
		<h:inputText id="email1" value="#{register.email}" style="width:100%" required="true" requiredMessage="&#160;&#160;Please enter the mail"/>
		<h:message for="email1" style="color:red; font-size:75%" />
		</h:panelGrid>
		</div>
		<br></br>
		<h:commandButton value="Login" action="#{register.registerUser}" styleClass="button"/>
	</h:form>
	</f:view>
	</div>
	</div>
</body>
</html>
</jsp:root>