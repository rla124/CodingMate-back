package com.creativesemester.SejongCodingMate.domain.member.entity;


import com.creativesemester.SejongCodingMate.domain.chapter.entity.Chapter;
import com.creativesemester.SejongCodingMate.domain.story.entity.Story;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "STORY_ID")
	private Story story;

	@OneToOne
	@JoinColumn(name = "CHAPTER_ID")
	private Chapter chapter;

	@NotNull
	@Column(unique = true, nullable = false)
	private String memberId;

	@NotNull
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private Boolean hasTemporaryPassword;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Role role;


	public static Member createMemberHavingUserRole(String memberId, String password, Story story, Chapter chapter, Boolean hasTemporaryPassword) {
		return Member.builder()
			.memberId(memberId)
			.password(password)
			.story(story)
			.chapter(chapter)
			.hasTemporaryPassword(hasTemporaryPassword)
			.role(Role.USER)
			.build();
	}

	public static Member createMemberHavingAdiminRole(String memberId, String password, Story story, Chapter chapter, Boolean hasTemporaryPassword) {
		return Member.builder()
			.memberId(memberId)
			.password(password)
			.story(story)
			.chapter(chapter)
			.hasTemporaryPassword(hasTemporaryPassword)
			.role(Role.ADMIN)
			.build();
	}

	public void changePassword(String newPassword) {
		this.password = newPassword;
	}

	public void changeStory(Story story) {
		this.story = story;
	}

	public void changeChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public void changeHasTemporaryPassword(Boolean hasTemporaryPassword) {
		this.hasTemporaryPassword = hasTemporaryPassword;
	}
}
