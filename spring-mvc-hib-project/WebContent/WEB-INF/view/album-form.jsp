<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><!DOCTYPE html>
<html>
	<head>
		<title>Save Album</title>
		
		
	</head>
	
	<body>
	
		<form:form action="saveAlbum" modelAttribute="album" method="POST">
			
				<!-- need to associate this data with customer id -->
				<!-- if a new customer is being created, this will be null -->
				<!-- but when pre-populating the fields, this is necessary to hold the customer id -->
				<form:hidden path="id"/>
				
				<table>
					<tbody>
						<tr>
							<td><label>Artist:</label></td>
							<td><form:input path="albumArtist" /></td>
						</tr>
						
						<tr>
							<td><label>Album Name:</label></td>
							<td><form:input path="albumName" /></td>
						</tr>
						
						<tr>
							<td><label>Rating:</label></td>
							<td><form:input path="rating" /></td>
						</tr>
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save"/></td>
						</tr>

					</tbody>
					
				<p>
					<a href="${pageContext.request.contextPath}/album/list">Back to List</a>
				</p>
				
				
				</table>
		</form:form>
	</body>



</html>