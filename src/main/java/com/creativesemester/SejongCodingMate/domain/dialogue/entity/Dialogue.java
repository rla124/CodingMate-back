package com.creativesemester.SejongCodingMate.domain.dialogue.entity;


import com.creativesemester.SejongCodingMate.domain.dialogue.dto.request.DialogueRequestDto;
import com.creativesemester.SejongCodingMate.domain.story.entity.Story;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash("Dialogue")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dialogue {

	@Id
	private Long storyId;

	private String speaker;

	private String text;

	private Long screenEffect;

	private Long soundEffect;

	private String characterImage;


	public static Dialogue of(DialogueRequestDto dialogueRequestDto, Story story) {
		return Dialogue.builder()
			.storyId(story.getId())
			.speaker(dialogueRequestDto.getSpeaker())
			.text(dialogueRequestDto.getText())
			.screenEffect(dialogueRequestDto.getScreenEffect())
			.soundEffect(dialogueRequestDto.getSoundEffect())
			.characterImage(dialogueRequestDto.getCharacterImage())
			.build();
	}

}
