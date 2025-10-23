package com.example.note_taker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.note_taker.Repo.NoteRepo;
import com.example.note_taker.entity.Note;

@Controller
public class NoteController {

	@Autowired
	private NoteRepo noteRepo;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("notes", noteRepo.findAll());
		return "index";
	}

	@GetMapping("/add")
	public String addNotePage(Model model) {
		model.addAttribute("note", new Note());
		return "add_note";
	}

	@PostMapping("/save")
	public String saveNote(@ModelAttribute Note note) {
		noteRepo.save(note);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String editNotePage(@PathVariable Long id, Model model) {
		model.addAttribute("note", noteRepo.findById(id).orElse(null));
		return "edit_note";
	}

	@PostMapping("/update")
	public String updateNote(@ModelAttribute Note note) {
		noteRepo.save(note);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteNote(@PathVariable Long id) {
		noteRepo.deleteById(id);
		return "redirect:/";
	}

}
