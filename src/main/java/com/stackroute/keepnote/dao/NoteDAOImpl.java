package com.stackroute.keepnote.dao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.keepnote.model.Note;

/*
 * This class is implementing the NoteDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus 
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */
@Repository
@Transactional
public class NoteDAOImpl implements NoteDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
@Autowired
private SessionFactory sessionFactory;

	public NoteDAOImpl(SessionFactory sessionFactory) {
       this.sessionFactory= sessionFactory;
	}
	
	/*
	 * Save the note in the database(note) table.
	 */

	public boolean saveNote(Note note) {
		Session session = sessionFactory.getCurrentSession();
		Boolean status = false;
		if(session.save(note)!=null || session.save(note)!="") {
			status= true;
		}
		return status;

	}

	/*
	 * Remove the note from the database(note) table.
	 */

	public boolean deleteNote(int noteId) {
		Session session = sessionFactory.getCurrentSession();
		Boolean status = true;
		session.delete(getNoteById(noteId));
		if(getNoteById(noteId)!=null) {
			status = false;
		}
		return status;

	}

	/*
	 * retrieve all existing notes sorted by created Date in descending
	 * order(showing latest note first)
	 */
	public List<Note> getAllNotes() {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Note");
		List<Note> notes = query.list();
		
	notes=	notes.stream().sorted(Comparator.comparing(Note::getCreatedAt).reversed()).collect(Collectors.toList());
		
		return notes;

	}

	/*
	 * retrieve specific note from the database(note) table
	 */
	public Note getNoteById(int noteId) {
		Session session = sessionFactory.getCurrentSession();
		Note n=session.get(Note.class,noteId);
		return n;

	}

	/* Update existing note */

	public boolean UpdateNote(Note note) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(note);
		return true;

	}

}
