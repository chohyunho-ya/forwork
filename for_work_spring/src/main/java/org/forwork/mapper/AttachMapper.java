package org.forwork.mapper;

import java.util.List;

import org.forwork.domain.Attach;

public interface AttachMapper {

	public void insert(Attach attach);
	public void delete(String uuid);
	public List<Attach> findByPost(Long post_id);
	public void deleteAll(Long post_id);
}
