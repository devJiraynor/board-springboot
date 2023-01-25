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
@Entity(name="Liky")
@Table(name="Liky")
public class LikyEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int likeId;
	private int boardNumber;
	private String userEmail;
	private String likeUserProfile;
	private String likeUserNickname;
}
