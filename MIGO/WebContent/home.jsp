<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"   "http://www.w3.org/TR/html4/loose.dtd">
   
<html>
<head>
<meta charset="UTF-8">
<title>MIGO SEO Portal</title>
</head>
	<body>  
      <form action = fileUpload enctype="multipart/form-data" method = "post" >
		<table class="horizontal-center">
		<tr>
		<td colspan=2>
			<h3>MIGO SEO Portal -- > Accessing Info --> Image Upload Form</h3>
		</td>
		</tr>
		    <tr>
		        <td>Select a Image to Upload</td>
		        <td>
		           <input type = "file" name = "file" size = "50" />
		        </td>
		        <td>
		            <input type="submit" value="upload" name='upload'/>
		        </td>
		    </tr>
		</table>
	</form>
	
	<form action="retriveFiles" method="post">
		<table class="horizontal-center">
			<tr>
				<td colspan=2>
					<input type="submit" value="Retrive Files From Server" name='retriveFiles'/>
				<td>
			</tr>
		</table>	
	</form>
   </body>
   
   <style>
	.horizontal-center {
	  margin-top: 10%;
	  margin-left: auto;
	  margin-right: auto;
	}
</style>

</html>