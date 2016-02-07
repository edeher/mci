<%-- 
    Document   : login2
    Created on : 06/10/2015, 09:16:24 AM
    Author     : Mi Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
  <link rel="stylesheet" href="css/style.css">
  <script language="javaScript">

        function verificar(f)
        {
            var falta = "";

            if (f.txtUsuario.value == "")
            {
                falta += "\t Usuario \n ";
            }
            if (f.txtClave.value == "")
            {
                falta += "\t Clave \n ";
            }
            if (falta != "")
            {
                alert("Ingrese :\n " + falta + " : correctos");
                return false;
            }
             else 
                {
                    f.action="sLogin?val=ING";
                    f.submit();
                    return true;
                }


        }
       

    </script>
  <%
    String vel="";
    
    vel=request.getParameter("vel");
     if (vel == null) {
            vel = "noway";
        }
   System.out.println("vel :"+vel);
    %>
</head>
<body>
  <section class="container">
    <div class="login">
      <h1>Sistema de Gestion de Celugrama</h1>
      <form name="f" action="sLogin?val=ING" method="POST">
        <p><input type="text" name="txtUsuario" value="" placeholder="Username or Email"></p>
        <p><input type="password" name="txtClave" value="" placeholder="Password"></p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
            Recordar credenciales en este Equipo
          </label>
        </p>
        <p class="submit">
            <input type="button" value="Login "  onclick="verificar(this.form)"/></p>
      </form>
    </div>

    <div class="login-help">
     <!-- <p>Forgot your password? <a href="login2.jsp">Click here to reset it</a>.</p>-->
    </div>
  </section>

  
</body>
</html>
