package com.homeis.qna.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeis.qna.dto.Qna;
import com.homeis.qna.dto.QnaComment;
import com.homeis.qna.model.service.QnaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/qna")
@RequiredArgsConstructor
public class QnaController {
	private final QnaService qnaService;
	
	@PostMapping("/list")
	public ResponseEntity<List<Qna>> list(Qna qna) {
		List<Qna> qnas = qnaService.selectAll(qna);
		return ResponseEntity.ok(qnas);
	}
	
	@PostMapping("/detail")
	public ResponseEntity<List<QnaComment>> detail(@ModelAttribute Qna qna) {
		List<QnaComment> qnaComments = qnaService.findById(qna);
		return ResponseEntity.ok(qnaComments);
	}
	
	@PostMapping("/insert-question")
	public ResponseEntity<?> registQuestion(@ModelAttribute Qna qna) {
		int result = qnaService.insertQuestion(qna);
		
		if(result == 0) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/insert-answer")
	public ResponseEntity<?> registAnswer(@ModelAttribute QnaComment qnaComment) {
		int result = qnaService.insertAnswer(qnaComment);
		
		if(result == 0) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@ModelAttribute Qna qna) {
		int result = qnaService.updateQna(qna);
		
		if(result == 0) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@ModelAttribute Qna qna) {
		int result = qnaService.deleteQna(qna);
		
		if(result == 0) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().build();
	}
}