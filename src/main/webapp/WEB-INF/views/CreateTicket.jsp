<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Creation</title>
    </head>
    <body>
        <header>
            <h1>Product Creation</h1>
        </header>
        <main>
            <form action="saveTicket" method="post">
                <div>
                    <label for="NomTicket">Name : </label>
                    <input type="text" id="NomTicket" name="NomTicket">
                </div>
                <div>
                    <label for="DescriptionTicket">Description : </label>
                    <input type="text" id="DescriptionTicket" name="DescriptionTicket">
                </div>
                <div>
                    <label for="PrixTicket">Price : </label>
                    <input type="text" id="PrixTicket" name="PrixTicket">
                </div>
                <div>
                    <label for="Eventdate">Creation Date : </label>
            	     <input type="date" id="Eventdate" name="dateJsp" value="${now}">
                </div>

                 <div>
                     <label for="NombreTicket">quantite : </label>
                     <input type="text" id="NombreTicket" name="NombreTicket">
                 </div>

                <div>
                    <input type="submit" value="Save">
                </div>
            </form>
            ${messageJsp}
        </main>
        <footer>
            <a href="ticketList">Products List</a>
        </footer>
    </body>
</html>


