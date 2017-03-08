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
		<link rel="stylesheet" href="CSS/navigation.css" />
		<link rel="stylesheet" href="CSS/buttons.css" />
		
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Main Menu</title>
</head>
<body>
<div align="center">
<img src="CSS/Genivity-logo-horizontal-01.png" alt="HTML5 Icon" style="width:500px;height:200px;"/>
</div>
<div align="center">
	<f:view>
	<h:form>
<br/> 
<br/> 
<br/> 
	<h:panelGrid rendered="#{login.renderMessage}" >
		<h:outputText value="#{login.message}" style="color:red; font-size:90%; font-weight:bold"/>
	</h:panelGrid>
	<br/> 
	<br/> 
	<br/> 
		<h:panelGrid columns="5">
        <h:commandButton value="Add/Modify Accounts" action="#{login.getProvidersToken}" styleClass="button"/>
		<h:outputText value=" "></h:outputText>
		<h:commandButton value="Transactions" action="#{login.getTransactions}" styleClass="button"/>
		<h:outputText value=" "></h:outputText>
		<h:commandButton value="Reports" action="#{login.generateChart}" styleClass="button"/>
        </h:panelGrid>
        <br/>
        <br/>
        <img src="CSS/financially-healthy.jpg" alt="HTML5 Icon" style="width:500px;height:500px;"/>
  <div style="background-attachment: scroll; overflow:auto;
                    		height:500px; background-repeat: repeat" align="center">
    		<h:dataTable value="#{allFunctions.tlist}" var="o" rendered="#{login.renderDatatable}"
    		 border="1" cellspacing="0" cellpadding="1" styleClass="report" width="100%">
    		 <h:column headerClass="col1">
    				<!-- column header -->
    				<f:facet name="header">
               <h:outputText value="Id"/>
              </f:facet>
    				<!-- row record -->
    				 <h:outputText value="#{o.id}"/>
    			</h:column>
    			<h:column headerClass="col1">
    				<!-- column header -->
    				<f:facet name="header">
               <h:outputText value="Date"/>
              </f:facet>
    				<!-- row record -->
    				 <h:outputText value="#{o.date}"/>
    			</h:column>
    			<h:column headerClass="col2">
    				<f:facet name="header">
               <h:outputText value="Amount"/>
              </f:facet>
    				<h:outputText value="#{o.amount}"/>
    			</h:column>
    			<h:column headerClass="col3">
    				<f:facet name="header">
               <h:outputText value="Category"/>
              </f:facet>
    				<h:outputText value="#{o.category}"/>
    			</h:column>
    			<h:column headerClass="col4">
    			<f:facet name="header">
               <h:outputText value="Description"/>
              </f:facet>
    				<h:outputText value="#{o.description}"/>
    			</h:column>
    		</h:dataTable>
    	</div>
    	
	</h:form>
	</f:view>
</div>
</body>
</html>
</jsp:root>