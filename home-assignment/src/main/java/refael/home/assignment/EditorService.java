package refael.home.assignment;

import org.springframework.stereotype.Service;

@Service
public class EditorService {
	
	private StringBuilder txt = new StringBuilder();
	private StringBuilder undo = new StringBuilder();
	private StringBuilder redo = new StringBuilder();
	
	public void add(String s){
		undoRedo(undo, txt.toString());
		txt.append(s);
	}
	
	public void add(String s, int position) {
		undoRedo(undo, txt.toString());
		if(position < s.length()){
			txt.insert(position, s);
		}
	}
	
	public void remove(int fromPosition, int toPosition){
		undoRedo(undo, txt.toString());
		txt.delete(fromPosition, toPosition);
	}
	
	public void italic(int fromPosition, int toPosition){
		undoRedo(undo, txt.toString());
		txt.insert(fromPosition, "<i>");
		txt.insert(toPosition + 3, "</i>");
	}
	
	public void bold(int fromPosition, int toPosition){
		undoRedo(undo, txt.toString());
		txt.insert(fromPosition, "<b>");
		txt.insert(toPosition + 3, "</b>");
	}
	
	public void underline(int fromPosition, int toPosition){
		undoRedo(undo, txt.toString());
		txt.insert(fromPosition, "<u>");
		txt.insert(toPosition + 3, "</u>");
	}

	public void redo(){
		undoRedo(undo, txt.toString());
		txt = redo;
	}
	
	public void undo() {
		undoRedo(redo, txt.toString());
		txt = undo;
	}
	
	public String print(){
		return txt.toString();
	}
	
	private void undoRedo(StringBuilder s, String str){
		if(!str.isEmpty()){
			if(s.length() != 0){
				s.delete(0, s.length());
			}
			s.append(str);
		}
	}
}
