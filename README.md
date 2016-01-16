# WebservicePOSTAndroidHttpURLConnection2016
Webservice Android con conexión POST con HttpURLConnection Enero 2016

Si deseas hacer funcionar este ejemplo tienes que colocar el siguiente codigo PHP

<?php
$response["result"] = array();
if(isset($_POST["name"])){
	$name = $_POST["name"];
	
	$reply = array();
	$reply["reply"] = "Welcome To " . $name;
	array_push($response["result"], $reply);
	$response["success"] = 1;
	echo json_encode($response);
	
}else{
	$response["message"] = "Campos requeridos perdidos";
	$response["success"] = 0;
	echo json_encode($response);
}
?>
