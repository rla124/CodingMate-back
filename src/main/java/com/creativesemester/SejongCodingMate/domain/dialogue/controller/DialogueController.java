package com.creativesemester.SejongCodingMate.domain.dialogue.controller;

import com.creativesemester.SejongCodingMate.domain.dialogue.dto.request.DialogueRequestDto;
import com.creativesemester.SejongCodingMate.domain.dialogue.service.DialogueService;
import com.creativesemester.SejongCodingMate.global.response.GlobalResponseDto;
import com.creativesemester.SejongCodingMate.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dialogue")
public class DialogueController {

    private final DialogueService dialogueService;

    // 1. 대화 생성 (POST)
    @PostMapping
    public ResponseEntity<GlobalResponseDto> createDialogue (@RequestBody DialogueRequestDto dialogueRequestDto){
        return dialogueService.createDialogue(dialogueRequestDto);
    }

    // 2. 대화 단일 조회 (GET)
    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponseDto> getDialogue (@AuthenticationPrincipal UserDetailsImpl userDetails,
                                                          @PathVariable Long id){
        return dialogueService.getDialogue(userDetails.getMember(), id);
    }



}
