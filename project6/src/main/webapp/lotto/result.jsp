<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		Random rand = new Random();
	%>
    <ul>
    	<%
    		String strCount = request.getParameter("game_count");
    		int count = 0;
    		if(strCount != null) {
    			count = Integer.parseInt(strCount);
    		}
    		
    		for(int i = 0; i < count; i++) {
    	%>
    			<li>
    	<%
	    		ArrayList<Integer> lotto = new ArrayList<Integer>();
	    		while(lotto.size() < 6) {
	    			int num = rand.nextInt(45) + 1;
	    			if(lotto.indexOf(num) == -1) {
	    				lotto.add(num);
	    			}
	    		}
	    		
	    		for(int num: lotto) {
    	%>
        			<%=num %>&nbsp;
        <%
    			}
	    %>
	    		</li>
	    <%
    		}
        %>
    </ul>
    <a href="/lotto">다시하기</a>
</body>
</html>