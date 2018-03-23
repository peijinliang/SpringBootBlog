package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blog.domain.Vote;

/**
 * Vote Repository接口
 *
 * @author Marlon
 * @since 1.0.0 2017年6月6日
 */

public interface VoteRepository extends JpaRepository<Vote, Long> {


}
