<?php
	// vamos receber uma variável chamada r que significa rota
	
	$r = $_GET['r'];
	
	require_once($r."/index.php");
	