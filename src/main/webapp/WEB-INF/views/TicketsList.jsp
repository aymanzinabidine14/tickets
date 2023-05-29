<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Products List</title>
    </head>
    <body>
        <header>
            <h1>Products List</h1>
        </header>
        <main>
              <table >
                <tr>
                  <th>Ticket Id</th><th>Ticket Name</th><th>Price</th><th>Date</th>
                </tr>

                 <c:forEach items="${ticketsJsp}" var = "ticket">
                 <tr>
                 <td> ${ticket.getIdTicket()} </td>
                 <td> ${ticket.getNomTicket()} </td>
                 <td> ${ticket.getPrixTicket()} </td>
                 <td><fmt:formatDate pattern="dd/MM/yyyy" value="${ticket.getEventdate()}" /> </td>



                 </tr>
                 </c:forEach>
              </table>
        </main>
        <footer>
            <a href="createTicket">Product Creation</a>
        </footer>
    </body>
</html>


