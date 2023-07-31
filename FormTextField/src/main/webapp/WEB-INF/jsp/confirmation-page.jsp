<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>  
<html>  
<body>  
<p>Your reservation is confirmed successfully. Please, re-check the details.</p>  

<ul>
  <c:forEach items="${list}" var="item">
    <li>${item}</li>
  </c:forEach>
</ul>


</body>  
</html>  