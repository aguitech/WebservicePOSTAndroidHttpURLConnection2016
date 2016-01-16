# WebservicePOSTAndroidHttpURLConnection2016
Webservice Android con conexión POST con HttpURLConnection Enero 2016

Si deseas hacer funcionar este ejemplo tienes que colocar el siguiente código PHP

------
	<?php
	$response["result"] = array();
	if(isset($_POST["name"])){
		$name = $_POST["name"];
		$reply = array();
		$reply["reply"] = "Bienvenido " . $name;
		array_push($response["result"], $reply);
		$response["success"] = 1;
		echo json_encode($response);
	}else{
		$response["message"] = "Campos requeridos perdidos";
		$response["success"] = 0;
		echo json_encode($response);
	}
	?>

16 Enero 2016
1:50 am Ciudad de México
Saludos.

Héctor Aguilar
hector@aguitech.com

Desarrollador de Software
Web / PHP / Android / iOS / HTML5 / CSS3 / JavaScript / jQuery / JSON / XML

FrontEnd / BackEnd / Senior Developer

![Black Lion Software Company](http://blacklionsoftwarecompany.com/web/images/black-logo.png "Black Lion Software Company")

