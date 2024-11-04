<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM Prd_CatalogService: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>IBM Prd_CatalogService: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Prd_CatalogService: Home</p>

<h3>��Ƭd��:</h3>
	
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllPrd_Catalog.jsp'>List</a> all Prd_Catalogs.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%= request.getContextPath() %>/emp/emp.do"> 
        <b>��J�ӫ~���O�s�� (�p1):</b>
        <input type="text" name="id">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="prd_CatalogSvc" scope="page" class="com.emp.model.Prd_CatalogService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%= request.getContextPath() %>/emp/emp.do" >
       <b>��ܰӫ~���O�s��:</b>
       <select size="1" name="id">
         <c:forEach var="prd_CatalogVO" items="${prd_CatalogSvc.all}" > 
          <option value="${prd_CatalogVO.id}">${prd_CatalogVO.id}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%= request.getContextPath() %>/emp/emp.do" >
       <b>��ܰӫ~���O�W��:</b>
       <select size="1" name="id">
         <c:forEach var="prd_CatalogVO" items="${prd_CatalogSvc.all}" > 
          <option value="${prd_CatalogVO.id}">${prd_CatalogVO.name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
     </FORM>
  </li>
</ul>


<h3>�ӫ~���O�޲z</h3>

<ul>
  <li><a href='addPrd_Catalog.jsp'>Add</a> a new Prd_Catalog.</li>
</ul>

</body>
</html>