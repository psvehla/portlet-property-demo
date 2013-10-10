<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %> 
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<form action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post" name="<portlet:namespace />fm"> 
	Message: <input type="text" name="<portlet:namespace />message" value="${message}" size="100" /> <br/> <br/>
	<input type="button" value="Save" onClick="submitForm(document.<portlet:namespace />fm);" /> 
</form>