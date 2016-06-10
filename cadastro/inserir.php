<?php

?>
<meta charset="UTF-8">

<!-- Formulario para cadastrar pessoas no banco de dados -->

<form name="dadosPessoa" action="conexao.php" method="POST">
    <table border="1">
        <tbody>
            <tr>
                <td>Nome:</td>
                <td><input type="text" name="nome" value="" /></td>
            </tr>
            <tr>
                <td>Nascimento:</td>
                <td><input type="date" name="nascimento" value="" /></td>
            </tr>
            <tr>
                <td>Telefone:</td>
                <td><input type="text" name="telefone" value="" /></td>
            </tr>
            <tr>
                <td>Endereço:</td>
                <td><input type="text" name="endereco" value="" /></td>
            </tr>
            
            <tr>
                <td><input type="hidden" name="acao" value="inserir" /></td>
                <td><input type="submit" value="Enviar" name="Enviar" /></td>
            </tr>
        </tbody>
    </table>

</form>
