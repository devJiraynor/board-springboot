package com.jihoon.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Board")
@Table(name="Board")
public class BoardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boardNumber;
	private String boardTitle;
	private String boardContent;
	private String boardImage;
	private String boardVideo;
	private String boardFile;
	private String boardWriterEmail;
	private String boardWriterProfile;
	private String boardWriterNickname;
	private String boardWriteDate;
	private int boardClickCount;
	private int boardLikeCount;
	private int boardCommentCount;
}
