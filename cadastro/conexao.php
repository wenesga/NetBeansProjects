<?php

// Condição para identificar qual valor do post ação que está recebendo (inserir, alterar, excluir)

if(isset($_POST["acao"])){
    if($_POST["acao"]=="inserir"){
        inserirPessoa();
    }
    if($_POST["acao"]=="alterar"){
        alterarPessoa();
    }
    if($_POST["acao"]=="excluir"){
        excluirPessoa();
    }
}

// Faz conexao com banco de dados

function abrirBanco(){
    $conexao = new mysqli("localhost", "root", "", "pessoa");
    return $conexao;
}

//passa os dado informado pelo usuario e insere no banco

function inserirPessoa(){
    $banco = abrirBanco();
    $sql = "INSERT INTO pessoa(nome, telefone, endereco, nascimento) "
            . "VALUES ('{$_POST["nome"]}','{$_POST["telefone"]}','{$_POST["endereco"]}','{$_POST["nascimento"]}')";
    $banco->query($sql);
    $banco->close();
    voltarIndex();
}

// Altera
function alterarPessoa(){
    $banco = abrirBanco();
    $sql = "UPDATE pessoa SET nome='{$_POST["nome"]}',"
            . "nascimento='{$_POST["nascimento"]}',endereco='{$_POST["endereco"]}',"
            . "telefone='{$_POST["telefone"]}' WHERE id='{$_POST["id"]}'";
    $banco->query($sql);
    $banco->close();
    voltarIndex();
}

// Deleta
function excluirPessoa(){
    $banco = abrirBanco();
    $sql = "DELETE FROM pessoa WHERE id='{$_POST["id"]}'";
    $banco->query($sql);
    $banco->close();
    voltarIndex();
}

function selectAllPessoa(){
    $banco = abrirBanco();
    $sql = "SELECT * FROM pessoa ORDER BY nome";
    $resultado = $banco->query($sql);
    $banco->close();
    while ($row = mysqli_fetch_array($resultado)) {
        $grupo[] = $row;
    }
    return $grupo;
}

function selectIdPessoa($id){
    $banco = abrirBanco();
    $sql = "SELECT * FROM pessoa WHERE id =".$id;
    $resultado = $banco->query($sql);
    $banco->close();
    $pessoa = mysqli_fetch_assoc($resultado);
    return $pessoa;
}

function voltarIndex(){
    header("Location:index.php");
}