<?php

	// se o usuário não estiver logado, vamos abrir o formulário de login
	// mas, se o usuário estiver logado, vamos mostrar uma mensagem de boas vindas
	// e mostrar também o seu nome de usuário
	
	// iniciar o uso de sessão
	session_start();
	
	$titulo = "Video aula 12 - login";
	
	if(isset($_GET['ac']) && $_GET['ac'] == "logout" && isset($_SESSION['usuario'])) {
		unset($_SESSION['usuario']);
	}
	
	if(isset($_POST['usuario']) && $_POST['usuario'] == "admin" && isset($_POST['senha']) && $_POST['senha'] == "123") {
		$_SESSION['usuario'] = $_POST['usuario'];
	}
	
	if(isset($_SESSION['usuario'])) {
		// o usuário está logado
		require_once("tmpl_administrativo.php");
	} else {
		// o usuário não está logado
		require_once("tmpl_formularioLogin.php");
	}
	