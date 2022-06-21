<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><!DOCTYPE html>
<html>
	<head>
		<title>List of Albums</title>
	</head>
	
	<body>
	
		<input type="button" value="Add Album" onclick="window.location.href='addForm'; return false;"/>
			
			<table>
					<tr>
						<th>Album Name</th>
						<th>Artist</th>
						<th>Rating</th>
						<th>Action</th>
					</tr>
					
					<!-- loop over and print out customers | ${album} is attribute name from spring MVC model  -->
					<c:forEach var="tempAlbum" items="${albums}">
					
						<c:url var="updateLink" value="/album/updateForm">
							<c:param name="albumId" value="${tempAlbum.id}" />
						</c:url>
						
						<c:url var="deleteLink" value="/album/delete">
							<c:param name="albumId" value="${tempAlbum.id}" />
						</c:url>
						
						<tr>
							<td> ${tempAlbum.albumArtist} </td>
							<td> ${tempAlbum.albumName} </td>
							<td> ${tempAlbum.rating} </td>
							
							<td>
								<a href="${updateLink}">Update</a>
								<a href="${deleteLink}"
								onClick="if (!(confirm('Are you sure you want to delete this album?'))) return false">Delete</a>
							</td>
							
						</tr>
					
					</c:forEach>
					
					
					
				
				</table>
	
	</body>



</html>
