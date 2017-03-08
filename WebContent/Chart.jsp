<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html" 
	xmlns:t="http://myfaces.apache.org.tomahawk" version="2.0"
	xmlns:p="http://primefaces.org/ui"> 
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
		xmlns:t="http://myfaces.apache.org/tomahawk"
		xmlns:p="http://primefaces.org/ui">  
		<link rel="stylesheet" href="CSS/StyleSheet.css" />
		
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Genivity</title>
</head>
<body>
<div align="center">
<img src="CSS/Genivity-logo-horizontal-01.png" alt="HTML5 Icon" style="width:500px;height:200px;"/>
</div>
<div align="center">
	<f:view>
	<h:form>


		<h:commandButton value="Generate Chart" action="#{login.generateChart}" styleClass="button"/>
  
       
  <p:pieChart   value="#{allFunctions.pieModel1}" style="width:400px;height:300px">
  </p:pieChart>
   
    	
	</h:form>
	</f:view>
</div>
</body>
</html>
</jsp:root>