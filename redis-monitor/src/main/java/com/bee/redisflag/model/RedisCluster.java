package com.bee.redisflag.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class RedisCluster {
	private String name;
	private List<RedisNode> nodes;
	private List<RedisCluster> children;



	public RedisCluster(String name) {
		this.name = name;
	}



}
