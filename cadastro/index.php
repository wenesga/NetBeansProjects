<!DOCTYPE html>

<?php include("conexao.php");
      $grupo = selectAllPessoa();
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Inscrições - Semana do Meio Ambiente</h1>
        
        <br/><br/><br/>
        
        <!-- Link para acessar pagina cadastro-->
        <a href="inserir.php">Inscrição - Capitalismo e Sustentabilidade - 20 Vagas</a>    
        
        <br/><br/><br/>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Nascimento</th>
                    <th>Telefone</th>
                    <th>Endereço</th>
                    <th>Editar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>
                <?php
                    foreach ($grupo as $pessoa) { ?>
                    <tr>
                    <td><?=$pessoa["nome"]?></td>
                    <td><?=formatoData($pessoa["nascimento"])?></td>
                    <td><?=$pessoa["telefone"]?></td>
                    <td><?=$pessoa["endereco"]?></td>
                    <td>
                        <form name="alterar" action="alterar.php" method="POST">
                            <input type="hidden" name="id" value=<?=$pessoa["id"]?> />
                            <input type="submit" value="Editar" name="editar" />
                            </form>
                    </td>
                    <td>
                        <form name="excluir" action="conexao.php" method="POST">
                            <input type="hidden" name="id" value="<?=$pessoa["id"]?>" />
                            <input type="hidden" name="acao" value="excluir" />
                            <input type="submit" value="Excluir" name="excluir" />
                            </form>
                        
                    </td>
                    </tr>
                 <?php  }
                ?>
            </tbody>
        </table>
        <?php
        
        function formatoData($data){
            $array = explode("-", $data);
            // $data = 2016-04-14
            // $array[0]= 2016, $array[1] = 04 e $array[2]= 14;
            $novaData = $array[2]."/".$array["1"]."/".$array[0];
            return $novaData;
        }
        ?>
    </body>
</html>
