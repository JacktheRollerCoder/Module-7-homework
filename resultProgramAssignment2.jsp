<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Results</title>
</head>
<body>
    <h2>Your Quiz Results</h2>
    <%
        int numberOfQuestions = 5; // Same as in the quiz
        int correctAnswers = 0;

        for (int i = 0; i < numberOfQuestions; i++) {
            String question = (String) session.getAttribute("question" + i);
            int correctAnswer = (Integer) session.getAttribute("answer" + i);
            String userAnswerStr = request.getParameter("answer" + i);
            int userAnswer = 0;

            // Check if the user provided an answer
            if (userAnswerStr != null && !userAnswerStr.trim().isEmpty()) {
                userAnswer = Integer.parseInt(userAnswerStr);
            }

            // Display the question and result
            out.println("<p>" + question + " Your answer: " + userAnswer + " Correct answer: " + correctAnswer + "</p>");

            // Check if the answer is correct
            if (userAnswer == correctAnswer) {
                correctAnswers++;
            }
        }

        // Display the total correct answers
        out.println("<h3>You got " + correctAnswers + " out of " + numberOfQuestions + " correct!</h3>");

        // Clear the session attributes for the next quiz
        for (int i = 0; i < numberOfQuestions; i++) {
            session.removeAttribute("question" + i);
            session.removeAttribute("answer" + i);
        }
    %>
    <a href="quiz.jsp">Try Again</a>
</body>
</html>
