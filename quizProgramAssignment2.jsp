<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <title>Programming Assignment 2 - Addition Quiz</title>
</head>
<body>
    <h2>Programming Assignment 2 - Addition Quiz</h2>
    <form method="post" action="result.jsp">
        <%
            // Generate random addition questions
            int numberOfQuestions = 5; // Adjust the number of questions
            for (int i = 0; i < numberOfQuestions; i++) {
                int num1 = (int)(Math.random() * 100); // Random number between 0 and 99
                int num2 = (int)(Math.random() * 100); // Random number between 0 and 99
                session.setAttribute("question" + i, num1 + " + " + num2);
                session.setAttribute("answer" + i, num1 + num2); // Store the correct answer
                out.println(num1 + " + " + num2 + " = <input type='text' name='answer" + i + "' /><br/>");
            }
        %>
        <input type="submit" value="Submit Answers" />
    </form>
</body>
</html>
