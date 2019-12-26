<!DOCTYPE html>
<html lang="en">

<head>
<title>Keep-Board</title>
</head>

<body>
<form action="add" method="post">
<table>
<tr><td>Note Title </td><td><input type = "text" name="noteTitle"></td></tr>
<tr><td>Note Content </td><td><input type = "text" name="noteContent"></td></tr>
<tr><td>Note Status </td>
<td>
<select name="noteStatus">
<option value="Not Started">Not Started</option>
<option value="Started">Started</option>
<option value="InProgress">InProgress</option>
<option value="Completed">Completed</option></select>
</td></tr>
<tr><td><input type="submit" value="send">
</table>
</form>
<table>
<c:forEach items="${noteList}" var="note">
<tr><td>${note.noteId}</td><td>${note.noteTitle}</td><td>${note.noteContent}</td><td>${note.noteStatus}</td><td>${note.createdAt}</td><td><a href="delete?noteId=${note.noteId}">DELETE</a></td><td><a href="update/?noteId=${note}">UPDATE</a></td></tr> 
</c:forEach>
</table>
	<!-- Create a form which will have text boxes for Note title, content and status along with a Add 
		 button. Handle errors like empty fields.  (Use dropdown-list for NoteStatus) -->

	<!-- display all existing notes in a tabular structure with Title,Content,Status, Created Date and Action -->
</body>

</html>