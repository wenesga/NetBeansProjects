<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Formulário</title>
    </head>
    <body>
        <?php
            //include "conecta_mysql.inc";
            echo "Nome".$_POST['textnome'];
            echo "Idade".$_POST['textidade'];
            echo "Fone".$_POST['textfone'];
            echo "CPF".$_POST['textcpf'];
            echo "Endereço".$_POST['textendereco'];
        ?>
    </body>
</html>
