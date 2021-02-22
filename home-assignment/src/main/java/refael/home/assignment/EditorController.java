package refael.home.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EditorController {
	
	@Autowired
	private EditorService editorService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/edit")
	public void add(@RequestBody String s) {
		editorService.add(s);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/edit/{position}")
	public void add(@RequestBody String s, @PathVariable int position) {
		editorService.add(s, position);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/edit/{fromPosition}/{toPosition}")
	public void remove(@PathVariable int fromPosition, @PathVariable int toPosition){
		editorService.remove(fromPosition, toPosition);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/edit/italic/{fromPosition}/{toPosition}")
	public void italic(@PathVariable int fromPosition, @PathVariable int toPosition){
		editorService.italic(fromPosition, toPosition);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/edit/bold/{fromPosition}/{toPosition}")
	public void bold(@PathVariable int fromPosition, @PathVariable int toPosition){
		editorService.bold(fromPosition, toPosition);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/edit/underline/{fromPosition}/{toPosition}")
	public void underline(@PathVariable int fromPosition, @PathVariable int toPosition){
		editorService.underline(fromPosition, toPosition);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/edit/redo")
	public void redo(){
		editorService.redo();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/edit/undo")
	public void undo() {
		editorService.undo();
	}
	@RequestMapping("/edit/print")
	public String print(){
		return editorService.print();
	}
}
