<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="ISO-8859-1"> -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home page</title>
</head>
<style>
        * {
            margin: 0;
            padding: 0;
            font-family:Arial, Helvetica, sans-serif;
            box-sizing: border-box;
        }
        
        #navbar {
            background-color: teal;
            display: flex;
            justify-content: space-between;
            color: white;
            padding: 15px 30px;
            align-items: center;

        }
        
        #navbar>div {
            display: flex;
            width: 40%;
            justify-content: space-around;
        }

        #navbar p>a {
            text-decoration: none;
            color: white;
            font-size: 22px;
            font-weight: 500;
        }
        #header{
            width: 100%;
            height: 88vh;
            display: flex;
            margin: auto;
            padding: 0px 100px;
            background-color: antiquewhite;
        }
        #header >:first-child{
           width: 60%;
           margin-top: 90px;
        }
        #header>:first-child>div{
            border: 2px solid red;
            border-radius: 10px;
            padding: 28px 100px 28px 30px;
            display:flex;
            margin: 35px 0px;
        }
        #header>:first-child>:last-child{
            margin: 20px;
            font-size: 1.2em;
        }
        #header>:first-child>div>h1{
            color: orange;
            margin: 0px 15px;
        }
        #header>div>img{
            width: 100%;
        }
    </style>
<body>
    <div id="navbar">
        <h1>Masai Vaccination</h1>
        <div>
            <p><a href="register">Rigister</a></p>
            <p><a href="dashboard">Dashboard</a></p>
            <p><a href="vaccinatedUsers">Vaccinated</a></p>
        </div>
    </div>
    <div id="header">
        <div>
            <h1>Historic &amp; Unparalleled Achievement ! India's Glorious Journey of</h1>
            <div>
                <img src="https://www.cowin.gov.in/assets/images/verified.svg" alt="marked">
                <h1>200 CRORE VACCINATIONS</h1>
            </div>
            <h3>
                "India is set to defeat Covid-19. Every Indian is making it possible."
            </h3>
            <h3>- Masai School</h3>
        </div>
        <div>
            <img src="https://www.cowin.gov.in/assets/images/independance.svg" alt="Indian flag">
        </div>
    </div>
</body>
</html>