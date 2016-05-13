<?php

class sistemaBancario {

    private $nome;
    private $endereco;

    public function getNome() {
        return $this->nome;
    }

    public function getEndereco() {
        return $this->endereco;
    }

    public function atualizarContas() {
        
    }
    
     public function __construct() {
        var_dump($this);
        echo "<br>";
    }

}

$b1 = new Banco();
$b2 = new Banco();

unset($b2);
    echo "<br> ------------------------ <br>";
    var_dump($b1);
    echo "<br>";
    var_dump($b1);