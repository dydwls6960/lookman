<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
  <c:if test="${!empty alertMsg}">
    alert("${alertMsg}");
  </c:if>
</script>
<c:remove var="alertMsg" scope="session"/>