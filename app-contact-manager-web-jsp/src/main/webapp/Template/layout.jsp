<%-- 
    Document   : layout
    Created on : 27 sept. 2015, 12:00:19
    Author     : Riad YOUSFI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <body style="width:100%;height:100%">
        <table border="1" cellspacing="0" cellpadding="0" style="width:100%;height:100%">
            <tr>
                <td colspan="2">
                    <tiles:insertAttribute name="header" /></td>
            </tr>
            <tr>
                <td>
                    <tiles:insertAttribute name="menu" /></td>
                <td>
                    <tiles:insertAttribute name="body" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <tiles:insertAttribute name="footer" /></td>
            </tr>
        </table>
    </body>
</html>
