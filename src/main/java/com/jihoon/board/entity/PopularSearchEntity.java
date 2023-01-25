package com.jihoon.board.entity;

import javax.persistence.Entity;
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
@Entity(name="PopularSearch")
@Table(name="PopularSearch")
public class PopularSearchEntity {
	@Id
	private String popularTerm;
	private int popularSearchCount;
}
