<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/header.jspf" %> 
<%@ include file="/WEB-INF/jspf/debug.jspf" %> 

<table class="table table-striped" style="background-color: white;">
    <thead>
        <tr>
            <th scope="col">Order Number</th>
            <th scope="col">Height</th>
            <th scope="col">Width</th>
            <th scope="col">Depth</th>
            <th scope="col">Ready</th>
            <th scope="col"></th>
        </tr>
    </thead>
    <tbody>
        
        ${content}
        
    </tbody>
</table>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>