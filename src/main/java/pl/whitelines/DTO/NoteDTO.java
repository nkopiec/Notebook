package pl.whitelines.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class NoteDTO {
	@Size(min=5, max=20, message="{Size.NoteDTO.title.validation}")
	@NotNull(message= "{NotNull.NoteDTO.title.validation}")
	private String title;
	@Size(min=5, max=1000, message="{Size.NoteDTO.text.validation}")
	private String text;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
